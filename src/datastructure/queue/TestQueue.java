package datastructure.queue;

import java.util.LinkedList;
import java.util.Random;

public class TestQueue {
    //测试使用q运行opCOunt 个 enqueue 和 dequeue 操作所需的时间，单位：秒
    private static double testQueue(Queue<Integer> q , int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount ; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueTime = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue , time :" + arrayQueueTime + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double loopQueueTime = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue , time :" + loopQueueTime +"s");
    }
}
