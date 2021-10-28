/**
   Duck Duck Goose: Gloria Lee (Flounder), Jonathan Song (Phoenix), Rin Fukuoka (Tape)
   APCS
   HW26 -- GCD in three ways
   2021-10-27
   time spent: 1.5hr
   QCC:
   Is recursion or iteration more effective in this example? Should we set up ifelse statements to individally address special cases such as where 0 is involved or negative numbers?
   What is the name of this algorithm? Why is it so well known?
   DISCO:
   We discovered from the feedback that we received on our flow chart that there are many cases that will break this code for the iterative method. For example, if a and b
   are both negative numbers like -1 and -1 for example, -1 is returned instead of 1. Also, if the code involves a zero as one of the inputs, the code will run forever because
   a number minus zero equals the same number.
   ALGO:
   For all three methods - If (at least) one of the inputs is 0, return the other input.
                           Take the absolute value of both inputs.

   For brutal force - Take one of the two inputs, namely a. Keep decreasing a by 1 until it divides both inputs.
                      After that return the decreased a value.
   For recursive - Uses method gcdER(int a, int b) and returns a only if a=b and if a!=b,
                   the method recursively calls on gcd(a-b,b) or gcd(a, b-a) depending on whether a>b or b>a.
   for iterative - While a!=b, change value of a to a-b if a>b or change value of b to b-a if b>a. When a=b, return a.
**/

import java.lang.Math;
public class Stats {

//main method
  public static void main(String [] args) {
    //test brute force
    System.out.println( "expecting 3: " + gcd(12, 15));
    System.out.println( "expecting 5: " + gcd(10, -15));
    System.out.println( "expecting 6: " + gcd(0, 6));
    System.out.println( "expecting 3: " + gcd(-9, -12));

    //test recursive
    System.out.println("expecting 3: " + gcdER(3, 9));
    System.out.println("expecting 4: " + gcdER(-16,4));
    System.out.println("expecting 2: " + gcdER(2,0));
    System.out.println("expecting 4: " + gcdER(-16,-20));

    //test iterative
    System.out.println( "expecting 3: " + gcdEW(12, 15));
    System.out.println( "expecting 1: " + gcdEW(1, 15));
    System.out.println( "expecting 1: " + gcdEW(-1, 15));
    System.out.println( "expecting 10: " + gcdEW(10, 0));

  }

//brute force
  public static int gcd( int a, int b ) {
    if (a==0) {return b;}
    if (b==0) {return a;}
    a=Math.abs(a);
    b=Math.abs(b);
    int divisor = a;
    while ((a % divisor != 0) || (b % divisor != 0)) {
      divisor = divisor - 1;
    }
  	return divisor;
  }

//recursive
public static int gcdER(int a, int b){
  a=Math.abs(a);
  b=Math.abs(b);
  if (a==0) {return b;}
  if (b==0) {return a;}
  if (a==b){
    return a;
  }
  else if(a>b){
    return gcdER(a-b,b);
  }
  else{
    return gcdER(a, b-a);
  }
}


//iterative
 public static int gcdEW(int a, int b){
    if (a==0) {return b;}
    if (b==0) {return a;}
    a=Math.abs(a);
    b=Math.abs(b);

    while (a != b) {
      if (a > b) {
        a = a-b;
      }
      else {
        b = b-a;
      }
    }
   return a;
  }


  }//end of class


  
