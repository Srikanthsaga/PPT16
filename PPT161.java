import java.util.*;

public class PPT161 {
    public static int[] findNextGreaterFrequency(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Calculate frequencies of elements in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && frequencyMap.get(arr[i]) >= frequencyMap.get(stack.peek())) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 2, 1};
        int[] result = findNextGreaterFrequency(arr);

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Next Greater Frequency elements: " + Arrays.toString(result));
    }
}
