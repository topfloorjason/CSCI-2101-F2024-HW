package Project1;

import java.util.Scanner; // Import the Scanner class from the java.util package to allow for user input
/*
     * Stockton's Bank
     * Bank Account Parameters:
     *  public Name - String
     *  private Balance - double
     *  private Date of Birth - String
     *  private SSN - int (Maybe String)
     *  private Account Number - in
     * 
     * 
     * Bank Account Methods:
     *  Constructor
     *  Getters and Setters
     *  Deposit
     *  Withdraw
     *  Monthly Fee
     *  Transfer (Homework)
     *  Balance 
     *  Menu
     *  Compound Interest
     *  Simple Interest (Homework)
     *  
     *  Bank Account Constructor
     *  Name, Balance, SSN, Account Number, Date of Birth
     *  Name, SSN
     */

public class BankAccount {

    // Bank Account Parameters (Also Called Arguments)
    public String name; // this.name
    private double balance; // this.balance
    private String dob; // this.dob
    private int ssn; // this.ssn
    private int accountNumber; // this.accountNumber
    public double interestRate = 0.01;
    public int period = 4; // quarterly
    
    // Bank Account Constructor
    public BankAccount(String name, double balance, String dob, int ssn,  int accountNumber){
        this.name = name;
        this.balance = balance;
        this.dob = dob;
        this.ssn = ssn;
        this.accountNumber = accountNumber;
        
    }

    public BankAccount(String name, int ssn){
        this.name = name;
        this.ssn = ssn;
    }

    // Getters and Setters
    
    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getDob() {
        return this.dob;
    }

    public int getSSN() {
        return this.ssn;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit
    public void deposit(double amount){
        this.balance += amount; // this.balance = this.balance + amount;
    }

    // Withdraw
    public void withdraw(double amount){
        /*
        * Add logic for overdraft here
        */
        this.balance -= amount; // this.balance = this.balance - amount;

    }

    // Monthly Fee - will subtract a monthly fee from the balance
    // take in a double as a parameter
    // subtract the fee from the balance
    // Netflix subscription fee - $12.99
    public void monthlyFee(double fee){
        withdraw(fee);
    }

    // print Balance
    public void printBalance(){
        System.out.println("Balance: $" + this.balance);
    }


    // Create a method that will calculate the interest on the balance using coumpound interest
    // P(1 + R/n)^(nt) - P
    // A = P(1 + R/n )^(nt)
    // P = Principal
    // R = Rate
    // n = number of times interest ins compunded per year (annum)
    // t = number of years
    // This method will take a double as an argument
    // Hint: P can be this.balance or getBalance() if you would like to use the getter

    public void compoundInterest(double principal, int time, double rate, int annum ){
        double amount = principal + Math.pow(1 + (rate/annum), annum * time); // P(1 + R/n )^(nt)
        double roundedAmount = Math.round(amount * 100.0) / 100.0; // important for the output
        double compInterest = amount - principal;  // A-P
        compInterest = Math.round(compInterest * 100.0) / 100.0;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Current Period is: " + annum + " times per year");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Compound Interest after " + time + " years is: $" + compInterest);
        System.out.println("Total Amount after " + time + " years is: $" + roundedAmount);
    }


    /*
     * Insert simpleInterest method here.
     */




    /*
     * Insert transfer method here.
     */






    // Create a method that will print a menu to the user
    // This is called a helper method / function
    public static int menu() {
        int choice;
        Scanner input = new Scanner(System.in); // Create a scanner object
        System.out.println("Welcome to the Bank of Stockton");
        System.out.println("Please select an option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Print Balance");
        System.out.println("4. Compound Interest");
        /*
         * Add menu options for transfer and Simple Interest
         */
        System.err.println("0. Exit");
        choice = input.nextInt(); // Collect the user's input
        return choice; // Return the user's input
    }

    // Create a method that will interact with the user based on their 
    // choice from the menu.
    // This method will take a BankAccount object as a parameter
    public static void interact(BankAccount account){
        // get the choice from the menu method
        // Create a scanner object
        int choice = menu();
        Scanner input = new Scanner(System.in);
        
        // user the choice from the menu to run the method associated with that choice
        
        if (choice == 1){ // Deposit
            System.out.println("Please enter the amount you would like to deposit: ");
            double amount = input.nextDouble(); // save the amount from user to deposit
            account.deposit(amount); // pass the amount into the account.deposit method
            account.printBalance(); // print the balance to the user
        } else if (choice == 2){ // Withdraw
            System.out.println("Please enter the amount you would like to withdraw: ");
            double amount = input.nextDouble(); // save the amount from user to withdraw
            account.withdraw(amount); // pass the amount into the account.withdraw method
            account.printBalance(); // print the balance to the user
        } else if (choice == 3){ // Print Balance
            account.printBalance();
        } else if (choice == 4){ // Compound Interest
            System.out.println("Compound Interest Calculator");
            System.out.println("How many years? (Whole Numbers Only)");
            int years = input.nextInt();
            account.compoundInterest(account.getBalance(), years, account.interestRate, account.period);
            account.printBalance();
        /*
         * Add logic for transfer and Simple Interest
         */
        } else if (choice == 0){ // Exit the program
            System.out.println("Thank you for Banking with us today. Goodbye!");
            input.close();
        } else { // this would catch any invalid choices
            System.out.println("Invalid Choice");
        }
    }
}
