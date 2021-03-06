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


public class BigSib {
	String helloMsg;
	public BigSib() {
		helloMsg = "Word up";
		}
	public void setHelloMsg(String msg) {
		helloMsg = msg;
	}
	public String greet(String name) {
		return helloMsg + " " + name;
		}
	
}

