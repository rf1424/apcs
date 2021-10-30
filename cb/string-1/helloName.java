public class helloName {

// Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
  public static String helloName(String name) {
  String greeting = "Hello " + name + "!";
  return greeting;
}

//test cases
  public static void main(String [] args) {
    System.out.println( helloName("Bob"));
    System.out.println( helloName("Alice"));
    System.out.println( helloName("X"));
    System.out.println( helloName("Dolly"));
    System.out.println( helloName("Alpha"));
    System.out.println( helloName("Omega"));
    System.out.println( helloName("Goodbye"));
    System.out.println( helloName("ho ho ho"));
    System.out.println( helloName("xyz!"));
    System.out.println( helloName("Hello"));
  }
}
