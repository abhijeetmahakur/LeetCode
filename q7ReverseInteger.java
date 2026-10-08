/*
Q7. Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed.

If reversing x causes the value to go outside the signed 32-bit
integer range [-2^31, 2^31 - 1], return 0.

Examples:

Input: 123
Output: 321

Input: -123
Output: -321

Input: 120
Output: 21
*/

import java.util.Scanner;

public class q7ReverseInteger {

    public static int reverse(int x) {

        int ans = 0;

        while (x != 0) {

            int digit = x % 10;
            x = x / 10;

            if (ans > Integer.MAX_VALUE / 10 ||
                ans < Integer.MIN_VALUE / 10) {
                return 0;
            }

            ans = ans * 10 + digit;
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        System.out.println("Reversed number: " + reverse(x));

        sc.close();
    }
}