package datastructure.linked;

public class TestLinked {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5 ; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList);
        }

        System.out.println("# ------------------ #");
        linkedList.add(2,666);
        System.out.println(linkedList);

        System.out.println("# ------------------ #");
        linkedList.remove(4);
        System.out.println(linkedList);
    }
}
