package com.lucida.kotlinbase.base.unit4;

import java.lang.reflect.Proxy;

public class TestDemo {
    public static void main(String[] args) {
        StringUtils.Companion.isEmpty("");

        Subject subjectImp = new SubjectImp();
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(subjectImp.getClass().getClassLoader(),subjectImp.getClass().getInterfaces(),new SubjectProxy(subjectImp));
        subjectProxy.say("hello");
        //这样就为
    }
}
