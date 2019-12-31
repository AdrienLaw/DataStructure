package datastructure.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front,tail;

    private int size;


    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        size= 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length -1;
    }





    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * most important
     * 入队
     * @param e
     */

    @Override
    public void enqueue(E e) {
        //如果是🈵️的
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail +1) % data.length;
        size ++;
    }

    //扩容
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0 ; i < size ;i++)
            newData[i] =data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;

    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        E ret = data[front];
        data[front] = null;
        front = (front +1) % data.length;
        size --;
        //缩容
        if (size == getCapacity() / 4 && getCapacity() /2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Queue : size = %d , capacity = %d",size,getCapacity()));
        stringBuilder.append("front 【");
        for (int i = 0 ; i !=tail ; i = (i + 1) % data.length){
            stringBuilder.append(data[i]);
            if ((i + 1) % data.length != tail){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("】 tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<Integer>();
        for (int i = 0 ; i < 11 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if ( i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
