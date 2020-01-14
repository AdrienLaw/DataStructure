package leetcode.easy;

/**
 *
 * 首先1，自然表示为1，而say出来就是1个1,
 * 所以2应该表示为11，而say出来就是2个1，
 * 所以3应该表示为21，而say出来就是1个2，1个1，
 * 所以4应该表示为1211，以此类推...
 *
 */
public class CountAndSay {
    public static void main(String[] args) {
        String andSay = countAndSay(9);
        System.out.println(andSay);
    }

    public static String countAndSay(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        n--;
        while (n > 0) {
            StringBuilder sbTemp = new StringBuilder();
            for (int i = 0 ,len = stringBuilder.length(); i < len ; i ++) {
                int j = i;
                int count = 0;
                while (j < len &&stringBuilder.charAt(j) == stringBuilder.charAt(i)){
                    j++;
                    count++;
                }
                sbTemp.append(count).append(stringBuilder.charAt(i));
                i = j -1;
            }
            n--;
            stringBuilder = sbTemp;
        }
        return stringBuilder.toString();

    }

}
