import java.util.*;

public class q1TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int other = target - arr[i];
            if (seen.containsKey(other)) {
                return new int[]{seen.get(other), i};
            }
            seen.put(arr[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] ans = twoSum(arr, target);
        System.out.println("Output: " + Arrays.toString(ans));
    }
}
