package com.dancer.utils;

import java.util.Date;
import java.util.UUID;

/**
 * 随机生成id
 * 董红广
 * 2019-04-25
 */
public class GenerateID {

    public static String getID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args){
        System.out.print(getID());
    }

}
