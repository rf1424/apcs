/*
Neverland: 
Rin Fukuoka (Tape), Diana Akhmedova(Ajax), Marcus Wu (Nat)
APCS
hw14 -- Default and Overloaded Constructors
2021-10-07
*/

/*
DISC: 
Greet.java:37: error: cannot find symbol
		richard3.setHellomsg("Sup");
		        ^
  symbol:   method setHellomsg(String)
  location: variable richard3 of type BigSib
1 error

In this error, the method sethellomsg cannot be found.
This is because there is a typo in "setHellomsg".
It should be "setHelloMsg", which matches the method in class BigSib. 
QCC: 
What would a ckass with multiple constructors look like?
*/

public class Greet {
	public static void main( String [] args) {
		
		String greeting; 

		BigSib richard0 = new BigSib();
		greeting = richard0.greet("freshman"); 
		System.out.println(greeting);

		BigSib richard1 = new BigSib();
		richard1.setHelloMsg("Salutations");
		greeting = richard1.greet("Dr. Spaceman");
		System.out.println(greeting); 

		BigSib richard2 = new BigSib();
		richard2.setHelloMsg("Hey ya");
		greeting = richard2.greet("Kong Fooey");
		System.out.println(greeting);

		BigSib richard3 = new BigSib();
		richard3.setHelloMsg("Sup");
		greeting = richard3.greet("mom");
		System.out.println(greeting); 
	}
} 

