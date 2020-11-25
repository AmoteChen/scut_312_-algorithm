package com.csy.www;

interface Lamdatest {
    void print(String message);
}

public class Lamda{
public static void main(String[]args){
    Lamdatest test,test1,test2;
    test=(String message)->{
        System.out.println(message);
    };
    test.print("我吃火龙果");
    //可以去掉参数类型名和括号本身
    test1= message ->{
        System.out.println(message);
    };
    test1.print("我吃火龙果");

    //可以去掉大括号,但是表达式里面如果有多行代码，就不能省略
    test2 = message -> System.out.println(message);
    test2.print("我吃蓝莓果");

    }
}


