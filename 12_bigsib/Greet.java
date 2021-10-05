/*
Elmo's Minions: 
Rin Fukuoka (Tape), Joshua Yagupsky (Quacker), Marcus Wu (Nat) 
APCS
hw09
2021-10-4
*/


public class Greet {
  public static void main( String[] args ) {
    String greeting;

    BigSib richard = new BigSib();
    richard.setHelloMsg("Word up");

    greeting = richard.greet("freshman");
    System.out.println(greeting);

  } //end main()
} //end Greet
