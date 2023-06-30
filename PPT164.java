import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PPT164 {
    public static String checkArrangement(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> secondQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            int element = queue.poll();
            stack.push(element);

            while (!queue.isEmpty()) {
                int front = queue.poll();
                secondQueue.add(front);
                if (!stack.isEmpty() && stack.peek() > front) {
                    return "No";
                }
            }

            while (!secondQueue.isEmpty()) {
                queue.add(secondQueue.poll());
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(5);
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue1.add(4);
        System.out.println("Can be arranged in increasing order? " + checkArrangement(queue1));

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(5);
        queue2.add(1);
        queue2.add(2);
        queue2.add(6);
        queue2.add(3);
        queue2.add(4);
        System.out.println("Can be arranged in increasing order? " + checkArrangement(queue2));
    }
}
