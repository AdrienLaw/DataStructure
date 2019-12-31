package optimmization;

public class StringOptimal {

    public static void test01(){
        String str1 = "abc";
        String str2 = new String("abc");
        // .intern() 上传到常量池，并返回她的引用
        String str3 = str2.intern();

        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);
    }


    /**
     * 拼接字符串
     */
    public static void test02(){
        String asd = "我是一个粉刷匠,";
        String zxc = "粉刷本领强";
        String toString = new StringBuilder(asd).append(zxc).toString();
        System.out.println(toString);

    }



    /**
     * intern() 节省空间
     */
    public static void test03(){
        String asd = new String("abc").intern();
        String zxc = new String("abc").intern();
        if (asd == zxc){
            System.out.println(asd == zxc);
        }

    }


    /**
     * 字符串分割
     */
    public static void test04(){
        String donot = new String("How Long will I Love You");

        String[] strings = donot.split(" ");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + "--");
        }


        System.out.println();

        int indexOf = donot.indexOf("will");
        System.out.println(indexOf);


    }




    public static void main(String[] args) {
        //test01();
        //test02();
        //test03();
        test04();
    }
}
