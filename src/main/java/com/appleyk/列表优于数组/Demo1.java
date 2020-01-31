package com.appleyk.列表优于数组;

/**
 * <p>列表优于数组</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 16:01 2020/1/31
 */
public class Demo1 {

    /**
     * 列表优于数组
     * 编译通过，但运行报错（数组存储异常 -- ArrayStoreException）
     */
    public static void main(String[] args) {
        Object[] objectArry = new Long[1];
        objectArry[0] = "这怎么可能行呢？";
//          数据特性：
//            （1）如果a是b的子类型，则a[]是b[]的子类型
//            （2）所以Object[] objectArry = new Long[1]是ok的，编译通过
//            （3）但是，你不可能把一个string类型的变量放到long类型的数组里，因此运行报错
    }

}
