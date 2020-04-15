package com.lucida.kotlinbase.base.unit3;

import java.io.File;

import kotlin.io.FilesKt;
import kotlin.text.Charsets;
import kotlin.text.CharsetsKt;

public class TestDemo {
    public static void main(String[] args) {

    }

    private void testReadText(){
        File file = new File("local.properties");
        String content = UtilsKt.readText(file, Charsets.UTF_8);
        String temp = FilesKt.readText(file, Charsets.UTF_8);
//        System.out.println(content);
        System.out.println(temp);
    }

    private void testThread(){
        Thread thread = new Thread(()->{

        });
        thread.start();
    }
}
