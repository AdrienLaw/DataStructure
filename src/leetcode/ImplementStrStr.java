package leetcode;


import com.sun.deploy.util.StringUtils;

/**
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        String haystack = "subway";
        String needle = "way";
        int strStr = strStr(haystack, needle);
        System.out.println(strStr);

    }

    public static int strStr(String haystack, String needle) {
        //万年套路第一步
        if (haystack == "") {
            return 0;
        }
        //way 的大小
        int needleLength = needle.length();

        /**
         * 大小两个长度的差 + 1
         * subway - way + 1 = 3 + 1 = 2
         */
        int banana = haystack.length() - needleLength + 1;
        for (int i = 0; i < banana; i++) {
            //如果这个区间里面有 返回下标
            if (haystack.substring(i,i + needleLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
