package datastructure.array;


public class Student {
    private String name;
    private int score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static void main(String[] args) {
        ArrayDynamic2<Student> dynamic2 = new ArrayDynamic2<Student>(2);
        dynamic2.addLast(new Student("Alice",100));
        dynamic2.addLast(new Student("Daniel",98));
        dynamic2.addLast(new Student("Adrien",90));
        dynamic2.addLast(new Student("Jeniffer",90));
        dynamic2.addLast(new Student("Davial",90));
        System.out.println(dynamic2 );


    }
}
