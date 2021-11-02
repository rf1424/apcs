/**
   Duck Duck Goose: Gloria Lee (Flounder), Jonathan Song (Phoenix), Rin Fukuoka (Tape)
   APCS
   HW29 -- Which Way Do You Roll?
   2021-11-2
   time spent: 1.2hr

   QCC:
   -Why did we have to specify that our commafy methods only take an integer input when it would be more convenient to instead
   have the commafy methods take String input and not have to convert the String into an int and back again?

   -How do pre increment operators tie into this?

   -Is there a more efficient way than the methods we wrote to commafy?

   DISCO: 
   -The leftmost index, starting at 0 from the rightmost digit, will be one less than its string length.
**/

public class Commafier {

  public static void main(String [] args) {

		for (String s: args) {
      System.out.println( "Recursive: " + commafyR(Integer.parseInt(s)));
      System.out.println( "Iterative: " + commafyF(Integer.parseInt(s)));
    }
    /*
      System.out.println( commafyR(1));
      System.out.println( commafyR(10));
      System.out.println( commafyR(101));
      System.out.println( commafyR(1000));
      System.out.println( commafyR(12345));
      System.out.println( commafyR(1124924929));


      System.out.println(commafyF(1));
      System.out.println(commafyF(10));
      System.out.println(commafyF(101));
      System.out.println(commafyF(1000));
      System.out.println(commafyF(12345));
      System.out.println(commafyF(19333749));
    */
  }



  public static String commafyR(int n) {
    String nString = Integer.toString(n);
    int length = nString.length();
    if (length < 4) {
      return nString;
    }
    else {
      String addString = nString.substring(length-3, length);
      String restString = nString.substring(0, length-3);
      int restInteger = Integer.parseInt(restString);
      return (commafyR(restInteger) + "," + addString);
    }
  }


  public static String commafyF(int n) {
    String nString = Integer.toString(n);
    int length = nString.length();
     if (length < 4) {
       return nString;
     }

     String output = "";

     for (int index = length-1; index>=0; index -= 3) {
       if(index>2){
         output = "," + nString.substring(index-2, index+1) + output;
       }
       else{
         output = nString.substring(0,index+1) + output;
       }
     }
     return output;

   }

}
