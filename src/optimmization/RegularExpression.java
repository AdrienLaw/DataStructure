package optimmization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class RegularExpression {

    public static void test01(){
        String text = "abbc";
        //开启独占模式
        String regex = "ab{1,3}+c";

        boolean matches = Pattern.matches(regex, text);
        System.out.println("大声说，包含吗？"+matches);

    }


    public static void test02(){
        String text = "<input high=\"20\" weight=\"70\">test</input>";
        String reg="(<input.*?>)(.*?)(</input>)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(text);
        while(m.find()) {
            System.out.println(m.group(0));//整个匹配到的内容
            System.out.println(m.group(1));//(<input.*?>)
            System.out.println(m.group(2));//(.*?)
            System.out.println(m.group(3));//(</input>)
        }

    }

    public static void test03(){
        String text = "<input high=\"20\" weight=\"70\">test</input>";
        String reg="(?:<input.*?>)(.*?)(?:</input>)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(text);
        while(m.find()) {
            System.out.println(m.group(0));//整个匹配到的内容
            System.out.println(m.group(1));//(.*?)
        }

        new ArrayList<>();

        new LinkedList<>();
    }

    public static void main(String[] args) {
        test03();
    }
}
