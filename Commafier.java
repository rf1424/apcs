public class Commafier {

  public static void main(String [] args) {

    System.out.println( commafyR(1));
    System.out.println( commafyR(10));
    System.out.println( commafyR(101));
    System.out.println( commafyR(1000));
    System.out.println( commafyR(12345));

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
}
