package stack;

import linkedlist.LinkedList;
import queue.Queue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        int opCount = 1000000;
        System.out.println("ArrayStack: " + testStack(arrayStack, opCount));
        System.out.println("LinkedListStack: " + testStack(linkedListStack, opCount));
    }

    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
