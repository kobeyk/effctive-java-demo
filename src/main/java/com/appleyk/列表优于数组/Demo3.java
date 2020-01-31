package com.appleyk.列表优于数组;

import java.util.ArrayList;

/**
 * <p>列表优于数组</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 16:03 2020/1/31
 */
public class Demo3 {

    /**泛型擦除*/
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("123");
        //编译错误  , 属于编译前检查，如果编辑后检查，就晚了，因为泛型对象会在编译时擦除原始类型，统一变为Object类型
//        list.add(123);
    }
}
