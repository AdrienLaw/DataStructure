package datastructure.stack;

import datastructure.array.ArrayDynamic2;

public class ArrayStack<E> implements Stack<E> {

    ArrayDynamic2<E> arrayDynamic2;

    public ArrayStack(int capacity){
        arrayDynamic2 = new ArrayDynamic2<>(capacity);
    }
    public ArrayStack(){
        arrayDynamic2 = new ArrayDynamic2<>();
    }

    @Override
    public int getSize() {
        return arrayDynamic2.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrayDynamic2.isEmpty();
    }

    @Override
    public void push(E e) {
        arrayDynamic2.addLast(e);
    }

    @Override
    public E pop() {
        return arrayDynamic2.removeLast();
    }

    @Override
    public E peek() {
        return arrayDynamic2.getLast();
    }

    public int getCapacity(){
        return arrayDynamic2.getCapacity();
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("Stack: tail【");
        for(int i = 0 ; i < arrayDynamic2.getSize() ; i++){
            res.append(arrayDynamic2.get(i));
            if (i != arrayDynamic2.getSize() - 1){
                res.append(" , ");
            }
        }
        res.append("】top");
        return res.toString();
    }
}
