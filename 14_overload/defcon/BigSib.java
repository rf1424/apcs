/*
Neverland: 
Rin Fukuoka (Tape), Diana Akhmedova(Ajax)
APCS
hw14
2021-10-07
*/

/*
DISC: 
When the header is static, it can not work with instance variables.
The instance variables are not within that method. (Help from Piazza@96) 
QCC: 
How do you determine if the method should be public or private?
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

