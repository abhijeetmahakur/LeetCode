/*
Q8. String to Integer (atoi)

Implement the myAtoi(string s) function, which converts a string
to a 32-bit signed integer.

Steps:
1. Ignore leading spaces.
2. Check for '+' or '-'.
3. Read digits until a non-digit is found.
4. If the number is outside the 32-bit range, return the limit.

Examples:
Input: "42"
Output: 42

Input: " -042"
Output: -42

Input: "1337c0d3"
Output: 1337

Input: "0-1"
Output: 0

Input: "words and 987"
Output: 0
*/

import java.util.Scanner;

public class q8StringToIntegerAtoi {

    public static int myAtoi(String s) {

        int i = 0;
        int sign = 1;
        int ans = 0;

        // Remove spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        // Read digits
        while (i < s.length() &&
               s.charAt(i) >= '0' &&
               s.charAt(i) <= '9') {

            int digit = s.charAt(i) - '0';

            // Check overflow
            if (ans > Integer.MAX_VALUE / 10 ||
                (ans == Integer.MAX_VALUE / 10 && digit > 7)) {

                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println("Result: " + myAtoi(s));

        sc.close();
    }
}