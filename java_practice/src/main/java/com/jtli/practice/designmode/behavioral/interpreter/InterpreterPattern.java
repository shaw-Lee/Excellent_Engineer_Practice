package com.jtli.practice.designmode.behavioral.interpreter;

/**
 * @Classname InterpreterPattern
 * @Description <p>
 * 给分析对象定义一个语言，并定义该语言的文法表示，
 * 再设计一个解析器来解释语言中的句子。也就是说，
 * 用编译语言的方式来分析应用中的实例。这种模式实现了文法表达式处理的接口，该接口解释一个特定的上下文。
 * </p>
 * @Date 2023/2/22 20:11
 * @Author by jtlee
 * @Version 1.0.0
 */
public class InterpreterPattern {

}


//抽象表达式
interface AbstractExpression {

    public Object interpret(String info);//解释方法
}

//终结符表达式类
class TerminalExpression implements AbstractExpression {

    @Override
    public Object interpret(String info) {
        //对终结符表达式的处理
        return null;
    }
}

//非终结符表达式类
class NonterminalExpression implements AbstractExpression {

    private AbstractExpression expression1;
    private AbstractExpression expression2;

    @Override
    public Object interpret(String info) {
        //非对终结符表达式的处理
        return null;
    }
}

//环境类
class Context {
    private AbstractExpression expression;

    public Context() {
        //数据初始化
    }

    public void operation(String info) {
        //调用相关表达式类的解释方法
    }
}
