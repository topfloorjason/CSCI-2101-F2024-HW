# Project 1 Instructions

## Overview

Attached you will find the coursework for the BankAccount program made in class. Use it as a baseline to add the following features:

1. Add the ability for the bank account to detect if the user is trying to withdraw more money than they have in their account. If they are, display a message to the user and inform them they will incur a $35 overdraft fee. Accept a yes or no response from the user. If the user selects yes, deduct the $35 fee from their account and allow the withdrawal. If the user selects no, do not allow the withdrawal.

2. Create a method for the user to transfer money from one account to another. This method should accept two BankAccount objects as parameters and transfer the amount from the first account to the second account. The method should also take in a third parameter, which is the amount to transfer. I have included two bank accounts in the **BankAccountTester** class for you to test this feature. It can be assumed that the user will try to transfer from **bankMain** to **bank2Transfer**. Ensure the user cannot transfer more money than they have in their account.
    - Hint: You will need to use the **withdraw** and **deposit** methods to accomplish this.
    - Hint: You will need to use the **getBalance** method to check if the user has enough money in their account to transfer.
    - Hint: You will need to add the ability for the interact method to accept a second parameter for the bank account to transfer to. I have added a note in the **BankAccountTester** class on where to add this parameter.

3. Create a method to calculate simple interest. The formula to calculate simple interest is: `interest = principal * rate * time` or `(I = P * R * T)`. The method should accept three parameters: principal, annual rate, and time. The method should return the interest calculated. The annual rate is already defined as **interestRate** in the BankAccount class. You can assume the principal is the balance of the account. Make the return statement look similar to the compound interest method.

4. Incorporate the simple interest method into the **interact** method. Ask the user if they would like to calculate the interest on their account. If they select yes, ask the user for the amount of years they would like to calculate the interest for and display the interest to the user.

5. Incorporate the transfer method into the **interact** method. Ask the user if they would like to transfer money to another account. If they select yes, ask the user for the amount they would like to transfer and display the new balances of both accounts.
