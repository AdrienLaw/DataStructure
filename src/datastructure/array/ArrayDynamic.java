package datastructure.array;

import com.sun.org.apache.regexp.internal.RE;

public class ArrayDynamic {
    private int[] data;
    private int size;

    /**
     * 构造函数
     * @param capacity
     */
    public ArrayDynamic(int capacity){
        data = new int[capacity];
        size = 0;
    }




    /**
     * 初始值10
     * 无参构造
     */
    public ArrayDynamic(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public void addLast(int e){
        add(size,e);
    }
    public void addFirst(int e){
        add(0,e);
    }



    /**
     * Queue jumping
     * @param index
     * @param e
     */
    public void add(int index,int e){
        if (size == data.length)
            throw new IllegalArgumentException("AddLast failed. ArrayDynamic is already full");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed.Require index < 0 || index > size");
        for (int i = size-1 ; i>=index ; i--){
            data[i+1]=data[i];
        }
        data[index] = e;
        size ++;
    }

    // 获取index索引位置的元素
    int get(int index){
        if (index <0 || index >= size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    //修改index索引位置为元素e
    void set(int index , int e){
        if (index <0 || index >= size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        data[index] = e;
    }


    public boolean contains(int e){
        for (int i= 0; i <size ; i++){
            if (data[i] == e)
                return true;
        }
        return false;
    }

    /**
     * 查找索引 没有则返回-1
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public int remove(int index){
        if (index <0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is illegal");
        int ret = data[index];
        for (int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        return ret;
    }


    //删除第一个元素
    public int removeFirst(){
        return remove(0);
    }


    //删除最后一个元素
    public int removeLast(){
        return remove(size - 1);
    }


    //删除元素e
    public boolean removeElement(int e){
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
