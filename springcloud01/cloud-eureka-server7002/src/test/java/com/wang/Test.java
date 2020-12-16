package com.wang;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaowang
 * @time 2020-12-09 15:23
 **/

public class Test {


    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.MAX_VALUE)));
    }
}
