package apple.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(14);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("Show: 来吧展示");
            System.out.println("exit: 退出");
            System.out.println("push: 入栈");
            System.out.println("pop:  出栈");
            key = scanner.next();
            switch (key) {
                case "show" :
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop" :
                    int pop = arrayStack.pop();
                    System.out.printf("出战的是%d\n",pop);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    //栈顶 初始化为 -1
    private int top = -1;



    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }


    /**
     * 判断空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     */
    public void push(int value) {
        if (isFull()){
            System.out.printf("==========栈满=========");
            return;
        }
        top++;
        stack[top] = value;
    }


    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("===========栈空=============");
        }
        int value = stack[top];
        top --;
        return value;
    }

    /**
     * 显示
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("===空===");
            return;
        }
        for (int i = top;i>=0;i--) {
            System.out.printf("Stack[%d]=%d\n",i,stack[i]);
        }
        System.out.println();
    }
}
