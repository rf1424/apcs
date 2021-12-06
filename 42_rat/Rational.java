/*
Cute Cyclops Cult | Tasnim Chowdhury, Rin Fukuoka, Huebert and Tom, Faiza Huda, Mary, Tape
APCS
HW42 -- Be More Rational
QCC-
 - We used piazza to assess whether or not we should have two gcd methods and decided thusly
 - Why do we have two gcd methods?
DISCO-
 - nothing to report here

2021-12-05
time spent: 1

*/

public class Rational{

  private int numerator;
  private int denominator;

  //default constructor
  public Rational() {
    numerator = 0;
    denominator = 1;
  }

  //constructor
  public Rational(int num, int den) {
    this();
    if (den != 0){
      numerator = num;
      denominator = den;
    }
    else {
      System.out.println( "Invalid number. " +
                          "Number set to 0/1.");
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
    this.numerator *= other.numerator;
    this.denominator *= other.denominator;
  }

  public void divide(Rational other){
    //numerator *= other.getDenom();
    //denominator *= other.getNum();
    this.numerator *= other.denominator;
    this.denominator *= other.numerator;
  }

  public void add(Rational other){
    int d = this.denominator;
    this.denominator = d * other.denominator;
    this.numerator = this.numerator * other.denominator;
    this.numerator += d * other.numerator;
  }

  public void subtract(Rational other){
    int d = this.denominator;
    this.denominator = d * other.denominator;
    this.numerator = this.numerator * other.denominator;
    this.numerator -= d * other.numerator;
  }

  public static int gcd( int num1, int num2){
    if (num2 == 0){
      return num1;
    }
    else {
      return gcd(num2, Math.abs(num1-num2));
    }
  }

  public int gcd() {
    /**
    int num = Math.abs(numerator);
    int den = Math.abs(denominator);
    for (int i = den; i > 0; i--){
      if ((num % i == 0)&&(den % i == 0)){
        return i;
      }
    }
    return 1;
    **/
    return gcd(numerator, denominator);
  }

  public void reduce() {
    int gcd = gcd();
    numerator = numerator / gcd;
    denominator = denominator / gcd;
  }

	public int compareTo(Rational other) {
    int otherCProduct = denominator * other.numerator;
    int CProduct = numerator * other.denominator;
    if (CProduct > otherCProduct) {
      return 1; //positive meaning calling object is greater than parameter
    } else if (otherCProduct > CProduct) {
      return -1; //negative meaning calling object is less than paramter
    } else {
      return 0; //zero meaning they have the same value
    }

  }



  public static void main( String [] args ) {
    Rational e1 = new Rational(2, 5);
    Rational e2 = new Rational(6, -3);
    Rational e3 = new Rational(1, 0);
    Rational e4 = new Rational(1, 2);

    //Print out the initial value
    System.out.println(e1.toString());   //  2/5
    System.out.println(e2.toString());   //  6/-3
    System.out.println(e3.toString());   //  0/1

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
    //Print quotients of rational numbers
    e1.divide(e4);
    System.out.println(e1.toString()); // 24/-15
    e2.divide(e4);
    System.out.println(e2.toString()); // 0/-3


    Rational e6 = new Rational(2, 5);
    Rational e7 = new Rational(1, 3);
    Rational e8 = new Rational(4, 8);

    System.out.println();
    //Print sum of rational numbers
    e6.add(e7);
    System.out.println(e6.toString()); // 11/15

    System.out.println();
    //Print difference of rational numbers
    e7.subtract(e8);
    System.out.println(e7.toString()); // -4/24

    System.out.println();
    //Print out gcd
    System.out.println(e6.gcd()); // 1
    System.out.println(e7.gcd()); // 4
    System.out.println(e8.gcd()); // 4

    System.out.println();
    //Print out reduced number
    e7.reduce();
    e8.reduce();
    System.out.println(e7.toString()); // -1/6
    System.out.println(e8.toString()); // 1/2

    System.out.println();
    //Compare two rational numbers
    System.out.println(e7.compareTo(e8)); // -1


  }


}
