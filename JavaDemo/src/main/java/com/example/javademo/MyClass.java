package com.example.javademo;

public class MyClass {
    public static void main(String[] args){
        //System.out.println("This is Java Demo");

        String strings = "this is java demo 哈哈";
        System.out.println(strings);

        String all = String.join("/", "S", "M", "L", "XL");
        System.out.println(all);

        // 1.length 是数组的属性
        // 2.length() 是字符串Strin的一个方法
        // 3.size() 是List集合的一个方法
        int length1 = all.length();
        String [] list = {"aa", "bb","cc"};
        int length2 = list.length;

        String trims = " 123qwer asdf 34  ";
        System.out.println(trims.trim());

        double d = 1000000000 / 3.0;
        System.out.printf("%8.2f", d);

    }
}
