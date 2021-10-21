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


import java.lang.Math;

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
  

  public static int geoMean(int a, int b) {
    int geoMean1;
    if(a*b>=0){
    	geoMean1 = Math.round(Math.round(Math.sqrt(a + b)));
      return geoMean1;
    }
    else{
      System.out.print("undefined");
      return 0;
    }
  }
  public static double geoMean(double a, double b) {
    double geoMean2;
    if (a*b>=0){
      geoMean2 = Math.sqrt(a + b);
      return geoMean2;
    }
    else{
      System.out.println("undefined");
      return 0;
    }
  }

  public static int geoMean(int a, int b, int c) {
    int geoMean3;
    geoMean3= Math.round(Math.round(Math.cbrt(a*b*c)));
    return geoMean3;
  }
  public static double geoMean(double a, double b, double c) {
    double geoMean4;
    geoMean4 = Math.cbrt(a * b * c);
    return geoMean4;
  }



}//end class
