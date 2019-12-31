package datastructure.linked;

import datastructure.stack.ArrayStack;
import datastructure.stack.Stack;

import java.util.Random;

public class TestStack {
    //测试使用q运行opCOunt 个 enqueue 和 dequeue 操作所需的时间，单位：秒
    private static double testStack(Stack<Integer> q , int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount ; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double stack1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack , time :" + stack1 + "s");

        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        double stack2 = testStack(listStack, opCount);
        System.out.println("LinkedListStack , time :" + stack2 +"s");

    }
}
