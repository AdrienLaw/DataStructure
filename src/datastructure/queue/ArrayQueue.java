package datastructure.queue;

import datastructure.array.ArrayDynamic2;

public class ArrayQueue<E> implements Queue<E> {

    private ArrayDynamic2<E> array;

    public ArrayQueue(int capacity){
        array = new ArrayDynamic2<>(capacity);
    }

    public ArrayQueue(){
        this(10);
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e){
        array.addLast(e);
    }


    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("Queue: front【");
        for(int i = 0 ; i < array.getSize() ; i++){
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(" , ");
            }
        }
        res.append("】tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(10);
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
