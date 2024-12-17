 package Project2;

 import java.util.ArrayList;
 
 public class Medals {
 
     /*
     Create a program that will print a table of medal winner counts with row totals
     I have provided the initial values needed, all you need to do is put the logic for printing the table
     The table should look like this:
 
          Country   Gold    Silver    Bronze  Total
          Canada       1       0       1       2
           China       1       1       0       2
         Germany       0       0       1       1
           Korea       1       0       0       1
           Japan       0       1       1       2
          Russia       0       1       1       2
   United States       1       1       1       3
 
     After that create an ARRAYLIST that is the total of each medal awarded (IE 4 gold, 4 silver, 5 bronze)
     print the total of each medal 
     Hints:
         int rows = counts.length; (get the rows)
         int cols = counts[0].length; (gets the columns)   
         counts[j][i] in a nested for loop would get you the totals of the column  
         Gold    Silver    Bronze
         4       4         5
 
 
 
     FINAL TABLE SHOULD LOOK LIKE THIS:
 
         Country    Gold    Silver    Bronze  Total
          Canada       1       0       1       2
           China       1       1       0       2
         Germany       0       0       1       1
           Korea       1       0       0       1
           Japan       0       1       1       2
          Russia       0       1       1       2
   United States       1       1       1       3
           Total    Gold    Silver    Bronze   X
                       4       4       5
     */
 
     public static void main(String[] args) {
         final int COUNTRIES = 7;
         final int MEDALS = 3;
 
         String[] countries = {
             "Canada",
             "China",
             "Germany",
             "Korea",
             "Japan",
             "Russia",
             "United States"
         };
 
         int[][] counts = 
         { 
             { 1, 0, 1 },
             { 1, 1, 0 }, 
             { 0, 0, 1 }, 
             { 1, 0, 1 }, 
             { 0, 1, 1 }, 
             { 0, 1, 1 },
             { 1, 1, 1 }
         };
         System.out.println("        Country    Gold    Silver    Bronze   Total");
 
         // Print countries, counts, and row totals (IE total medals by country)
         for (int i = 0; i < COUNTRIES; i++) {
             int total = 0;
             System.out.printf("%15s", countries[i]);
             for (int j = 0; j < MEDALS; j++) {
                 System.out.printf("%8d", counts[i][j]);
                 total += counts[i][j];
             }
             System.out.printf("%8d\n", total);
         }
 
         // Display the total medals of each medal class
         ArrayList<Integer> medalCounts = new ArrayList<>();
         for (int j = 0; j < MEDALS; j++) {
             int sum = 0;
             for (int i = 0; i < COUNTRIES; i++) {
                 sum += counts[i][j];
             }
             medalCounts.add(sum);
         }
 
         System.out.println("          Total    Gold    Silver    Bronze");
         System.out.printf("%15s", "");
         for (int count : medalCounts) {
             System.out.printf("%8d", count);
         }
         System.out.println();
     }
 }