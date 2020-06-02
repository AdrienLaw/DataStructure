package interview.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        //一个扫描器
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s:  显示队列");
            System.out.println("e:  退出程序");
            System.out.println("a:  添加数据到队列");
            System.out.println("g:  取出数据");
            System.out.println("h:  查看头数据");
            //表示接受一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("====请输入一个数字======");
                    int anInt = scanner.nextInt();
                    arrayQueue.addQueue(anInt);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.printf("取出的数据%d\n",result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = arrayQueue.headQueue();
                        System.out.printf("取出的数据%d\n",result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }


}
class ArrayQueue {
    //数组的最大容量
    private int maxSize;
    //队列头 队列尾
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头 的前一个位置
        rear = -1; //指向队列尾 包含队列尾，最后一个数据
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize -1;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //首先判断是否满了
        if (isFull()) {
            System.out.println("======队列满了======");
        } else {
            rear ++;
            arr[rear] = n;
        }
    }

    //获取队列的数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("===空队列===");
        } else {
            front ++;
            return arr[front];
        }
    }

    //展示所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("=======空的===========");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
    }

    //显示头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("-=====空的=======");
        }
        return arr[front +1];
    }
}
