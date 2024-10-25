import java.util.*;

public class BankAccountClient { 
   public static Scanner console = new Scanner(System.in); 

   private static BankAccount accountHolder1 = new BankAccount(1, "Anya A. Forger", 1000.0, 0.1);
   private static BankAccount accountHolder2 = new BankAccount(2, "Loid A. Forger", 5000.0, 0.5);
   private static BankAccount accountHolder3 = new BankAccount(3, "Yor A. Forger", 2500.0, 0.5);
   
   public static void main(String[] args) {
      int choice;
      do { 
         choice = BankMenu();
         if (choice == 1) {
            displayAccountInfo();
         } else if (choice == 2) {
            depositToAccount();
         } else if (choice == 3) {
            withdrawFromAccount();
         } else if (choice == 4) {
            transferBetweenAccounts();
         } else if (choice == 5) {
            calculateAccountInterest();
         } else if (choice == 6) {
            getAccountBalance();
         } else if (choice == 7) {
            changeAccountDetails();
         } else if (choice == -1) {
            System.out.println("Invalid input. Please try again.");
         } else if (choice != 8) { 
            System.out.println("Option is not found. Please try again"); 
         }  
      } while (choice != 8); 
         System.out.println("GoodBye");
      }
             
/** Display the menu to the user and have user select an option  
 * 
 */
   public static int BankMenu() {
      int choiceSelected;
      System.out.println();
      System.out.println("Bank Account Menu"); 
      System.out.println("Enter a number between 1-8: ");
      System.out.println("1. Display information of an account"); 
      System.out.println("2. Deposit to an account"); 
      System.out.println("3. Withdraw from an account"); 
      System.out.println("4. Transfer between two accounts");
      System.out.println("5. Calculate Interest"); 
      System.out.println("6. Get the balance of an account"); 
      System.out.println("7. Change Account Details (Name)"); 
      System.out.println("8. Exit");  
      System.out.print("Your option is: "); 
      choiceSelected = console.nextInt();   
      return choiceSelected;
   }
   
   public static void displayAccountInfo() { 
      System.out.println("Display Account Information"); 
      System.out.print("Enter account number: "); 
      int accountNumber = console.nextInt(); 
      boolean FoundAccount = false;
      
      for (BankAccount account : new BankAccount[] {accountHolder1, accountHolder2, accountHolder3}) {
         if (account.getAccountNumber() == accountNumber) {
            FoundAccount = true;
            System.out.println(account.toString());
         }
      }
      
      if (!FoundAccount) {    
         System.out.println("Account " + accountNumber + " not found"); 
      }
   } 
   
   public static void depositToAccount() { 
      System.out.println("Deposit To Account");
      System.out.print("Enter account number: "); 
      int accountNumber = console.nextInt(); 
      System.out.print("Enter deposit amount: "); 
      double amount = console.nextDouble();
      boolean FoundAccount = false;
      
      for (BankAccount account : new BankAccount[] {accountHolder1, accountHolder2, accountHolder3}) {
         if (account.getAccountNumber() == accountNumber) {
            FoundAccount = true;
            System.out.println("Deposit of " + Math.abs(amount) + " is complete.");
            
            account.changeBalance(Math.abs(amount));
            System.out.println("The new amount is: " + account.getBalance());
         }
      }
      
      if (!FoundAccount) { 
         System.out.println("Account " + accountNumber + " not found"); 
      }
   }
   
   public static void withdrawFromAccount() { 
      System.out.println("Withdraw From Account"); 
      System.out.print("Enter account number: "); 
      int accountNumber = console.nextInt(); 
      System.out.print("Amount to withdraw: "); 
      double amount = console.nextDouble(); 
      boolean FoundAccount = false;
      
      for (BankAccount account : new BankAccount[] {accountHolder1, accountHolder2, accountHolder3}) {
         if (account.getAccountNumber() == accountNumber) {
            FoundAccount = true;
            System.out.println("Withdraw of " + amount + " is complete.");
            
            account.changeBalance(amount - Math.abs(amount*2));
            System.out.println("The new amount is: " + account.getBalance());
         }
      }
      
      if (!FoundAccount) { 
         System.out.println("Account " + accountNumber + " not found"); 
      }
   }
   
   public static void transferBetweenAccounts() {
      System.out.println("Transfer Between Accounts"); 
      System.out.print("Enter account number you wish to transfer from: ");
      int accountNumber = console.nextInt(); 
      System.out.print("Enter account number you wish to transfer to: "); 
      int toAccountNumber = console.nextInt(); 
      System.out.print("Enter amount to be transferred: "); 
      double amount = console.nextDouble();
      
      BankAccount fromAccount = null; 
      BankAccount toAccount = null; 
      boolean fromAccountNumbers = false; 
      boolean toAccountNumbers = false;
      
      for (BankAccount account : new BankAccount[] {accountHolder1, accountHolder2, accountHolder3}) {
         if (account.getAccountNumber() == accountNumber) {
            fromAccount = account;
            fromAccountNumbers = true; 
         }
         if (account.getAccountNumber() == toAccountNumber) { 
            toAccount = account;
            toAccountNumbers = true; 
         }
      }

      if(!toAccountNumbers || !fromAccountNumbers) {
         System.out.println("Either one or both account numbers are invalid."); 
      } else { 
         fromAccount.changeBalance(amount-amount*2);
         toAccount.changeBalance(amount);
         System.out.println("Money transfer successful!");
         System.out.println("The new amount for: " + fromAccount.toString());
         System.out.println("The new amount for: " + toAccount.toString());
      }
   }
   
   public static void calculateAccountInterest () {
      System.out.println("Interest"); 
      System.out.print("Enter account number: ");
      int accountNumber = console.nextInt();  
      boolean FoundAccount = false;
   
      for (BankAccount account : new BankAccount[] {accountHolder1, accountHolder2, accountHolder3}) {
         if (account.getAccountNumber() == accountNumber) {
            FoundAccount = true;
            account.calculateInterest();
            System.out.println("Your new balance is: $" + account.getBalance());
         }
      }
      
      if (!FoundAccount) { 
         System.out.println("Account " + accountNumber + " not found"); 
      }
   }
   
   public static void getAccountBalance() { 
      System.out.println("Check Balance"); 
      System.out.print("Enter account number: ");
      int accountNumber = console.nextInt();  
      boolean FoundAccount = false;
      
      for (BankAccount account : new BankAccount[] {accountHolder1, accountHolder2, accountHolder3}) {
         if (account.getAccountNumber() == accountNumber) {
            FoundAccount = true;
/*            System.out.println("Your balance is: $" + account.toString()); */
            System.out.println("Account Holder: " + account.getName());
            System.out.println("Your balance is: $" + account.getBalance()); 

         }
      }
      
      if (!FoundAccount) { 
         System.out.println("Account " + accountNumber + " not found"); 
      }
   }
   
   public static void changeAccountDetails() {
      System.out.println("Change Account Details"); 
      System.out.print("Enter account number: ");
      int accountNumber = console.nextInt();  
      boolean FoundAccount = false;
      
      for (BankAccount account : new BankAccount[] {accountHolder1, accountHolder2, accountHolder3}) {
         if (account.getAccountNumber() == accountNumber) {
         Scanner input = new Scanner(System.in); 
            System.out.print("Enter a new name (First Name, Middle Initial, Last Name): ");
            String newAccountName = input.nextLine();
            account.setName(newAccountName);
            FoundAccount = true;
            System.out.println("Your new name is: " + account.toString());
         }
      }
      
      if (!FoundAccount) { 
         System.out.println("Account " + accountNumber + " not found"); 
      }
   }
   }