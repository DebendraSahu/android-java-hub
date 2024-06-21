package com.deben.recyclerviewexample;

import androidx.annotation.NonNull;

public class UserData {
    String name;
    int age;

    public UserData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @NonNull
    @Override
    public String toString() {
        return "UserData {" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
