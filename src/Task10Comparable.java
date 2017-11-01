import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task10Comparable {
    public static void main(String[] args) {
        PriorityQueue<Person> queue = new PriorityQueue<>();
        queue.add(new Person("John", "Smith"));
        queue.add(new Person("Jack", "Brown"));
        queue.add(new Person("Wilhelm", "Smith"));
        queue.add(new Person("George", "Adams"));
        System.out.println("Displaying in natural order:");
        displayQueue(queue);
        System.out.println();

        queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(new Person("John", "Smith"));
        queue.add(new Person("Jack", "Brown"));
        queue.add(new Person("Wilhelm", "Smith"));
        queue.add(new Person("George", "Adams"));
        System.out.println("Displaying in reversed order:");
        displayQueue(queue);
    }

    private static void displayQueue(Queue<?> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    public static class Person implements Comparable<Person> {
        private final String name;
        private final String surname;

        private Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        @Override
        public int compareTo(Person o) {
            int result = surname.compareTo(o.surname);
            if (result == 0) {
                return name.compareTo(o.name);
            }

            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "surname='" + surname + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
