package org.example;

public class Main {

    public static void armstrong(int number) {

        int originalNumber, remainder, result = 0;

        originalNumber = number;

        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }

        if(result == number)
            System.out.println(number + " is an Armstrong number.");
        else
            System.out.println(number + " is not an Armstrong number.");
    }

    public static void palindrome(int number) {

        int originalNumber, remainder, result = 0;

        originalNumber = number;

        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result =  result * 10 + remainder;
            originalNumber /= 10;
        }

        if(result == number)
            System.out.println(number + " is Palindrome number.");
        else
            System.out.println(number + " is not Palindrome number.");
    }

    public static void main(String[] args) {
        int number = 151;

        armstrong(number);
        palindrome(number);

    }
}