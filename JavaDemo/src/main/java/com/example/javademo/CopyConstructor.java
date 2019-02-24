package com.example.javademo;

import java.io.Serializable;

public class CopyConstructor {
    public static void main(String[] args) {
        Age a=new Age(20);
        Person p=new Person(a,"张尧");
        changeAge(p);
    }

    // 测试浅拷贝
    private static void test1(){
        Age a=new Age(20);
        Person p1=new Person(a,"张尧");
        Person p2=new Person(p1);
        p1.print();
        p2.print();
        //修改p1的各属性值，观察p2的各属性值是否跟随变化
        p1.setName("小傻瓜");
        a.setAge(99);
        p1.print();
        p2.print();

        p1.setAge(18);
        System.out.println("修改后的p1是"+p1);
        System.out.println("修改后的p2是"+p2);
    }

    public void test2(){

    }

    public  static void changeAge(Person p){
        Person p1 = new Person(p);

        p1.setAge(18);
        p1.print();
        p.print();
    }
}

class Person implements Serializable {
    //两个属性值：分别代表值传递和引用传递
    private Age age;
    private String name;
    public Person(Age age,String name) {
        this.age=age;
        this.name=name;
    }
    //拷贝构造方法
    public Person(Person p) {
        this.name=p.name;
        this.age=p.age;
    }

    public int getAge() {
        return age.getAge();
    }

    public void setAge(int age) {
        this.age.setAge(age);
    }

    public void setName(String name) {
        this.name=name;
    }

    public String toString() {
        return this.name+" "+this.age;
    }

    public void print(){
        System.out.println(this.toString());
    }
}

class Age implements Serializable{
    private int age;
    public Age(int age) {
        this.age=age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return getAge()+"";
    }
}

