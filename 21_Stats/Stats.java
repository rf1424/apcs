/**
   Duck Duck Goose: Gloria Lee (Flounder), Jonathan Song (Phoenix), Rin Fukuoka (Tape)
   APCS
   HW20 -- Stats.java and its tests
   2021-10-21
   TASK:
   Implement each method without typecasting.
   xtra: harmonic mean is the reciprocal of the
   arithmetic mean of the reciprocals
 
DISCO: 
The math class contains specific methods for mathematical operations, including a method to find the cube root. 
It's possible to change the data types of variables. For example, we were able to change the data type of mean from int to double.
QCC: 
What does typecasting mean exactly? 
Why do we get lossy conversion errors? 
What should have been returned if there was a negative value to take the square root of? 
What are some alternates to typecasting to avoid the lossy conversion error?
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
