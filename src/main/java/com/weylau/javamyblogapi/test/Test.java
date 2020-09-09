package com.weylau.javamyblogapi.test;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {
    public static void main(String args[]) {
        Animal<String> a = new Animal<>();
        Dog d = new Dog();
        System.out.println(a instanceof Animal);
        System.out.println(d instanceof Animal);
        System.out.println(d instanceof Dog);
        //获取父类定义的T类型
        Type type = Dog.class.getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        Type[] types = pt.getActualTypeArguments();
        Class<?> clazz = (Class<?>) types[0];
        System.out.println(clazz);
    }
}

class Animal<T> {

}

class Dog<T> extends Animal<Integer> {
}
