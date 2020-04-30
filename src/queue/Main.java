package queue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int optCount =100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double arrayQueueTime = testQueue(arrayQueue, optCount);
        double loopQueueTime = testQueue(loopQueue, optCount);
        double linkedListQueueTime = testQueue(linkedListQueue, optCount);
        System.out.println("ArrayQueue, time:" + arrayQueueTime + "s");
        System.out.println("LoopQueue, time:" + loopQueueTime + "s");
        System.out.println("LinkedListQueue, time:" + linkedListQueueTime + "s");
    }

    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

}
