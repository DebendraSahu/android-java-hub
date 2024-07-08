package com.deben.mvvmexample;

import androidx.annotation.NonNull;

public class Person {
    String name;
    String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return "Person: \n" + "name: " + name + '\n' + "email: " + email;
    }
}
