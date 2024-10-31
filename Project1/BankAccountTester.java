package Project1;

public class BankAccountTester {
    public static void main(String[] args) {
        System.out.println("Hello World");

        BankAccount bankMain = new BankAccount("John", 1000, "10/15/24", 867530911, 0001);
        BankAccount bank2Transfer = new BankAccount("Bill", 500, "01/15/24",123454444,0002);

        BankAccount.interact(bankMain); // add bank2Transfer here when interact has additional arguments
    }
}