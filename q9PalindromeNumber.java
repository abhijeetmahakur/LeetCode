/*
Q9. Palindrome Number

Given an integer x, return true if x is a palindrome,
and false otherwise.

Examples:

Input: 121
Output: true

Input: -121
Output: false

Input: 10
Output: false
*/

import java.util.Scanner;

public class q9PalindromeNumber {

    public static boolean isPalindrome(int x) {

        // Negative numbers are not palindrome
        if (x < 0) {
            return false;
        }

        int original = x;
        int reverse = 0;

        while (x != 0) {

            int digit = x % 10;

            reverse = reverse * 10 + digit;

            x = x / 10;
        }

        return original == reverse;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        System.out.println(isPalindrome(x));

        sc.close();
    }
}