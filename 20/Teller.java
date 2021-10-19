public class Teller {
  public static void main (String [] args) {
    BankAccount hacker = new BankAccount ();
    hacker.setName("Goose");
    hacker.setPasswd("whitehat122");
		hacker.setPin((short) 1254);
		hacker.setAcctNum(712234456);
		hacker.setBalance(20000);
    
    //test toString(printing info)
    System.out.println( hacker.toString());
    
    //test deposit 
		hacker.deposit(500); 
    System.out.println( hacker.toString());
    
    //test withdraw
		hacker.withdraw(120000); //expecting invalid
  }
}
