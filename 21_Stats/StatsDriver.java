public class StatsDriver {

  public static void main(String[]args){
    System.out.println(Stats.mean(2,4));//expected output 3
    System.out.println(Stats.mean(3,3));//expected output 3
    System.out.println(Stats.mean(0,0));//expected output 0
    System.out.println(Stats.mean(-4,4));//expected output 0
    
    System.out.println(Stats.mean(24.50,26.50));//expected ouput 25.50
    System.out.println(Stats.mean(12.00,14.00));//expected output 13.00
    System.out.println( Stats.mean(0.00, 100.00));//expected output 50.00
    System.out.println(Stats.mean(-12.00,-10.00));//expected output -11.00
  
/*   
    System.out.println(Stats.max(15,20));//expected output 20
    System.out.println(Stats.max(90,90);//expected output 90
    System.out.println(Stats.max(-10,-5);//expected output -5
    System.out.println(Stats.max(0,-4);//expected output 0
    
    System.out.println(Stats.max(11.236,376.124));//expected output 376.124
    System.out.println(Stats.max(1.00,1.00));//expected output 1.00
    System.out.println(Stats.max(-9.00,-24.000));//expected output -9.00
    System.out.println(Stats.max(0.000,0.00));//expected output 0.000
    
    System.out.println(Stats.geoMean(4,9));//expected output 6
    System.out.println(Stats.geoMean(0,0));//expected output 0
    System.out.println(Stats.geoMean(-9,4));//expected output error
    System.out.println(Stats.geoMean(-9,-4));//expected output 6
    
    System.out.println(Stats.geoMean(4.00,9.00));//expected output 6.00
    System.out.println(Stats.geoMean(0.00,0.00));//expected output 0.00
    System.out.println(Stats.geoMean(-9.00,4.00));//expected output error
    System.out.println(Stats.geoMean(-9.00,-4.00));//expected output 6.00
*/
  }


}
