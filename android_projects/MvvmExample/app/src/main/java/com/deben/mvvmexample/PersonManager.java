package com.deben.mvvmexample;

public class PersonManager {

    public Person getPerson(String name, String email) {
        return new Person(name, email);
    }
}
