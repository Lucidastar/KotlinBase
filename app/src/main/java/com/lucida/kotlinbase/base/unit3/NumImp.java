package com.lucida.kotlinbase.base.unit3;

public class NumImp implements NumInterface {

    public static NumInterface numInterface = new NumImp();

    @Override
    public void getNum(int num) {
        System.out.println("int");
    }

    @Override
    public void getNum(Integer num) {
        System.out.println("Integer");
    }
}
