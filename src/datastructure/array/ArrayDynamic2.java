package datastructure.array;

import java.util.Date;

public class ArrayDynamic2<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数
     * @param capacity
     */
    public ArrayDynamic2(int capacity){
        //java 不支持泛型数组，下面采取曲线救国的方式
        data = (E[])new Object[capacity];
        size = 0;
    }

    public ArrayDynamic2() {
        this(10);
    }

    /**
     * 初始值10
     * 无参构造
     */



    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public void addLast(E e){
        add(size,e);
    }
    public void addFirst(E e){
        add(0,e);
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }


    /**
     * Queue jumping
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if (size == data.length) {
            resize(2 * data.length);

        }
        //如果满了，就
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed. ArrayDynamic is already full");

        }
        for (int i = size-1 ; i>=index ; i--){
            data[i+1]=data[i];
        }
        data[index] = e;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData=(E[]) new Object[newCapacity];
        for (int i = 0;i < size ; i++)
            newData[i] = data[i];
        data = newData;
    }

    // 获取index索引位置的元素
     public E get(int index){
        if (index <0 || index >= size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    //修改index索引位置为元素e
    void set(int index , E e){
        if (index <0 || index >= size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        data[index] = e;
    }


    public boolean contains(E e){
        for (int i= 0; i <size ; i++){
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 查找索引 没有则返回-1
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if (index <0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is illegal");
        E ret = data[index];
        for (int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        //垃圾回收  loitering objects != memory leak
        data[size] = null;
        if (size == data.length /4 && data.length /2 != 0)
            resize(data.length / 2);
        return ret;
    }


    //删除第一个元素
    public E removeFirst(){
        return remove(0);
    }


    //删除最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }


    //删除元素e
    public boolean removeElement(E e){
        int i = find(e);
        if (i!=-1){
            remove(i);
            return true;
        }
        return false;
    }






    /**
     * 覆盖toString 方法
     * @return
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d , capacity = %d",size,data.length));
        stringBuilder.append('[');
        for (int i = 0 ; i < size ; i ++){
            stringBuilder.append(data[i]);
            if (i != size -1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

}
