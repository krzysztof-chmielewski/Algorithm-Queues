import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Task9BlockingQueueOverview {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        for (int i = 1; blockingQueue.remainingCapacity() > 0; i++) {
            blockingQueue.add(i);
            checkForBlockingQueueCapacity(blockingQueue);
        }

        Collection<Integer> set = new HashSet<>();
        System.out.println("Set before draining to (3 elements):");
        System.out.println(set);
        System.out.println("BlockingQueue before being drained to set:");
        System.out.println(blockingQueue);
        blockingQueue.drainTo(set, 3);

        System.out.println("Set after draining to (3 elements):");
        System.out.println(set);
        System.out.println("BlockingQueue after being drained to set:");
        System.out.println(blockingQueue);

    }

    private static void checkForBlockingQueueCapacity(BlockingQueue<?> blockingQueue) {
        System.out.println("Remaining capacity: " + blockingQueue.remainingCapacity());
    }
}
