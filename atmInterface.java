package CodSoft;
import java.util.Scanner;


    class bankAccount{
        private double balance;

        public bankAccount(double initialBal){
            this.balance= initialBal;
        }

        public double getBal(){
            return balance;
        }

        public void deposit(double amount){
            if(amount>0){
                balance+=amount;
                System.out.println("Deposit Successfull. Avaliable Balance: "+ balance);
            }else{
                System.out.println("Invalid Amount. Try again !");
            }
        }

        public void withdraw(double amount){
            if(amount>0 && amount<balance){
                if( amount %100==0){
                    balance-=amount;
                    System.out.println("Withdraw Successfull. Available Balance: "+ balance);
                }else{
                    System.out.println("Invalid input. Try Again(Amount must be multiple of 100) !");
                }
            }else{
                System.out.println("Transaction Failed(Due to insufficiant balance).");
            }
        }   
    }

    class ATM{
        private bankAccount account;
        private Scanner scan;

        public ATM(bankAccount account){
            this.account=account;
            this.scan=new Scanner(System.in);
        }

        private void showMenu(){
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }

        public void run(){

            int choice;
            do{
                showMenu();
                System.out.println("Enter your choice: ");
                choice=scan.nextInt();
                switch(choice){
                    case 1: checkBal();
                    break;
                     
                    case 2: deposit();
                    break;

                    case 3: withdraw();
                    break;

                    case 4: 
                    System.out.println("Thanks you for using ATM.");
                    break;
                    default: 
                    System.out.println("Invalid Choice.Please Select a valid option.");
                }
            }while(choice!=4);
        }

        private void checkBal(){
            System.out.println("Available Balance: "+ account.getBal());
        }

        private void deposit(){
            System.out.println("Enter Amount: ");
            double amount= scan.nextDouble();
            account.deposit(amount);
        }

        private void withdraw(){
            System.out.println("Enter Amount: ");
            double amount= scan.nextDouble();
            account.withdraw(amount);
        }
    }
 

public class atmInterface{
        public static void main(String args[]){
            System.out.println("Welcome to the ATM ");

            Scanner sc=new Scanner(System.in);
            System.out.print("Enter PIN (Dummy PIN: 1432): ");
            int pin=sc.nextInt();
            while(pin!=1432){
                System.out.print("Enter Valid PIN (Dummy PIN): ");
                pin=sc.nextInt();
            }
            System.out.println();
            bankAccount userAcc=new bankAccount(1000.0);
            ATM atm= new ATM(userAcc);
            atm.run();
            
        }
    }
