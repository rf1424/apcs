/*
Duck Duck Goose - Gloria Lee (Flounder), Jonathan Song (Pheonix), Rin Fukuoka (Tape)
APCS
HW18 - CPA-one
2021-10-14
QCC: When do we use static and when do we not? What does static do exactly? When is it a good idea to make instance variables/methods private or public?
DISCO: I initially did not include static with my instance variables and when I tried to run my code, I got this:
error: non-static variable fullName cannot be referenced from a static context
I'm still now sure exactly what static does and when we should use it. 
I also found that using a constructor would be more efficient than setting up methods to set each individual variable, but there may be times 
when using individual methods for each variable would be better. 
Lastest and Greatest Q2 Response: When instance variables are printed before creating constructors, 
the output is null for Strings and 0 for primitives. 
Latest and Greatest Q3 Response:
*/

public class BankAccount{
	static String fullName; 
	static String password;
	static int pin;
	static int accountNumber;
	static double accountBalance; 


	public BankAccount(String a, String b, int c, int d, double f){
		fullName = a;
		password = b;
		pin = c;
		accountNumber = d;
		accountBalance = f;
	}

	public static void infoPrint(){
		System.out.println("Name: " + fullName);
		System.out.println("Password: " + password);
		System.out.println("PIN: " + pin);
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Balance: " + accountBalance + " dollars");
	}

	public static void deposit(double depositAmount){
		accountBalance = accountBalance + depositAmount;
	}

	public static void withdraw(double withdrawAmount){
		accountBalance = accountBalance + withdrawAmount;
	}

	
	public static void main(String [] args){
		BankAccount firstAccount = new BankAccount("Flounder", "you'll never guess", 1234, 1, 10000.99);
		infoPrint();
		withdraw(200.49);
		infoPrint();
		deposit(2343.53);
		infoPrint();
	}


}
