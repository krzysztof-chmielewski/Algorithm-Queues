import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Task8 {
    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        Queue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        pollShouldNotThrowExceptionWhenQueueIsEmpty(list);
        pollShouldNotThrowExceptionWhenQueueIsEmpty(blockingQueue);
        pollShouldNotThrowExceptionWhenQueueIsEmpty(priorityQueue);

        removeShouldThrowExceptionIfQueueIsEmpty(list);
        removeShouldThrowExceptionIfQueueIsEmpty(blockingQueue);
        removeShouldThrowExceptionIfQueueIsEmpty(priorityQueue);

        elementShouldNotThrowExceptionWhenQueueIsEmpty(list);
        elementShouldNotThrowExceptionWhenQueueIsEmpty(blockingQueue);
        elementShouldNotThrowExceptionWhenQueueIsEmpty(priorityQueue);

        peekShouldThrowExceptionIfQueueIsEmpty(list);
        peekShouldThrowExceptionIfQueueIsEmpty(blockingQueue);
        peekShouldThrowExceptionIfQueueIsEmpty(priorityQueue);

        canIInsertNullElement(list);
        canIInsertNullElement(blockingQueue);
        canIInsertNullElement(priorityQueue);

        blockingQueue.add(1);
        blockingQueue.add(2);
        blockingQueue.add(3);
        blockingQueue.add(4);
        blockingQueue.add(5);

        addShouldThrowExceptionIfThereIsNoMoreFreeSpace(blockingQueue, 1);
        offerShouldNotThrowExceptionIfThereIsNoMoreFreeSpace(blockingQueue, 1);


        priorityQueue.add(5);
        priorityQueue.add(4);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(4);
        System.out.println("Displaying PriorityQueue in natural order:");
        displayQueue(priorityQueue);

        priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.add(5);
        priorityQueue.add(4);
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(4);
        System.out.println("Displaying PriorityQueue in reversed order:");
        displayQueue(priorityQueue);

    }

    private static void pollShouldNotThrowExceptionWhenQueueIsEmpty(Queue<?> queue) {
        try {
            queue.poll();
            System.out.println("For 'poll', exception not thrown, as expected.");
        } catch (Exception e) {
            System.out.println("This should never be printed!");
        }
    }

    private static void removeShouldThrowExceptionIfQueueIsEmpty(Queue<?> queue) {
        try {
            queue.remove();
            System.out.println("This should never be printed!");
        } catch (Exception e) {
            System.out.println("For 'remove', exception thrown, as expected.");
        }
    }

    private static void elementShouldNotThrowExceptionWhenQueueIsEmpty(Queue<?> queue) {
        try {
            queue.element();
            System.out.println("This should never be printed!");
        } catch (Exception e) {
            System.out.println("For 'element', exception thrown, as expected.");
        }
    }

    private static void peekShouldThrowExceptionIfQueueIsEmpty(Queue<?> queue) {
        try {
            queue.peek();
            System.out.println("For 'peek', exception not thrown, as expected.");
        } catch (Exception e) {
            System.out.println("This should never be printed!");
        }
    }

    private static void canIInsertNullElement(Queue<?> queue) {
        try {
            queue.add(null);
            System.out.println("Inserting null is allowed for " + queue.getClass().getSimpleName() + ".");
        } catch (Exception e) {
            System.out.println("Inserting null is not permitted for " + queue.getClass().getSimpleName() + ".");

        }
    }

    private static void addShouldThrowExceptionIfThereIsNoMoreFreeSpace(Queue<Integer> queue, Integer element) {
        try {
            queue.add(element);
            System.out.println("This should never be printed!");
        } catch (Exception e) {
            System.out.println("For 'add', exception thrown, as expected.");
        }
    }

    private static void offerShouldNotThrowExceptionIfThereIsNoMoreFreeSpace(Queue<Integer> queue, Integer element) {
        try {
            queue.offer(element);
            System.out.println("For 'offer', exception not thrown, as expected.");
        } catch (Exception e) {
            System.out.println("This should never be printed!");
        }
    }

    private static void displayQueue(Queue<?> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
