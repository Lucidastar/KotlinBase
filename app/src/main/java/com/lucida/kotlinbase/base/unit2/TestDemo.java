package com.lucida.kotlinbase.base.unit2;

public class TestDemo {
    public static void main(String[] args) {
        KUtilsKt.echo("Utils");
        Test.INSTANCE.say("say");
        //java中调用kotlin的class参数
        JUtils.checkKtClass(KUtilsKt.class);
    }
}
