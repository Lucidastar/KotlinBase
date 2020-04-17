package com.lucida.kotlinbase.base.unit6;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class TestDemo {

    public static void main(String[] args) {
        KotlinCode.doFunction(new Function1<Integer, Unit>() {
            @Override
            public Unit invoke(Integer integer) {
                return null;
            }
        });
    }

}
