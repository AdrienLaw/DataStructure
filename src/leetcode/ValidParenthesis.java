package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 */
public class ValidParenthesis {

    private HashMap<Character,Character> mapping;

    public ValidParenthesis() {
        this.mapping = new HashMap<>();
        this.mapping.put(')','(');
        this.mapping.put(']','[');
        this.mapping.put('}','{');
    }

    public boolean validParenthesis(String str){
        //初始化一个栈
        Stack<Character> stack = new Stack<>();

        //遍历这个字符串
        for (int i = 0; i < str.length(); i++) {
            //
            char charAt = str.charAt(i);
            //如果mapping 包含这个key
            if (this.mapping.containsKey(charAt)){
                //获取栈顶的元素，若是空就放一个#
                char topElement = stack.empty() ? '#' : stack.pop();
                //如果这个元素 并不是 栈顶元素
                if (topElement != this.mapping.get(charAt)) {
                    return false;
                }
            } else {
                //在栈顶放一个这个东西
                stack.push(charAt);
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        boolean parenthesis = validParenthesis.validParenthesis("(())");
        System.out.println(parenthesis);


    }
}
