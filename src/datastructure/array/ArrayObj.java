package datastructure.array;

public class ArrayObj {
    public static void main(String[] args) {
        ArrayDynamic2<Integer> dynamic = new ArrayDynamic2<Integer>(20);
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
