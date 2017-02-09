package com.example.tests;

import java.util.Random;

/**
 * Created by SYSTEM on 09.02.2017.
 */
public class Sample {

    public static void main (String [] args){
        Random rnd = new Random();
        String x = "" + rnd.nextInt(1);
        //При сравнивании НЕ ЧИСЕЛ нужно использовать метод equals
        if ("0".equals(x)){
            System.out.println("ok");
        }else{
            System.out.println("fail");
        }


    }

}
