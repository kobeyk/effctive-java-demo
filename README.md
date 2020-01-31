# effctive-java-demo
高效Java学习代码

package com.appleyk.列表优于数组;

import java.util.*;

/**
 * <p>手写栈【利用泛型+数组实现】</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 22:49 2020/1/31
 */
public class Stack<T> {

    /**泛型数组对象*/
    private T[] data;
    /**数组元素个数*/
    private int size = 0;
    /**默认数组容量2，当然这里是做实验故意放这么小的*/
    private final static int DEFAULT_SIZE = 2;

    public Stack(){
        data = (T[])new Object[DEFAULT_SIZE];
    }

    public T pop(){
        if (size == 0)
            throw new EmptyStackException();
        T element = data[--size];
        /**消除过期引用，提升垃圾回收效率*/
        data[size] = null;
        return element;
    }

    public void push(T element){
        ensureCapacity();
        data[size++] = element;
    }

    /**
     * 批量入栈
     * @param iterator 可迭代的对象（注意，入栈的类型可能是T的子类型，所以为了编译ok，这里用限定通配符 ？ extends xx）
     */
    public void pushAll(Iterable<? extends T> iterator){
        for (T element : iterator) {
            push(element);
        }
    }

    /**
     * 将所有元素弹出栈
     * @param col 弹出的元素用集合col对象接收
     *            （注意，col的类型可能是T的父类，所以为了编译ok，这里用限定通配符 ？ super xx）
     */
    public void popAll(Collection<? super T> col){
        while(!isEmpty()){
            col.add(pop());
        }
    }

    /**
     * 确认下，是否容量已满，如果满，给数组扩容
     */
    private void ensureCapacity(){
        if(data.length==size){
            // 扩容一倍
            data = Arrays.copyOf(data,2*size+1);
        }
    }

    public boolean isEmpty(){
        return size == 0 ;
    }

    public int length(){
        return data.length;
    }

    public static void main(String[] args) {

        // pushAll用法（T是生产者，采用限定通配符 ? extends T）
        Stack<Number> stackNum = new Stack<>();
        stackNum.push(1.2);
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        stackNum.pushAll(intList);
        System.out.println("栈的大小："+stackNum.size);

        // popAll用法（T是消费者，采用限定通配符 ? super T）
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        System.out.println("扩容后的数据组容量："+intStack.length());
        List<Number> numList = new ArrayList<>();
        intStack.popAll(numList);
        System.out.println("出栈元素（全部）打印："+numList);

    }
}
