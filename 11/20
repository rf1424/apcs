/**
Ocho
(Nora, Tasmin, Hamim)
APCS
HW 19 -- Mo Money Mo Problems
2021-10-18
DISCOVERIES:
- Need to manually cast an argument to be of "short" type
UNRESOLVED QUESTIONS:
*/

public class BankAccount {

  //instance variables
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;
  //---------------------------------------------


  //mutators
  public String setName( String newName ) {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd ) {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public short setPin( short newPin ) {
    short oldPin = pin;
		if ((short)1000 <= newPin && newPin <= (short)9998) {
			pin = newPin;
		} else {
			pin = 9999;
			System.out.println("Error: pin (" + pin + ") not a valid 4-digit number. It is set to 9999.");
  }
	return oldPin;
}

	public int setAcctNum( int newAcctNum ) {
    int oldAcctNum = acctNum;
		if (100000000 <= newAcctNum && newAcctNum <= 999999998) {
			acctNum = newAcctNum;
		} else {
			acctNum = 999999999;
			System.out.println("Error: acctNum (" + acctNum + ") not a valid 9-digit number. It is set to 999999999.");
  }
	return oldAcctNum;
}

	public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

  public boolean withdraw( double withdrawAmount ) {
		if (balance >= withdrawAmount) {
			balance -= withdrawAmount;
			return true;
		} else {
			System.out.printf("Your account does not have enough money to withdraw from.");
			return false;
		}
  }


  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }

public boolean authenticate(int accNum, String pass) {
	return (acctNum == accNum) && (passwd == pass);
}

  //main method for testing
  public static void main( String[] args ) {
    BankAccount ba = new BankAccount();
		ba.setName("Ocho");
		ba.setPasswd("pass");
		ba.setPin((short) 1234);
		ba.setAcctNum(987654321);
		ba.setBalance(1500);
		ba.deposit(300);
		ba.withdraw(200);
		String acc = ba.toString();
		System.out.println(acc);
		System.out.println("Authentication: " + ba.authenticate(987654321, "pass") + " (true?)");
		System.out.println("Authentication: " + ba.authenticate(123124214, "Ocho?!") + " (false?)");
		System.out.println(ba.withdraw(10000) + " (error?)");
		System.out.println(ba.withdraw(20) + " (no error?)");
  }//end main()

}//end class BankAccount
