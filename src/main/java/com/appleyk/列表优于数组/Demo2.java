package com.appleyk.列表优于数组;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>列表优于数组</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 16:02 2020/1/31
 */
public class Demo2 {

    /**
     * 列表优于数组
     * 编译通过，运行异常，因为类型不匹配
     */
    public static void main(String[] args) {
        // 泛型擦除，strList实际运行的类型是：List[]
        List<String>[] strLists = new List[1];
        // 泛型擦除，intList实际运行的类型是List
        List<Integer> intList = new ArrayList<>();
        intList.add(42);
        // 由于泛型擦除特性加上数组的协变特性，下面这句也是ok的
        Object[] objects = strLists;
        // 由于泛型擦除特性，这行依然毫无破绽
        objects[0] = intList;
        // 虽然数组类型标
        System.out.println(strLists.length);
        String s = strLists[0].get(0);
//        解释：
//        （1）new一个泛型数组，没问题
//        （2）再来一个Int类型的泛型，添加一个整数，一切都是ok的，对吧
//        （3）然后将泛型数组的引用给Object[]，这也是没问题的，因为数组有协变的特性
//        （4）接着我们把泛型对象，注意是Integer类型的对象intList赋给Object数组的第一个元素
//        （5）你猜怎么着，因为是引用类型，strLists数组肯定是有东西的
//        （6）取出第一个元素用String类型的s变量接收，等下，好像哪里有点问题，不对头啊？
//        （7）没错，取出来的元素是Integer类型，你却给了一个String类型...这，当然是运行抛ClassCastException啊！
    }

}
