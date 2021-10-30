public class makeAbba {

 //Given two strings, a and b, return the result of putting them together in the order abba.
  public static String makeAbba(String a, String b) {
  return a + b + b + a;
  }

  public static void main(String [] args) {
    System.out.println( makeAbba("Hi", "Bye"));
    System.out.println( makeAbba("Yo", "Alice"));
    System.out.println( makeAbba("What", "Up"));
    System.out.println( makeAbba("aaa", "bbb"));
    System.out.println( makeAbba("x", "y"));
    System.out.println( makeAbba("x", ""));
    System.out.println( makeAbba("", "y"));
    System.out.println( makeAbba("Bo", "Ya"));
    System.out.println( makeAbba("Ya", "Ya"));
  }
}
