/***
Team Jaundice
Roster:Ethan Lam, Rin Fukuoka
APCS
HW23 -- Coin
2021-10-24
time spent: 2.3hr

DISC:
-You must redeclare an instance variable in an overloaded constructor or else it will be reset to 0,
even if you declared it in the default constructor.
-You can call an instance variable of a class.

QCC:
Why do need two overloaded constructors?

***/

import java.lang.Math;
public class Coin {

  //attributes aka instance vars
  private int value;
  private String upFace;
  private String name;
  private int flipCtr;
  private int tailsCtr;
  private int headsCtr;
  private double bias;

  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/

  public Coin() {
  	reset("heads", 0.5);
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
 ***/
  public Coin( String s ) {
  	name = s;
    value = 0;
    upFace = "null";
    flipCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
  }

/***
      Coin(String,String) --
      precond:
      postcond:
***/

  public Coin( String s, String nowFace ) {
  	name = s;
  	upFace = nowFace;
    value = 0;
    flipCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
  }



  // Accessors...
  // ----------------------------
  public String getUpFace() {
		return upFace;
  }

  public int getFlipCtr() {
		return flipCtr;
  }

  public double getValue() {
    return value;
  }

  public int getHeadsCtr() {
    return headsCtr;
  }

  public int getTailsCtr() {
    return tailsCtr;
  }
  // ----------------------------


/***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
***/


  private double assignValue( String s ) {
		if (s.equals("penny")) {
      value = 1;
    }
    else if (s.equals("nickel")) {
      value = 5;
    }
    else if (s.equals("dime")) {
      value = 10;
    }
    else if (s.equals("quarter")) {
      value = 25;
    }
    else if (s.equals("half dollar")) {
      value = 50;
    }
    else if (s.equals("dollar")) {
      value = 100;
    }
    else {
      value = 0;
      System.out.println("invalid coin");
    }
    return value;
  }

/***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
 ***/
  public void reset( String s, double d ) {
    if (s.equals("heads") || s.equals("tails") {
			if ( d <= 1.0 && d >= 0.0){
        bias = d;
        upFace = s;
        flipCtr = 0;
        tailsCtr = 0;
      }
    }
    else {
      System.out.println("input invalid denomination or bias");
  }
}
/***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
***/

  public String flip() {

    double number = Math.random(); //sets number to a floating point in between 0 and 1
    if (number <= bias) {
      upFace = "heads";
      headsCtr++;
    }
    else {
      upFace = "tails";
      tailsCtr++;
    }
      return upFace;
  }


/***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
***/

public boolean equals( Coin other ) {
    if (other.upFace.equals("null")) {
      return false;
    }
    else if (other.upFace.equals(upFace)) {
      return true;
    }
    else {
      return false;
    }
  }


/***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
***/
  public String toString() {
   return name + " " + upFace;
  }



}//end class
