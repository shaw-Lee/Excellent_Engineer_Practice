package com.jtli.practice.designmode.behavioral.visitor;

/**
 * @Classname VisitorTest
 * @Description <p>
 * 封装一些作用于某种数据结构中的各元素的操作，它可以在不改变这个数据结构的前提下定义作用于其内部各个元素的新操作
 * </p>
 * @Date 2023/2/23 21:00
 * @Author by jtlee
 * @Version 1.0.0
 */
public class VisitorTest {

}

class Prize {   //奖
    String name;   //比赛名称
    String level;    //等级

    public Prize(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}

interface Visitor {
    void visit(Prize prize);   //visit方法来访问我们的奖项
}

class Teacher implements Visitor {   //指导老师作为一个访问者
    @Override
    public void visit(Prize prize) {   //它只关心你得了什么奖以及是几等奖，这也关乎老师的荣誉
        System.out.println("你得奖是什么奖？"+prize.name);
        System.out.println("你得了几等奖？"+prize.level);
    }
}

class Boss implements Visitor{    //你的公司老板作为一个访问者
    @Override
    public void visit(Prize prize) {   //你的老板只关心这些能不能为公司带来什么效益，奖本身并不重要
        System.out.println("你的奖项大么，能够为公司带来什么效益么？");
        System.out.println("还不如老老实实加班给我多干干，别去搞这些没用的");
    }
}

class Classmate implements Visitor{   //你的同学也可以作为一个访问者
    @Override
    public void visit(Prize prize) {   //你的同学也关心你得了什么奖，不过是因为你是他的奖学金竞争对手，他其实并不希望你得奖
        System.out.println("你得了"+prize.name+"奖啊，还可以");
        System.out.println("不过这个奖没什么含金量，下次别去了");
    }
}

class Family implements Visitor{    //你的家人也可以是一个访问者
    @Override
    public void visit(Prize prize) {   //你的家人并不是最关心你得了什么奖，而是先关心你自己然后才是奖项，他们才是真正希望你好的人。这个世界很残酷，可能你会被欺负得遍体鳞伤，可能你会觉得活着如此艰难，但是你的背后至少还有爱你的人，为了他们，怎能就此驻足。
        System.out.println("孩子，辛苦了，有没有好好照顾自己啊");
        System.out.println("你得了什么奖啊？"+prize.name+"，很不错，要继续加油啊！");
    }
}
