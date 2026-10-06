import java.util.*;

public class q4MedianOfTwoArrays {

    public static double findMedian(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int[] all = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (a[i] < b[j]) all[k++] = a[i++];
            else all[k++] = b[j++];
        }
        while (i < m) all[k++] = a[i++];
        while (j < n) all[k++] = b[j++];

        int mid = (m + n) / 2;
        if ((m + n) % 2 == 1) return all[mid];
        return (all[mid - 1] + all[mid]) / 2.0;
    }

    static int[] readArray(Scanner sc, String name) {
        System.out.print("Enter size of " + name + ": ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        if (n > 0) System.out.println("Enter " + n + " numbers of " + name + ":");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = readArray(sc, "a");
        int[] b = readArray(sc, "b");

        double ans = findMedian(a, b);
        System.out.printf("Output: %.5f%n", ans);

        sc.close();
    }
}
