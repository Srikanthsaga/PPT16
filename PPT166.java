import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PPT166 {
    public static void reverseKElements(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        Stack<Integer> stack = new Stack<>();

        // Push the first k elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Enqueue the elements from the stack back into the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Rotate the remaining elements in the queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        int k = 3;

        System.out.println("Original queue: " + queue);

        reverseKElements(queue, k);

        System.out.println("Reversed queue: " + queue);
    }
}
