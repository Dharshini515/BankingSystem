// BankAccountSystem.java

import java.util.*;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double accountBalance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return accountBalance;
    }

    public void depositAmount(double amount) {
        if (amount > 0) {
        	accountBalance += amount;
            System.out.println("Amount Deposited: Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdrawAmount(double amount) {
        if (amount > 0 && amount <= accountBalance) {
        	accountBalance -= amount;
            System.out.println("Amount Withdrawn: Rs." + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name  : " + accountHolderName);
        System.out.println("Balance      : Rs." + accountBalance);
    }
}

public class BankingSystem {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int select;
        do {
            System.out.println("\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            select = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (select) {
                case 1:
                    createAccount();
                    break;
                case 2:
                	depositAmount();
                    break;
                case 3:
                	withdrawAmount();
                    break;
                case 4:
                    viewAccount();
                    break;
                case 5:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (select != 5);
    }

    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists.");
            return;
        }
        System.out.print("Enter Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Account acc = new Account(accNo, name, balance);
        accounts.put(accNo, acc);
        System.out.println("Account created successfully.");
    }

    private static void depositAmount() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        acc.depositAmount(amount);
    }

    private static void withdrawAmount() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        acc.withdrawAmount(amount);
    }

    private static void viewAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        acc.displayDetails();
    }
}
