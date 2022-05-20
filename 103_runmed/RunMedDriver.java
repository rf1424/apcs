/**
   driver file for testing class RunMed

   (RunMed provides for calculating a running median
   of a stream of input ints)

   USAGE: Runnable as-is.
   Uncomment RunMed-specific lines below once RunMed is implemented.
   Compile, run fr same dir as RunMed.java

   to feed numbers manually:
   $ java RunMedDriver

   to feed in prepared set:
   $ java RunMedDriver < input.nums
   (input.nums provided; must be in same dir)

   -------------------------
   Clyde "Thluffy" Sinclair
   APCS
   2018-05-17
*/

import java.util.Scanner;

public class RunMedDriver
{
  public static void main( String[] args )
  {

    RunMed r = new RunMed();

    // int n;
    // double median;
    // int count = 0;
    // Scanner sc = new Scanner( System.in );

    // while( sc.hasNextInt() ) {
    //   try {
    //     n = sc.nextInt();
    //     System.out.print("read " + n + "\n");
    //
    //     count++;
    //     System.out.print("this many ints have been seen: " + count + "\n");
    //
    //     r.add(n);
    //     median = r.getMedian();
    //     System.out.print("median is now " + median + "\n");
    //   } catch (Exception e) {
    //     System.err.println("BOOP! probs w yer input:\n"+e);
    //   }
    // }

    r.add(1);
    r.add(2);
    r.add(5);
    r.add(7);
    r.add(3);
    r.add(6);
    r.add(4);
    double median = r.getMedian();
    System.out.println("median is now " + median); //4
    r.add(8);
    double median2 = r.getMedian();
    System.out.println("median is now " + median2); //4.5

  }//end main

}//end class
