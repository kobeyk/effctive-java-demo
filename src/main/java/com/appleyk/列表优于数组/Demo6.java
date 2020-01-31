package com.appleyk.列表优于数组;

/**
 * <p>列表优于数组</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 16:29 2020/1/31
 */
public class Demo6<T> {

    /**此T非方法getData的泛型T，不一样*/
    T data;

    /**
     * 编译通过
     * @param <T> 要返回的数据
     * @return 泛型T类型的结果
     */
    static <T> T getData(T data){
        return data;
    }

    public static void main(String[] args) {
        Demo6<String> demo = new Demo6<>();
        demo.data = "hello world !";
        System.out.println(Demo6.getData(demo.data));
        System.out.println(Demo6.getData(123456));
    }
}
