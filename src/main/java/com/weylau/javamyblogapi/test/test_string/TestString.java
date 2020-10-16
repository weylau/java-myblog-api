package com.weylau.javamyblogapi.test.test_string;


import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TestString {
    public static void main(String[] args) {
        //对象排序

        List<P> personList = new ArrayList<P>();
        personList.add(new P("ace",22, 178));
        personList.add(new P("xb",21,169));
        personList.add(new P("glm",36,197));
        personList.add(new P("sxy",20,156));
        //根据年龄正序排序
        Collections.sort(personList);
        for(P p:personList)
            System.out.println(p);
        System.out.println();

        //根据身高正序排序
        personList.sort(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                if(o1.getHeight() > o2.getHeight()) {
                    return 1;
                } else if(o1.getHeight() < o2.getHeight()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for(P p:personList)
            System.out.println(p);
        System.out.println();

    }
}

@Data
class P implements Comparable<P> {

    String name;
    int age;
    int height;
    public P(String name,int age,int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", height=" + height + "]";
    }

    @Override
    public int compareTo(P o) {
        //根据年龄正序排序
        return this.age-o.age;
    }
}


