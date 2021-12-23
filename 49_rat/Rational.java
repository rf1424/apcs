/*
Cute Cyclops Cult | Tasnim Chowdhury, Rin Fukuoka, Huebert and Tom, Faiza Huda, Mary, Tape
APCS
HW49: Rational Standards Compliance

DISCO-
-throwing new exceptions woah so cool
-will stop all of code unless use try-catch
QCC-
-Why do we need equalsto method?

2021-12-22
time spent: 0.5
*/

public class Rational implements Comparable{

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

	public int compareTo(Object o) {
		if (o instanceof Rational) {
			Rational other = (Rational) o;
    	int otherCProduct = denominator * other.numerator;
    	int CProduct = numerator * other.denominator;
    	if (CProduct > otherCProduct) {
      	return 1; //positive meaning calling object is greater than parameter
    	} else if (otherCProduct > CProduct) {
      	return -1; //negative meaning calling object is less than paramter
    	} else {
      	return 0; //zero meaning they have the same value
      }
  	} else {
    	throw new ClassCastException("\nCompareTo() input not a Rational");
		}
  }


  public boolean equals(Object other){
    if (other instanceof Rational) {
      if ((compareTo(other)) == 0) {
        return true;
      } else {
        return false;
      }
    } else {
      throw new ClassCastException("\nCompareTo() input not a Rational");
    }
  }


}
