package leetcode;

import java.lang.String;

/**
 * 最长公共前缀
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 *
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] words = {"flower","flow","flight"};
        String prefix = longestCommonPrefix(words);
        System.out.println(prefix);

    }

    public static String longestCommonPrefix(String[] strs) {
        //空就返回啥都没有
        if (strs == null || strs.length == 0){
            return  "";
        }
        /**
         * 第一个数
         */

        String reg = strs[0];
        for (int i = 0; i < strs.length; i++) {
            //

            while (strs[i].indexOf(reg) != 0){
                //
                reg = reg.substring(0,reg.length() -1);
            }
        }
        return reg;
    }

}
