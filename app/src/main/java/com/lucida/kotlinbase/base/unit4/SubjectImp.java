package com.lucida.kotlinbase.base.unit4;

public class SubjectImp implements Subject {
    @Override
    public void say(String name) {
        System.out.println("hello:"+name);
    }
}
