/*
Duck Duck Goose - Gloria Lee (Flounder), Jonathan Song (Phoenix), Rin Fukuoka (Tape)
APCS
HW19 - Mo Money Mo Problems ...MORE AWESOME
2021-10-18
QCC: How do you mark down code on Piazza? Why are the instance variables private instead of public? 
DISCO: We discovered that while copying pasting code from Piazza, we got an error that said illegal character. We eventually figured out that this was because of something related to spaces in Piazza when we tried to display code. We fixed this issue 
by getting rid of the original spaces from each new line in the piazza copied pasted code and clicking enter for new line ourselves. 
Lastest and Greatest Q2 Response: We know that before we write our own constructor, Java provides us with a constructor because when we create a new object using
ClassName objectName = new ClassName() and then we try to print out the instance variables of that objectName, the output is null for Strings and 0 for primitives.
Latest and Greatest Q3 Response:To try to figure out if it's possible to output a string representation of an object, we can try to run System.out.println(objectName).
*/

public class BankAccount{
//instance variables
  private String fullName;
  private String password;
  private int pin;
  private int accountNumber;
  private double accountBalance;

//setting instance variables
  public String setName(String newName){
    String oldName = fullName;
    fullName = newName;
    return oldName;
  }

  public String setPassword(String newPassword){
    String oldPassword = password;
    password = newPassword;
    return oldPassword;
  }

  public int setPin( int newPin ) {
    int oldPin = pin;
    if(newPin<1000 || newPin>9998){
      pin = 9999;
      System.out.println("Invalid PIN number. PIN number should only be a 4 digit number with some value between 1000 and 9998.");
    }
    else{
      pin = newPin; 
    }
    return oldPin;
    
  }

  public int setAccountNumber( int newAccountNumber ) {
    int oldAccountNumber = accountNumber;
    if (newAccountNumber >= 100000000 && newAccountNumber < 999999999) {
      accountNumber = newAccountNumber;
    }
    else {
      accountNumber = 999999999;
      System.out.println("Invalid account number.");
      }
    return oldAccountNumber;
  }

  public double setBalance( double newBalance ) {
    double oldBalance = accountBalance;
    accountBalance = newBalance;
    return oldBalance;
  }




//deposit
  public void deposit(double depositAmount){
    accountBalance = accountBalance + depositAmount;

  }
//withdraw
  
  public boolean withdraw(double withdrawAmount){
    if (accountBalance >= withdrawAmount){
      accountBalance -= withdrawAmount;
      return true;
      } else {
      System.out.println("Not enough money in account to withdraw");
        return false;
      }
  }
  
  public boolean authenticate(int myNum, String myPass){
    if(myNum == accountNumber && myPass==password){
      return true;
    }
    else{
      return false;
    }
  }
  

//overwritten String
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + fullName;
    retStr = retStr + "\nPassword: " + password;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + accountNumber;
    retStr = retStr + "\nBalance: " + accountBalance;
    retStr = retStr + "\n=======================";
    return retStr;
  }

//main method
  public static void main(String[] args){
    BankAccount ba = new BankAccount();
    ba.setName("Flounder");
    ba.setPassword("abcdefg11");
    ba.setPin(1234);
    ba.setAccountNumber(167);
    ba.setBalance(2389.58);
    System.out.println( ba.toString());
    ba.deposit(1245.39);
    System.out.println( ba.toString());
    ba.withdraw(385.29);
    System.out.println( ba.toString());
    
    //testing conditionals 
    BankAccount richard = new BankAccount();
    richard.setName("rich123");
    richard.setPassword("richardo");
    richard.setBalance(100005.25);
    //PIN
    richard.setPin(100000); //expecting invalid outcome
    System.out.println( richard.toString());
    richard.setPin(1233); //expecting valid outcome
    System.out.println( richard.toString());
    
    //Account Number 
    richard.setAccountNumber(99999999); //expecting invalid outcome
    System.out.println( richard.toString());
    richard.setAccountNumber(122348635); //expecting valid outcome
    System.out.println( richard.toString());
    
    //Withdraw
    System.out.println (richard.toString());
    richard.withdraw(24.23); //expecting valid withdrawal amount
    System.out.println(richard.toString());
    richard.withdraw(1012430914209809124.12);//expecting invalid withdrawal amount
    
    System.out.println(richard.toString());
    System.out.println(richard.authenticate(99999989, "richardo"));

  }

}
