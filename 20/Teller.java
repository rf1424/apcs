public class Teller {
  public static void main (String [] args) {

//test functionality
    BankAccount hacker = new BankAccount ();
    hacker.setName("Goose");
    hacker.setPasswd("whitehat122");
		hacker.setBalance(20000);
    
    //test acctNum
    hacker.setAcctNum(123);//expecting invalid
		hacker.setAcctNum(712234456);//expecting valid
    
    //test PIN
    hacker.setPin((short) 999)) //expecting invalid
    hacker.setPin((short) 1254); //expecting valid: 
    
    //test toString(printing info)
    System.out.println( hacker.toString());
    
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
    //test withdraw
   
    
  }
}

  

