/*
Q10. Regular Expression Matching

Given a string s and a pattern p, check whether the
pattern matches the ENTIRE string.

Rules:

1. '.' matches any single character.
2. '*' matches zero or more of the previous character.

Examples:

Input: s = "aa", p = "a"
Output: false

Input: s = "aa", p = "a*"
Output: true

Input: s = "ab", p = ".*"
Output: true
*/

import java.util.Scanner;

public class q10RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];

        return check(s, p, 0, 0, dp);
    }

    public static boolean check(String s, String p, int i, int j,
                                Boolean[][] dp) {

        // Pattern is finished
        if (j == p.length()) {
            return i == s.length();
        }

        // Already calculated
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Check if current characters match
        boolean firstMatch = i < s.length()
                && (s.charAt(i) == p.charAt(j)
                || p.charAt(j) == '.');

        boolean answer;

        // If next character is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // Use * zero times
            boolean skip = check(s, p, i, j + 2, dp);

            // Use * one or more times
            boolean use = firstMatch &&
                    check(s, p, i + 1, j, dp);

            answer = skip || use;

        } else {

            answer = firstMatch &&
                    check(s, p, i + 1, j + 1, dp);
        }

        dp[i][j] = answer;

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.print("Enter pattern: ");
        String p = sc.nextLine();

        System.out.println("Result: " + isMatch(s, p));

        sc.close();
    }
}