package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPlayground {
    public static void main(String[] args) {
        System.out.println("HW5!");
        
        // Question 1
        // Write Java statements that do the following:
        // a) Declare an arrayList nums of 15 elements of type Integer.
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(new Integer[15]));
        
        // b) Output the value of the tenth element of the arrayList nums.
        System.out.println("Tenth element: " + nums.get(9));
        
        // c) Set the value of the 5th element of the arrayList nums to 99.
        nums.set(4, 99);
        
        // d) set the value of the 13th element to 15
        nums.set(12, 15);
        
        // d) set the value of the 2nd element to 6
        nums.set(1, 6);
        
        // d) Set the value of the 9th element of the arrayList nums to the sum of the 13th
        // and 2nd elements of the arrayList nums.
        nums.set(8, nums.get(12) + nums.get(1));

        // Question 2
        // a) create an arrayList of Strings that contain each day of the week.(starting
        // on monday)
        ArrayList<String> daysOfWeek = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        
        // b) output each of the days of the week
        for (String day : daysOfWeek) {
            System.out.println(day);
        }
        
        // c) output the days of the week that we have class
        System.out.println("Class days: Monday, Wednesday, Friday");
        
        // d) change the arrayList to start on Sunday
        Collections.rotate(daysOfWeek, 1);
        System.out.println("Days of week starting on Sunday: " + daysOfWeek);

        // Question 3
        // a) create an ArrayList and prompt the user for numbers to add to it until the
        // number 0 is selected
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int number;
        do {
            System.out.print("Enter a number (0 to stop): ");
            number = scanner.nextInt();
            if (number != 0) {
                numbers.add(number);
            }
        } while (number != 0);
        
        // b) return the largest and smallest number
        if (!numbers.isEmpty()) {
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);
            System.out.println("Largest number: " + max);
            System.out.println("Smallest number: " + min);
        }
        
        // c) return the ArrayList sorted smallest to largest
        Collections.sort(numbers);
        System.out.println("Sorted numbers: " + numbers);
        
        // d) take that ArrayList see if its size is divisable by 3 and then output the
        // ArrayList in a matrix format
        while (numbers.size() % 3 != 0) {
            System.out.print("Please enter more numbers to make the size divisible by 3: ");
            number = scanner.nextInt();
            numbers.add(number);
        }
        
        // Print the ArrayList in a matrix format
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
        
        scanner.close();
    }
}