/**
   Duck Duck Goose: Gloria Lee (Flounder), Jonathan Song (Phoenix), Rin Fukuoka (Tape)
   APCS
   HW25 -- Loops and Recursions
   2021-10-26

   QCC:
   How should recursion be represented in a flow chart?

   DISCO:
   We tried to add a return statement in the if else statement, but that was incorrect because
   it caused the entire method to stop running immediately after the return statement.

**/

public class Repeater {

  public static void main(String[] args){
    System.out.println("While Loop: ");
    System.out.println(fenceW(1));
    System.out.println(fenceW(3));
    System.out.println(fenceW(5));
    System.out.println("Recursion: ");
    System.out.println(fenceR(2));
    System.out.println(fenceR(4));
    System.out.println(fenceR(6));
  }

//while loop
  public static String fenceW(int numPosts){
    int counter = 1;
    String output = "|";

    while( numPosts > counter ){
      counter+=1;
      output = output + "--|";
    }
    return output;
  }

//recursion
  public static String fenceR(int numPosts) {
    String output;
    if (numPosts == 1) {
      output = "|";
    }
    else {
      output = fenceR(numPosts - 1) + "--|";
    }
    return output;
  }

}//end of class
