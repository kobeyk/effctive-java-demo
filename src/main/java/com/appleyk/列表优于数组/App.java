package com.appleyk.列表优于数组;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>列表优于数组</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 15:13 2020/1/31
 */
public class App {

    /**
     * 列表优于数组
     * 证明泛型对象在编译时其类型会被“抹掉”（擦除）
     */
    public static void main(String[] args) throws Exception{

        /**案例A*/
        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<String>  b = new ArrayList<>();
        System.out.println("a和b的类型是否相等呢："+(a.getClass() == b.getClass()));

        /**案例B*/
        /**正常来说，调用add方法只能给a添加Integer的变量值，但是，通过反射调用add方法时，却可以添加任意类型的值，比如String*/
        a.getClass().getMethod("add",Object.class).invoke(a,"hello");
        /**下面输出结果：2，不用怀疑，这是因为泛型在编译时擦除类型了，所以，实际上a列表里既有Integer类型又有String类型*/
        System.out.println(a.size());
        /**打印第二个元素，输出hello是ok的*/
        System.out.println(a.get(1));
        /**但是，你要用int类型接收第二个元素，那就有问题了：ClassCastException*/
        int i = a.get(1);

    }

    /**
     * 总之，数组和泛型具有非常不同的类型规则。 数组是协变和具体化的; 泛型是不变的，类型擦除的。
     * 因此，数组提供运行时类型的安全性，但不提供编译时类型的安全性.对于泛型则是相反。
     * 数组在编译时是通过的，但是运行时可能会报错（比如：ArrayStoreException）
     * 列表在编译时通过，但是编译后涉及类型擦除，就导致运行时得到的数据可能遇到类型转换异常（比如：ClassCastException）
     * 一般来说，数组和泛型不能很好地混合工作。
     * 如果你发现把它们混合在一起，得到编译时错误或者警告，你的第一个冲动应该是用列表来替换数组。
     */

}
