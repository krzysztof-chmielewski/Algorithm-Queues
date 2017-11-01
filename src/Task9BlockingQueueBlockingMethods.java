import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Task9BlockingQueueBlockingMethods {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        for (int i = 1; blockingQueue.remainingCapacity() > 0; i++) {
            blockingQueue.add(i);
        }

        try {
            System.out.println("Trying to offer new element. Waiting up to 2 seconds.");
            if (blockingQueue.offer(5, 2, TimeUnit.SECONDS)) {
                System.out.println("This should never be printed!");
            } else {
                System.out.println("Element was not inserted, as expected.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = createThreadToPutElement(blockingQueue, 15);
        thread.start();

        try {
            System.out.println("Waiting 4 second to free some space.");
            Thread.sleep(4000);
            blockingQueue.remove();
            System.out.println("Successfully removed element from blocking queue.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread = createThreadToPutElement(blockingQueue, 50);
        thread.start();

        try {
            System.out.println("Waiting 3 seconds for interrupting blocking thread.");
            Thread.sleep(3000);
            thread.interrupt();
            System.out.println("Successfully interrupted blocking thread.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Thread createThreadToPutElement(BlockingQueue<Integer> blockingQueue, Integer element) {
        return new Thread(() -> {
            try {
                System.out.println("Trying to put new element.");
                blockingQueue.put(element);
                System.out.println("This should be printed only if space became available.");
            } catch (InterruptedException e) {
                System.out.println("This should be printed only if thread was interrupted.");
            }
        });
    }
}
