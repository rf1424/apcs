/**
   Duck Duck Goose: Gloria Lee (Flounder), Jonathan Song (Phoenix), Rin Fukuoka (Tape)
   APCS
   HW20 --
   2021-10-21
   TASK:
   Implement each method without typecasting.
   xtra: harmonic mean is the reciprocal of the
   arithmetic mean of the reciprocals
 **/


public class Stats {

  public static int mean(int a, int b) {
    int mean;
    mean = (a + b)/2;
    return mean;

  }
   
   
   public static double mean(double a, double b) {
     double mean; 
     mean = a/2 + b/2;
     return mean;
  }


  public static int max(int a, int b) {
    int max;
    if (a >= b) { 
      max = a;
      }
    else {
      max = b;
      }
    return max;      
  }

  public static double max(double a, double b) {
    double max;
    if (a >= b) { 
      max = a;
      }
    else {
      max = b;
      }
    return max;
  }
  
/*
  public static int geoMean(int a, int b) {

  }

  public static double geoMean(double a, double b) {

  }

  public static int max(int a, int b, int c) {

  }

  public static double max(double a, double b, double c) {

  }

  public static int geoMean(int a, int b, int c) {

  }

  public static double geoMean(double a, double b, double c) {

  }
*/

  //main method for testing functionality
  public static void main( String[] args ) {
  }

}//end class
