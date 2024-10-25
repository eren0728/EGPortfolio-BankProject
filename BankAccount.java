/**
   Assignment of a simple BankAccount 
   @author EG
   @version CS141 Section DEA 03/08/2023
*/ 
public class BankAccount { 
   private int accountNumber;
   private String accountHolderName;
   private double balance; 
   private double interestRate; 
   
 /** Default constructors 
 * set the account Number 0, set balance to 0.0 
 * set the accountHolderName to "",  set interestRate to 0.0 
 */ 
   public BankAccount() {
      this.accountNumber = 0; 
      this.accountHolderName = ""; 
      this.balance = 0.0;
      this.interestRate = 0.0; 
   } 
   /**Full constructors for bank account class 
   * take account number, account holder name, balance, and interestRate as parameter
   */
   public BankAccount(int accountNumber, String accountHolderName, double balance, double interestRate) { 
      this.accountNumber = accountNumber; 
      this.accountHolderName = accountHolderName; 
      this.balance = balance; 
      this.interestRate = interestRate; 
  }
  /**returns a string in the format 
  * accountHolderName : accountHolderName [accountNumber] :: Balance:
  * $balance
  */
  public String toString() {
   return this.accountHolderName + " [" + this.accountNumber + "]:: Balance: $" + this.balance;
  }
   /**returns account name of the person bank account
  * @return account holder name  
  */
  public String getName() { 
      return accountHolderName; 
  }
  /** returns balance of the person bank account 
  * @return the balance
  */
   public double getBalance() {
   return balance; 
  }
  /** returns account number of the person bank account 
  * @return the account
  */
  public int getAccountNumber() { 
   return accountNumber; 
  } 
  /** change the account holder name on the account with new name 
  * account new name should display "first name middle initial. last name "
  */
  public void setName(String newName) {
  int firstIndex = newName.indexOf(" "); 
  int lastIndex = newName.lastIndexOf(" "); 
  
  String firstName = newName.substring(0,firstIndex);
  String middleInitial = ""; 
  String lastName = newName.substring(lastIndex + 1); 
  
  if (lastIndex > firstIndex) {
  middleInitial = newName.substring(firstIndex + 1, firstIndex + 2) + ".";
  }

  String newHolder = firstName + " " + middleInitial + " " + lastName;
  this.accountHolderName = newHolder; 
  }
  /** add the amount variable x to the balance x can be positive or negative
  * @param x the amount to add to the balance (deposit) 
  * @param x the amount subtracted to the balance (withdraw)
  */ 
  public void changeBalance(double x) { 
    if (x >= 0) {
        this.balance += x; // deposit
    } else {
        this.balance += x; // withdraw
        if (this.balance < 0) { 
            this.balance = 0; // set balance to 0 if it goes negative
  }
  }
  }
  /** Interest rate to rate in percent 
  * @param rate of the interest rate to set 
  */ 
  public void setInterestRate(double rate) { 
  this.interestRate = rate; 
  } 
  /** calculate the interest based on years. interest amount will be the
  * account balance * interestRate / 100.
  *The method should add the interest amount to balance
  */
  public void calculateInterest() { 
  double interestAmount = this.balance * this.interestRate / 100; 
  this.balance += interestAmount; 
  } 
}