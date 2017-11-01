import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task10Comparator {
    public static void main(String[] args) {
        Comparator<Person> comparator = (o1, o2) -> {
            int result = o1.surname.compareTo(o2.surname);
            if (result == 0) {
                return o1.name.compareTo(o2.name);
            }

            return result;
        };

        PriorityQueue<Person> queue = new PriorityQueue<>(comparator);
        queue.add(new Person("John", "Smith"));
        queue.add(new Person("Jack", "Brown"));
        queue.add(new Person("Wilhelm", "Smith"));
        queue.add(new Person("George", "Adams"));
        System.out.println("Displaying in natural order:");
        displayQueue(queue);
        System.out.println();

        queue = new PriorityQueue<>(comparator.reversed());
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

    public static class Person {
        private final String name;
        private final String surname;

        private Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
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
