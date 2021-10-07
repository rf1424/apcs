/*
Neverland: 
Rin Fukuoka (Tape), Diana Akhmedova(Ajax)
APCS
hw13
2021-10-06
*/

/*
DISC: 
When the header is static, it can not work with instance variables.
The instance variables are not within that method. (Help from Piazza@96) 
QCC: 
How do you determine if the method should be public or private?
*/

public class Greet {
	public static void main( String [] args) {
		
		String greeting; 

		BigSib richard0 = new BigSib("Word up");
		greeting = richard0.greet("freshman"); 
		System.out.println(greeting);

		BigSib richard1 = new BigSib("Salutations");
		greeting = richard1.greet("Dr. Spaceman");
		System.out.println(greeting); 

		BigSib richard2 = new BigSib("Hey ya");
		greeting = richard2.greet("Kong Fooey");
		System.out.println(greeting);

		BigSib richard3 = new BigSib("Sup");
		greeting = richard3.greet("mom");
		System.out.println(greeting); 
	}
} 

