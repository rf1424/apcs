public class doubleChar {

//Given a string, return a string where for every char in the original, there are two chars.
 public static String doubleChar(String str) {
   String output = "";
   int length = str.length();
   for (int counter = 0; length > counter; counter++) {
     output += str.substring(counter, counter+1)
             + str.substring(counter, counter+1);
   }
  return output;
}

 //test cases
  public static void main(String [] args) {
    System.out.println( doubleChar("The"));
    System.out.println( doubleChar("AAbb"));
    System.out.println( doubleChar("Hi-There"));
    System.out.println( doubleChar("Word!"));
    System.out.println( doubleChar("!!"));
    System.out.println( doubleChar(""));
    System.out.println( doubleChar("."));
    System.out.println( doubleChar("aa"));
  }

}
