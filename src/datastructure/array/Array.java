package datastructure.array;

public class Array {
/*    public static void main(String[] args) {
        
        int[] array = new int[10];
        for (int i = 0; i <array.length ; i++) {
            array[i] = i;

            int[] scores = new int[]{100,99,59};
            for (int score : scores) {
                System.out.println(score+"====1=======");
            }
            //修改数组
            scores[0] = 98;
            for (int score : scores) {
                System.out.println(score+"=====3======");
            }

            System.out.println("=====OVER="+i+"==========");
        }
        
    }*/
    public static void main(String[] args) {

        ArrayDynamic dynamic = new ArrayDynamic(20);
        for (int i = 0 ; i < 10 ; i ++){
            dynamic.addLast(i);
        }
        System.out.println(dynamic);

        dynamic.add(1,100);
        System.out.println(dynamic);

        dynamic.remove(1);
        System.out.println(dynamic);

        dynamic.removeElement(9);
        System.out.println(dynamic);

    }


}
