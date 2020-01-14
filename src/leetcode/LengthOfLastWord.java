package leetcode;

/**
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String str = "Hello the fucking world " ;
        int ofLastWord = lengthOfLastWord(str);
        System.out.println(ofLastWord);
    }


    public static int lengthOfLastWord(String string) {
        string = string.trim();
        if (string==null || string.equals("")){
            return 0;
        }
        if (string.indexOf("") < 0){
            return 0;
        }
        String[] strings = string.split(" ");
        String lastWorld = strings[strings.length - 1];
        int length = lastWorld.length();
        return length;

    }
}
