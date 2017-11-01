import java.util.Deque;
import java.util.LinkedList;

public class Task9Deque {
    public static void main(String[] args) {
        Deque<Integer> list = new LinkedList<>();

        fillDeque(list, 10);
        takeFromHeadAndTailInTurns(list);
    }

    private static void fillDeque(Deque<Integer> deque, int n) {
        for (int i = 1; i <= n; i++) {
            deque.addFirst(i);
            deque.addLast(1000 + i);
        }
    }

    private static void takeFromHeadAndTailInTurns(Deque<Integer> deque) {
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst());
            if (!deque.isEmpty()) {
                System.out.println(deque.removeLast());
            }
        }
    }
}
