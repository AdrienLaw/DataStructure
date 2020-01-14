package leetcode.stack;

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack {

    // 思路 ： 辅助栈和数据栈不同步
    // 关键 1：辅助栈的元素空的时候，必须放入新进来的数
    // 关键 2：新来的数小于或者等于辅助栈栈顶元素的时候，才放入（特别注意这里等于要考虑进去）
    // 关键 3：出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈，即"出栈保持同步"

    //数据栈
    private Stack<Integer> data;
    //辅助栈
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();

    }

    //将元素 x 推入栈中
    public void push(int x) {
        data.add(x);
        // 关键 1 和 关键 2
        if (helper.isEmpty() || helper.peek() >= x ){
            helper.add(x);
        }
    }

    //删除栈顶的元素
    public void pop() {
        if (!data.isEmpty()) {
            int top = data.pop();
            if (top == helper.peek()) {
                helper.pop();
            }
        }
    }

    //获取栈顶元素
    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    //检索栈中的最小元素
    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(4);
        obj.push(5);
        obj.push(7);
        obj.pop();
        int top = obj.top();
        int mini = obj.getMin();
        System.out.println(top+"======栈顶============");
        System.out.println(mini+"======param_4============");
    }

}
