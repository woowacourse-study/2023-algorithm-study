import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 백준_10814_나이순_정렬 {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int count = Integer.parseInt(sc.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] input = sc.nextLine().split(" ");
            people.add(new Person(Integer.parseInt(input[0]), input[1], i));
        }
        Collections.sort(people);
        for (Person person : people) {
            System.out.println(person);
        }
    }

    static class Person implements Comparable<Person> {

        private final int age;
        private final String name;
        private final int seq;

        public Person(int age, String name, int seq) {
            this.age = age;
            this.name = name;
            this.seq = seq;
        }

        public int age() {
            return age;
        }

        public String name() {
            return name;
        }

        @Override
        public int compareTo(Person o) {
            if (age > o.age) {
                return 1;
            }
            if (age < o.age) {
                return -1;
            }

            return compareSeq(o);
        }

        private int compareSeq(Person o) {
            if (seq > o.seq) {
                return 1;
            }
            if (seq < o.seq) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
