package datastructure.stack;

public class testStack {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(10);
        for (int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }
        //出栈
        stack.pop();
        System.out.println(stack);

    }

}

