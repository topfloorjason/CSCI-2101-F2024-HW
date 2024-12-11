package HW4;

import java.util.Scanner;

public class Arrays {

    // CONVERT THE SUMS METHOD FROM HW3 TO ADD EACH VALUE TO AN ARRAY AND THEN OUTPUT THE 
    // ARRAY AND THE TOTAL.
    // SEE HW3 FOR SUMS METHOD
    // Otherwise if you are using a regular array, assume the size is 10 total. 
    // EXAMPLE 
    // I will add up the numbers you give me....
    // Number: 12
    // The total so far is 12.
    // Number: 2
    // The total so far is 14.
    // Number: 3
    // The total so far is 17.
    // Number: 4
    // The total so far is 21.
    // Number: 1
    // The total so far is 22.
    // Number: 0
    // Total: 22
    // Array: {12,2,3,4,1,0}
    // Note: You can not use Arrays class to do this. You must use a regular array. No Arrays.stream
    public static void Arraysums() {
        int[] numbers = new int[10];
        int total = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("I will add up the numbers you give me....");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number: ");
            numbers[i] = scanner.nextInt();
            total += numbers[i];
            System.out.println("The total so far is " + total + ".");
        }

        System.out.println("Total: " + total);
        System.out.print("Array: {");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    // Create a method that will brute force a password EX.
    // bruteForce("ZZZZ")
    // The program should then guess each char of the string and compare it to see if it is equal
    // to the index of the alphabet char array below
    // Output Example:
    // Z
    // ZZ
    // ZZZ
    // ZZZZ

    // Hint 1: using a char array for the password is helpful here 
    // Hint 2: using the method .toCharArray is a way to convert the password parameter to a char array as well
    // From there creating for and while loops to compare the values is trivial
    public static String bruteForce(String password) {
        String answer = "";
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')','<','>','/','?'};

        char[] passwordChars = password.toCharArray();
        char[] guess = new char[passwordChars.length];

        for (int i = 0; i < passwordChars.length; i++) {
            for (char c : alphabet) {
                guess[i] = c;
                System.out.println(new String(guess));
                if (guess[i] == passwordChars[i]) {
                    break;
                }
            }
        }

        answer = new String(guess);
        return answer;
    }

    // Create a method that will sort an Array of integers from smallest to greatest.
    // NOTE: You CANNOT use the built in Arrays.sort method
    // Ex. 
    // sorter([9,10,2,5,3,4,7,8]) -> [2,3,4,5,7,8,9,10]

    // Hint 1: a temp Array is a helpful way to store variables for comparing 
    // Hint 2: 2 nested For loops should be all thats needed for the swapping logic
    public static int[] sorter(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // swap nums[j] and nums[j + 1]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        // Tester main method for your methods
        System.out.println("HW4!");

        // Test Arraysums
        Arraysums();

        // Test bruteForce
        System.out.println("Brute force result: " + bruteForce("ZZZZ"));

        // Test sorter
        int[] nums = {9, 10, 2, 5, 3, 4, 7, 8};
        int[] sortedNums = sorter(nums);
        System.out.print("Sorted array: ");
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }
}