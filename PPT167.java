import java.util.Stack;

public class PPT167 {
    public static int countWordsLeft(String[] words) {
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (stack.isEmpty() || !word.equals(stack.peek())) {
                stack.push(word);
            } else {
                stack.pop();
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String[] words1 = {"ab", "aa", "aa", "bcd", "ab"};
        int count1 = countWordsLeft(words1);
        System.out.println("Number of words left: " + count1);

        String[] words2 = {"tom", "jerry", "jerry", "tom"};
        int count2 = countWordsLeft(words2);
        System.out.println("Number of words left: " + count2);
    }
}
