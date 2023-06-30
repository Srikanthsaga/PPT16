import java.util.Stack;

public class PPT168 {
    public static int maxDifference(int[] arr) {
        int n = arr.length;
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && leftStack.peek() >= arr[i]) {
                leftStack.pop();
            }
            if (leftStack.isEmpty()) {
                leftSmaller[i] = 0;
            } else {
                leftSmaller[i] = leftStack.peek();
            }
            leftStack.push(arr[i]);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && rightStack.peek() >= arr[i]) {
                rightStack.pop();
            }
            if (rightStack.isEmpty()) {
                rightSmaller[i] = 0;
            } else {
                rightSmaller[i] = rightStack.peek();
            }
            rightStack.push(arr[i]);
        }
        
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(leftSmaller[i] - rightSmaller[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 8};
        int maxDiff1 = maxDifference(arr1);
        System.out.println("Maximum Difference: " + maxDiff1);
        
        int[] arr2 = {2, 4, 8, 7, 7, 9, 3};
        int maxDiff2 = maxDifference(arr2);
        System.out.println("Maximum Difference: " + maxDiff2);
        
        int[] arr3 = {5, 1, 9, 2, 5, 1, 7};
        int maxDiff3 = maxDifference(arr3);
        System.out.println("Maximum");
    }
}
