import java.util.Stack;

public class PPT163 {
    public static void deleteMiddle(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int middleIndex = stack.size() / 2 + 1;

        deleteMiddleUtil(stack, middleIndex);
    }

    private static void deleteMiddleUtil(Stack<Integer> stack, int middleIndex) {
        if (middleIndex == 1) {
            stack.pop();
            return;
        }

        int temp = stack.pop();

        deleteMiddleUtil(stack, middleIndex - 1);

        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);

        System.out.println("Original stack: " + stack1);
        deleteMiddle(stack1);
        System.out.println("Updated stack: " + stack1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        System.out.println("Original stack: " + stack2);
        deleteMiddle(stack2);
        System.out.println("Updated stack: " + stack2);
    }
}
