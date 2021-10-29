/*
The Demoninators (Neil Lin + Hatch, Gabriel Thompson + Iggy, Rin Fukuoka + Tape)
APCS
HW27: FOR the Love of Strings
2021 - 10 - 28
Time Spent: 0.5hrs


DISCO:
 - We learned how to implement for loops.
 - We learned how .substring() works, from the docs.
 - For fenceF(), you can either run the for loop to iterate through the counter in ascending order, or descending order.

QCC:
 - When we tried to set the value of a String to the charAt() of a String, it yielded the error "incompatible types: char cannot be converted to String".
   When we changed the datatype of the variable to char, the error message dissappeared? Why? What does this mean?
 - On the same vein as the previous question, why were we able to concatenate a char onto a String in line {49}, but not set a String to a char?
 
*/

public class Rof {
  public static void main( String[] args ) {
    //test fenceF
    System.out.println("3 posts: " + fenceF(3));
    System.out.println("5 posts: " + fenceF(5));
    //test reverseF
    System.out.println("ReversedF 'hello world': " + reverseF("hello world"));
    System.out.println("ReversedF 'stressed': " + reverseF("stressed"));
    //test reverseR
    System.out.println("ReversedR 'hello world': " + reverseR("hello world"));
    System.out.println("ReversedR 'stressed': " + reverseR("stressed"));
  }

  //fenceF FOR LOOP
  public static String fenceF( int posts ) {
    String fence = "|";

  	for ( int p = posts; p > 1; p-- ) {
      fence += "--|";
    }

    return fence;
  }

  //reverseF FOR LOOP
  public static String reverseF( String s ) {
    String reversed = "";

    for ( int position = s.length() - 1; position >= 0; position-- ) {
      reversed += s.charAt(position);
    }

    return reversed;
  }

  // reverseR RECURSION
  public static String reverseR( String s ) {
    int len = s.length();

    if (len > 1) {
      char lastChar = s.charAt(len - 1);
      return lastChar + reverseR(s.substring(0, len-1));
    }
    return s;
  }
}
