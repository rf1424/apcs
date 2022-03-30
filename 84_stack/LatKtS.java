/***
Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
APCS PD8
HW 84: Stack: What Is It Good For?
2022-03-29
Spent: 0.5 hrs
 **/

/**
QCC:
- What if the string has one letter? Do we create a base case where if the size is just 1, return the letter.
- Would time complexity change if we were to reverse it in any other way?
- Is this the most efficient way to reverse strings?

DISCO:
- Size of the string does not matter.
- Popping at the end is important.
- Popping automatically makes a node null. No need to override anything.
 **/

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes original = new Latkes(s);
    String output = "";
    while(!original.isEmpty()){
        output+=original.pop();
    }
    return output;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    Latkes original = new Latkes(s); //({}[()])
    Latkes closer = new Latkes(s.length()); //)])([}{(
    while(!original.isEmpty()){
        if(!closer.isEmpty() && match(closer.peek(), original.peek())){
            closer.pop();
            original.pop();
        }
        else {
            closer.push(original.pop());
        }
    }
    return original.isEmpty() && closer.isEmpty();
  }

  public static boolean match(String a, String b){
      if(a.equals(")") && b.equals("(")) return true;
      else if(a.equals("}") && b.equals("{")) return true;
      else if(a.equals("]") && b.equals("[")) return true;
      else return false;
  }


  //main method to test
  public static void main( String[] args )
  {
    Latkes test = new Latkes("tesd");
    while(!test.isEmpty()){
        System.out.println(test.pop());
    }
    System.out.println(flip("stressed"));
    System.out.println(flip("({}[()])"));

    System.out.println(allMatched( "({}[()])" )); //true

    System.out.println(allMatched( "([)]" ) ); //false

    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false

    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
