/*
Cute Cyclops Cult | Tasnim Chowdhury, Rin Fukuoka, Huebert and Tom, Faiza Huda, Mary, Tape
APCS
HW41 -- Be Rational
2021-12-01
time spent: 1
QCC
- How would you simplify the fraction?
DISCO
- We don't need accessor methods to access private instance variables in the same class type
- When you divide by 0, the return value is NaN.
*/

public class Rational{

  private int numerator;
  private int denominator;

  public Rational() {
    numerator = 0;
    denominator = 1;
  }

  public Rational(int num, int den) {
    if (den != 0) {
      numerator = num;
      denominator = den;
    } else {
      numerator = 0;
      denominator = 1;
    }
  }

  /* Accessor methods:
  public int getNum() {
    return numerator;
  }

  public int getDenom() {
    return denominator;
  }
  */

  public double floatValue(){
    return (double)(numerator) / denominator;
  }

  public String toString() {
    return numerator + "/" + denominator;
  }

  public void multiply(Rational other) {
    //numerator *= other.getNum();
    //denominator *= other.getDenom();
    numerator *= other.numerator;
    denominator *= other.denominator;
  }

  public void divide(Rational other){
    //numerator *= other.getDenom();
    //denominator *= other.getNum();
    numerator *= other.denominator;
    denominator *= other.numerator;
  }

  public static void main( String [] args ) {
    Rational e1 = new Rational(2, 5);
    Rational e2 = new Rational(6, -3);
    Rational e3 = new Rational(1, 0);
    Rational e4 = new Rational(1, 2);

    //Print out the initial value
    System.out.println(e1.toString());   //  2/5
    System.out.println(e2.toString());   //  6/-3
    System.out.println(e3.toString());   //. 0/1

    System.out.println();
    //Print a floating point approxiamtion
    System.out.println(e2.floatValue());
    System.out.println(e2.floatValue());
    System.out.println(e3.floatValue());

    System.out.println();
    //Print products of rational numbers
    e1.multiply(e2);
    System.out.println(e1.toString());    // 12/-15
    e2.multiply(e3);
    System.out.println(e2.toString());    // 0/-3

    System.out.println();
    ////Print quotients of rational numbers
    e1.divide(e4);
    System.out.println(e1.toString()); // 24/-15
    e2.divide(e4);
    System.out.println(e2.toString()); // 0/-3
  }

}
