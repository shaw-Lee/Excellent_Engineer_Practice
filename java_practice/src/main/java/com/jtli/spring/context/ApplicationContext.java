package com.jtli.spring.context;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.beans.Introspector;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @Classname ApplicationContext
 * @Description <p>
 * 自定义ApplicationConetxt
 * </p>
 * @Date 2023/3/18 10:16
 * @Author by jtlee
 * @Version 1.0.0
 */
public class ApplicationContext {

    private Class<?> clazz;

    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

    private Map<String, Object> singletonObjects = new HashMap<>();

    private List<BeanPostProcessor> processorList = new ArrayList<>();

    public ApplicationContext(Class<?> clazz) {
        this.clazz = clazz;
        // 扫包
        scan(clazz);

        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton") && !beanDefinition.isLazy()) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    private Object createBean(String beanName,BeanDefinition beanDefinition) {

        Class clazz = beanDefinition.getType();

        try {
            Object o = clazz.newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Object bean = getBean(field.getName());
                    field.setAccessible(true);
                    field.set(o, bean);
                }
            }

            // 自定义bean前置处理过程
            for (BeanPostProcessor beanPostProcessor : processorList) {
                o = beanPostProcessor.postProcessBeforeInitialization(o, beanName);
            }
            // 是否实现了初始化接口
            if (o instanceof Initializingbean) {
                ((Initializingbean)o).afterPropertiesSet();
            }
            // 自定义bean后置处理过程
            for (BeanPostProcessor beanPostProcessor : processorList) {
                o = beanPostProcessor.postProcessAfterInitialization(o, beanName);
            }

            // beanName 回调
            if (o instanceof BeanNameAware) {
                ((BeanNameAware)o).setBeanName(beanName);
            }
            // 上下文初始化回调
            if (o instanceof ApplicationContextAware) {
                ((ApplicationContextAware)o).setApplicationContext(this);
            }

            if (clazz.isAnnotationPresent(Transactional.class)) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(clazz);
                Object target = o;
                enhancer.setCallback((MethodInterceptor) (proxy, method, objects, methodProxy) -> {
                    System.out.println("开启事务");
                    Object result = method.invoke(target, objects);
                    System.out.println("提交事务");
                    return result;
                });
                o = enhancer.create();
            }

            return o;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (beanDefinition == null) {
            throw new NullPointerException();
        }

        if ("singleton".equals(beanDefinition.getScope())) {
            Object result = singletonObjects.get(beanName);
            if (result == null) {
                result = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, result);
            }
            return result;
        } else {
            return createBean(beanName, beanDefinition);
        }
    }

    public void scan(Class clz) {
        if (clz.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = (ComponentScan) clz.getAnnotation(ComponentScan.class);
            // 获取注解上标注的扫描路径
            String path = componentScan.value();
            // 替换为可用的文件路径
            path = path.replace(",", "/");
            ClassLoader classLoader = this.getClass().getClassLoader();
            // 通过类加载器加载指定位置下的资源 .class
            URL resource = classLoader.getResource("com/jtli/spring/service");


            File file = new File(resource.getFile());

            List<File> resoureList = new ArrayList<>();
            if (file.isDirectory()) {
                for (File f : Objects.requireNonNull(file.listFiles())) {
                    if (f.isDirectory()) {
                        for (File f1 : f.listFiles()) {
                            if (!f1.isDirectory()) {
                                resoureList.add(f1);
                            }
                        }
                    } else {
                        resoureList.add(f);
                    }
                }
            }

            // loadClass
            for (File classFile : resoureList) {
                String absolutePath = classFile.getAbsolutePath();
                // 转为为可用类路径
                String className = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"))
                        .replace("\\", ".");

                try{
                    // 通过类加载器加载class到内存
                    Class<?> loadClass = classLoader.loadClass(className);
                    // 当前类是否标注Component注解
                    if (loadClass.isAnnotationPresent(Component.class)) {
                        //  是否实现了BeanPostProcessor 接口
                        if (BeanPostProcessor.class.isAssignableFrom(loadClass)) {
                            BeanPostProcessor instance = (BeanPostProcessor) loadClass.getConstructor().newInstance();
                            processorList.add(instance);
                        }
                        // 获取构造器生成对象并生成BeanDefinition
                        BeanDefinition beanDefinition = new BeanDefinition();
                        beanDefinition.setType(loadClass);
                        // 是否需要懒加载
                        beanDefinition.setLazy(loadClass.isAnnotationPresent(Lazy.class));
                        // 单例还是原型
                        if (loadClass.isAnnotationPresent(Scope.class)) {
                            beanDefinition.setScope(loadClass.getAnnotation(Scope.class).value());
                        } else {
                            beanDefinition.setScope("singleton");
                        }
                        // 指定BeanName
                        String beanName = loadClass.getAnnotation(Component.class).value();

                        if (beanName.isEmpty()) {
                            beanName = Introspector.decapitalize(loadClass.getSimpleName());
                        }
                        // 放入BeanDefinitionMap
                        beanDefinitionMap.put(beanName, beanDefinition);
                    }

                }catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
