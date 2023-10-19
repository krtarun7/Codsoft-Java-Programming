import java.util.*;
class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        this.balance=initialBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposite Successful. New balance : "+ balance);
        }
        else{
            System.out.println("Invalid Amount For Deposite.");
        }
    }

    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdrawal successful. New Balance : "+balance);
        }
        else{
            System.out.println("Invalid Amount For Withdrawal. ");
        }
    }
}
class ATM{
    private  BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account){
        this.account=account;
        this.scanner=new Scanner(System.in);
    }

    public void showMenu(){
        System.out.println("1) Check Balance");
        System.out.println("2) Deposite");
        System.out.println("3) Withdraw");
        System.out.println("4) Exit");
    }

    private  void checkBalance(){
        System.out.println("Your Current Balance is : "+ account.getBalance());
    }

    private void deposit(){
        System.out.println("Enter The Amount to Deposit : ");
        double amount=scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw(){
        System.out.println("Enter The Amount to Withdraw : ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public void run(){
        int choice;
        do{
            showMenu();
            System.out.println("Enter Your Choice : ");
            choice=scanner.nextInt();
            switch(choice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank You For Using ATM!!");
                    break;
                default :
                    System.out.println("Invalid Choice. Please Select a Valid Option.");
            }
        } while (choice != 4);
    }
}

public class ATM_Interface{
    public static void main(String args[]){
        System.out.println("Welcome To The ATM!");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your Four Digit PIN: ");
        int enterpin=sc.nextInt();

        BankAccount userAccount=new BankAccount(1000.0);
        ATM atm=new ATM(userAccount);
        atm.run();
    }
}
