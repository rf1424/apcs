public class Driver{

public static void main( String [] args ) {
    Rational e1 = new Rational(2, 5);
    Rational e2 = new Rational(6, -3);
    Rational e3 = new Rational(1, 0);
    Rational e4 = new Rational(1, 2);

    //Print out the initial value
    System.out.println(e1.toString());   //  2/5
    System.out.println(e2.toString());   //  6/-3
    System.out.println(e3.toString());   //  0/1

    Rational e6 = new Rational(2, 5);
    Rational e7 = new Rational(1, 3);
    Rational e8 = new Rational(4, 8);

    System.out.println();
    //Compare two rational numbers
    System.out.println(e7.compareTo(e8)); // -1
    System.out.println(e7.compareTo(12)); // -1


  }
}
