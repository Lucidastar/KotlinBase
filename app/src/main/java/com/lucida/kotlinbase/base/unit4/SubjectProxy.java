package com.lucida.kotlinbase.base.unit4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectProxy implements InvocationHandler {
    private Subject mSubject;

    public SubjectProxy(Subject mSubject) {
        this.mSubject = mSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------------begin-------------");
        if (method.getName() == "say"){
            System.out.println("我执行了");
        }
        Object invoke = method.invoke(mSubject, args);//执行代理中被代理的对象的方法，也就是那个say方法，这样在不改变业务的情况下，增加一些其他操作，比如增加日志的拦截
        System.out.println("--------------end-------------");
        return invoke;
    }
}
