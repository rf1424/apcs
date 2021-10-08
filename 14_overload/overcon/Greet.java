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
What would a class with multiple constructors look like?
*/

public class Greet {
	public static void main(String [] args) {
		String greeting; 
		
		BigSib richard = new BigSib();
		greeting = richard.greet("Freshman");
		System.out.println(greeting); 

		BigSib tracy = new BigSib("Salutations");
		greeting = tracy.greet("Dr. Spaceman");
		System.out.println(greeting);

		BigSib grizz = new BigSib("Hey ya"); 
		greeting = grizz.greet("kong Fooey");
		System.out.println(greeting);

		BigSib dotCom = new BigSib("Sup");
		greeting = dotCom.greet("mom");
		System.out.println(greeting);
	}
} 
