/*Duck Duck Goose - Trio 7 - Gloria Lee, Jonathan Song, Rin Fukuoka
HW20 -- External Audit(testing and breaking BankAccount)
2021-10-19

DISCO - We discovered that in order to declare a variable to be of the short data type, we have to manually write 
(short) in front of the specific short value we are trying to save. We discovered that there were several ways to 
break the code. For example, we could try to withdraw a negative amount from the balance. We could also set the 
password to an integer to produce an error message.

QCC - What is meant exactly by breaking the code? 

*/

public class Teller {
  public static void main (String [] args) {

//test functionality
    BankAccount hacker = new BankAccount ();
    hacker.setName("Goose");
    hacker.setPasswd("whitehat122");
		hacker.setBalance(20000);
  
    //test toString(printing info)  
    System.out.println( hacker.toString());
   
    //test acctNum
    System.out.println("test acctNum" + hacker.setAcctNum(123));//expecting invalid
		System.out.println(hacker.setAcctNum(712234456));//expecting valid
    
    //test PIN
    hacker.setPin((short) 999); //expecting invalid
    hacker.setPin((short) 1254); //expecting valid: 
    
    //test deposit 
		hacker.deposit(500); 
    System.out.println( hacker.toString());
    
    //test withdraw
    hacker.withdraw(100.00);
		hacker.withdraw(120000); //expecting invalid
    System.out.println(hacker.toString());
    
    //test authenticate
    hacker.authenticate(712234456, "whitehat122"); //expecting true
    hacker.authenticate(124129481, "getmein"); //expecting false
  
//break BankAccount
    //
    
    //hacker.setPasswd(10082784);
    hacker.deposit(20.33456);
    hacker.withdraw(-258.12);
    System.out.println(hacker.toString());

    
  }
}
