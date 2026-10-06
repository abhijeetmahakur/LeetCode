import java.util.*;

public class q5LongestPalindrome {

    static int start = 0, maxLen = 0;

    public static String longestPalindrome(String s) {
        start = 0;
        maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);       // odd length
            expand(s, i, i + 1);   // even length
        }
        return s.substring(start, start + maxLen);
    }

    static void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int len = right - left - 1;
        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.println("Output: " + longestPalindrome(s));

        sc.close();
    }
}