package com.appleyk.列表优于数组;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>列表优于数组</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 16:21 2020/1/31
 */
public class Demo4 {

    /**泛型擦除*/
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        /**由于泛型擦除，下面这种判断方式是错误的*/
//        System.out.println(list instanceof ArrayList<String>);
        /**由于泛型擦除，下面这种判断方式是没问题的*/
        System.out.println(list instanceof ArrayList);
    }
}
