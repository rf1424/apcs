//Team stingRAY (Rin Furuoka, Abdullah Faruque, Yuki Feng)
//APCS pd8
//HW68: ...and T-, Tr-, Tri-, Tries Again Until It's Done
//2022-03-01
//time spent: 1 hrs

/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO
 * Given a n*n square board, start by placing a knight on (1, 1).
 * Continue placing a chain of knights and keeping track of the number of moves.
 * When the number of moves equals the number of squares, stop. You found a working knight’s tour.
 * Else when the current knight does not have any move, stop.
 * Remove the current knight and try the alternate configurations.
 *
 * If after trying all the configurations starting with a knight on (1,1),
 * there is no working knight’s tour, restart by placing a knight on a different square.
 * After you restart from all possible starting squares to place the knight,
 * and there is no working knight’s tour, then there is no solution. 
 *
 * DISCO - n = 7 and 8 took too long to run.
 *
 * QCC- when we ran the time code, my results are shown as below. Which time are we supposed to use to make judgements?
 *
 * Mean execution times for boards of size n*n:
 * n=5   __s    across 5 executions
 * real    0m0.933s
 * user    0m0.015s
 * sys     0m0.031s
 * n=6   __s    across 1 executions
 * real    33m43.345s
 * user    0m0.000s
 * sys     0m0.031s
 * n=7   __s    across __ executions
 * n=8   __s    across __ executions
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 *
 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 8;

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    TourFinder tf = new TourFinder( n );

    //clear screen using ANSI control code
    System.out.println( "[2J" );

    //display board
    System.out.println( tf );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:
    //tf.findTour( 2, 2, 1 );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
    int startX = (int)(Math.random() * (n+2));//YOUR MATH CONSTRUCT FOR GENERATING A RANDOM LEGAL X VALUE
    int startY = (int)(Math.random() * (n+2));//YOUR MATH CONSTRUCT FOR GENERATING A RANDOM LEGAL X VALUE
    //tf.findTour( startX, startY, 1 );   // 1 or 0 ?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
    for (int i = 2; i < n+2; i++) {
      for (int j = 2; j<n+2; j++) {
        tf.findTour(i, j, 1);
      }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;

    //init 2D array to represent square board with moat
    _board = new int[n+4][n+4];

    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------
    for (int i = 0; i < _sideLength+4; i++) {
      for (int j = 0; j < _sideLength+4; j++) {
        _board[i][j] = -1;
      }
    }
    for (int i = 2; i < _sideLength+2; i++) {
      for (int j = 2; j < _sideLength+2; j++){
        _board[i][j] = 0;
      }
    }
    //---------------------------------------------------------

  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < _sideLength+4; i++ ) {
      for( j=0; j < _sideLength+4; j++ )
        retStr = retStr + String.format( "%3d", _board[j][i] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    //delay(50); //slow it down enough to be followable

    //if a tour has been completed, stop animation
    if ( _solved ) { System.exit(0);}

    //primary base case: tour completed
    if ( moves == _sideLength*_sideLength +1) {
      _solved = true;
      System.out.println( this ); //refresh screen
      return;
    }
    //other base case: stepped off board or onto visited cell
    if ( _board[x][y] != 0 ) {
      return;
    }
    //otherwise, mark current location
    //and recursively generate tour possibilities from current pos
    else {

      //mark current cell with current move number
      _board[x][y] = moves;

      System.out.println( this ); //refresh screen

      //delay(1000); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/
      findTour(x-1, y+2, moves+1); //e
      findTour(x+1, y+2, moves+1); //d
      findTour(x+2, y+1, moves+1); //c
      findTour(x+2, y-1, moves+1); //b
      findTour(x+1, y-2, moves+1); //a
      findTour(x-1, y-2, moves+1); //h
      findTour(x-2, y-1, moves+1); //g
      findTour(x-2, y+1, moves+1); //f


      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)
        _board[x][y] = 0;

      System.out.println( this ); //refresh screen
    }
  }//end findTour()

}//end class TourFinder
