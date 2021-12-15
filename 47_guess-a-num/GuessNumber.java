// Cute Cyclops Cult | Faiza Huda, DHBert, DTTom, Tasnim Chowdhury, Rin Fukuoka, Mary, Tape
// APCS pd8
// HW47 -- Guess Again
// 2021-12-15
// time spent: .5 hrs

/***
    DISCO:
    	- break; stops a loop while
      - return; ends the entire method
    QCC:
      - Which is more suitable for this algo: iterative or recursive?


 ***/
import java.util.Scanner;

public class GuessNumber
{

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );


  /*==================================================
    constructor -- initializes a guess-a-number game
    pre:
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
  public GuessNumber( int a, int b )
  {
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;

    //pick random number in range [a,b]

    /* YOUR CODE HERE */
    _target = _lo + (int)(Math.random()*(_hi - _lo + 1));
  }


  /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/
  public void playRec()
  {
    System.out.print("Guess a num btwn " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();

    //3 cases: we either found it, too hi, too lo

    if (guess == _target) {
      System.out.println("Correct! It took " + _guessCtr + " guesses.");

    } else if (guess < _target) {
      _lo = guess + 1;
      System.out.println("Too low, try again... ");
      _guessCtr++;
      playRec();

    } else if (guess > _target) {
      _hi = guess - 1;
      System.out.println(" Too high, try again... ");
      }
      _guessCtr++;
      playRec();
    }



  /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
  public void playIter()
  {

    int guess;

    while( true ) {
      System.out.print("Guess a num btwn " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();

      //3 cases: we either found it, too hi, too lo

      if (guess == _target){
        System.out.println("Correct! It took " + _guessCtr + " guesses.");
        break;
      }
      else if (guess < _target){
        _lo = guess + 1;
        System.out.println(" Too low, try again... ");
      } else {
        //guess > target
        _hi = guess - 1;
        System.out.println(" Too high, try again...");
      }
      _guessCtr++;
    }
  }


  //wrapper for playRec/playIter to simplify calling
  public void play()
  {
    //use one or the other below:
    //playRec();
    playIter();
  }


  //main method to run it all
  public static void main( String[] args )
  {

    //instantiate a new game
    GuessNumber g = new GuessNumber(1,100);

    //start the game
    g.play();

  }

}//end class GuessNumber
