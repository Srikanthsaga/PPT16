import java.util.Stack;

public class PPT165 {
    public static int reverseNumber(int num) {
        Stack<Integer> stack = new Stack<>();

        // Push each digit of the number into the stack
        while (num > 0) {
            int digit = num % 10;
            stack.push(digit);
            num /= 10;
        }

        int reversedNum = 0;
        int placeValue = 1;

        // Pop digits from the stack and build the reversed number
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            reversedNum += digit * placeValue;
            placeValue *= 10;
        }

        return reversedNum;
    }

    public static void main(String[] args) {
        int num1 = 365;
        System.out.println("Reversed number: " + reverseNumber(num1));

        int num2 = 6899;
        System.out.println("Reversed number: " + reverseNumber(num2));
    }
}
