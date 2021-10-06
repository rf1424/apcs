/*
Elmo's Minions: 
Rin Fukuoka (Tape), Joshua Yagupsky (Quacker), Marcus Wu (Nat) 
APCS
hw12
2021-10-05
*/

/*
DISC: 
Richard is the instance of BigSib(?). 
QCC:
What does "BigSib richard = new BigSib()" represent in Greet.java?
*/

public class BigSib {
	String helloMsg; 
	public void setHelloMsg(String message) {
	helloMsg = message;
	}
	public String greet(String name) {
	return helloMsg + " " + name;
	}
}

