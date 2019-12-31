package leetcode;

import java.util.ArrayList;

public class ReverseInteger {
    /**
     * 120 -> 21 ; -123 -> -321
     * 翻转整数
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE /10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int reverse = reverseInteger.reverse(234554343);
        System.out.println(reverse);
    }
}
