/***
Team Jaundice
Roster: Ethan Lam(Carl), Rin Fukuoka(Tape)
APCS
HW24 -- Loop
2021-10-25
time spent: 1.5 hours

DISC:
How to use the while loop: while the boolean is true, loop runs.
Instance of a class can be a parameter.
QCC:
Is there a way to write this more concisely/conbine any of the methods with loops?
POST-v0 MODS:
Added flipCtr to the flip method.
Added this() constructor.
***/
/***
    driver for class Coin
    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run. Note anything notable.
    2. Move the "TOP" line down, so that it is below the first statement.
    (emacs: with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    (your editor: ???)
    3. Compile and run again.
    4. Resolve errors one at a time until it works.
    5. Repeat 2-4 until TOP meets BOTTOM.
***/

public class Driver {

  public static void main( String[] args ) {

    //build Objects from blueprint specified by class Coin


    //test default constructor

      //1st overloaded constructor
      Coin yours = new Coin( "quarter" );
      //2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );

    //running flupUntilHeads
      flipUntilHeads(yours, wayne, 20);
      System.out.println("Flip until heads:");
      System.out.println("yours number of heads: " + yours.getHeadsCtr() + "\nyours number of tails: "
                         + yours.getTailsCtr() + "\nwayne number of flips: " + yours.getFlipCtr());

      System.out.println("wayne number of heads: " + wayne.getHeadsCtr() + "\nwayne number of tails: "
                         + wayne.getTailsCtr() + "\nwayne number of flips: " + wayne.getFlipCtr());


    //running flipUntilMatches
    	wayne.reset("heads", 0.5);
    	yours.reset("heads", 0.5);
    	flipUntilMatches(yours, wayne, 20);
      System.out.println("\nFlip Until matches:");
      System.out.println("yours number of heads: " + yours.getHeadsCtr() + "\nyours number of tails: "
                         + yours.getTailsCtr() + "\nwayne number of flips: " + yours.getFlipCtr());
      System.out.println("wayne number of heads: " + wayne.getHeadsCtr() + "\nwayne number of tails: "
                         + wayne.getTailsCtr() + "\nwayne number of flips: " + wayne.getFlipCtr());

      wayne.reset("heads", 0.5);
    	yours.reset("heads", 0.5);
    	flipUntilBM(yours, wayne);
      System.out.println("\nFlip Until 65536:");
      System.out.println("yours number of heads: " + yours.getHeadsCtr() + "\nyours number of tails: "
                         + yours.getTailsCtr() + "\nwayne number of flips: " + yours.getFlipCtr());
      System.out.println("wayne number of heads: " + wayne.getHeadsCtr() + "\nwayne number of tails: "
                         + wayne.getTailsCtr() + "\nwayne number of flips: " + wayne.getFlipCtr());

      } //end main()


	public static void flipUntilHeads(  Coin c1, Coin c2, int x) {

    while ( c1.getHeadsCtr() + c2.getHeadsCtr() < x) {
      c1.flip();
      c2.flip();

    }
	}


  public static void flipUntilMatches( Coin c1, Coin c2, int y) {
    int matchCtr = 0;
    while ( matchCtr < y) {
      c1.flip();
      c2.flip();
      if ( c1.equals(c2)) {
        matchCtr++;
      }
    }
  }

  public static void flipUntilBM( Coin c1, Coin c2) {
    int matchCtr = 0;
    while ( matchCtr < 65536 || matchCtr % 2004 != 0) {
      c1.flip();
      c2.flip();
      if ( c1.equals(c2)) {
        matchCtr++;
      }
    }
  }

}//end class
