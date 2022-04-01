/**
Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
APCS PD8
HW 86: Scheming Stacking
2022-03-31
Spent: 1 hrs


DISCO
- once you get the algo working it works surprisingly flawlessly
- the amount of keys spent is incredibly sad

QCC
- will this interpreter only work with basic operators
- is this EXACTLY how Scheme machines are able to interpret the operations written in Scheme?
**/

/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Parse the inputted Scheme expression into an Array of Strings called noSpace
 *   2. Create two Stacks to be used during parsing. Begin pushing strings from the array into numberStack
 *   3. Continue pushing into numberStack until you encounter ")"
 *   4. Once you encounter ")", keep pushing into tempStorage until you encounter "("
 *   5. Use the helper method unload to evaluate tempStorage and put the output into numberStack
 *   6. Once you parse through noSpace, pop numberStack
 *   7. ...
 *   7. PROFIT!
 *
 * STACK OF CHOICE: ALStack by library
 * b/c RNGesus
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    String[] noSpace = expr.split("\\s");
    Stack<String> numberStack = new ALStack<String>();
    Stack<String> tempStorage = new ALStack<String>();

    //parse through the input String
    for (int i=0; i<noSpace.length; i++) { // (+43)   ns:    ts: 34+
      //encounter closed paren
      if (noSpace[i].equals(")")) {
        //until you encounter open paren
        while (!numberStack.peekTop().equals("(")) {
          String num = numberStack.pop(); //3
          tempStorage.push(num);
        }
        //get rid of "("
        numberStack.pop();
        String unloaded = "";
        //check tempStorage for the type of operation
        if (tempStorage.peekTop().equals("+")) {
          unloaded = unload(1, tempStorage);
        }
        else if (tempStorage.peekTop().equals("-")) {
          unloaded = unload(2, tempStorage);
        }
        else if (tempStorage.peekTop().equals("*")) {
          unloaded = unload(3, tempStorage);
        }
        numberStack.push(unloaded);
      } else { //keep adding to stack
        numberStack.push(noSpace[i]);
      }
    }

    return numberStack.pop();
  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    numbers.pop();
    int returnI = Integer.parseInt(numbers.pop());
      //determine which operation
      if (op==1) {
        while (!numbers.isEmpty()) {
          returnI += Integer.parseInt(numbers.pop());
        }
      }
      else if (op==2) {
        while (!numbers.isEmpty()) {
          returnI -= Integer.parseInt(numbers.pop());
        }
      }
      else if (op==3) {
        while (!numbers.isEmpty()) {
          returnI *= Integer.parseInt(numbers.pop());
        }
      }
      return Integer.toString(returnI);
      //return -1;
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */


  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
