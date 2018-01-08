package com.ghc.java.study.demo.domain.po;


import com.ghc.java.study.demo.common.annotations.NotNull;

/**
 * <p> </p>
 *
 * @Author : gonghongcai.
 * @Date : 2017/12/7 23:52.
 * @Description :
 */

public class Student {
    private int id;
    @NotNull("学生姓名")
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
