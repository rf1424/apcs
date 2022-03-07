// double johns; Ziying Jian, John Gupta-she, Rin Fukouka
// APCS pd8
// HW70 -- Thinkers of the Corn
// 2022-03-05
// time spent: .6 hrs

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 *
 * USAGE:
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 *
 * ALGORITHM for finding exit from starting position:
 * The algorithm first checks if the hero is on one of the sides. If so, the method is exited.
 * Otherwise, if the current hero is at the exit, the maze is solved. Otherwise, if the hero
 * cannot find a path, then exit the method. Otherwise, check the top, bottom, left, and right
 * for a possible path. Turn all paths into visited paths.
 *
 * DISCO
 * return exits the method
 * [2J clears the screen
 * protection needs to be changed depending on if they're used between classes
 * a legend can be super helpful! and can really help simplify things
 *
 * QCC
 * How exactly does System.out.print(this) work?
 *
 *
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  public int h, w; // height, width of maze
  private boolean _solved;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
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
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y )
  {
    delay( FRAME_DELAY ); //slow it down enough to be followable

    if (x == -1 || y == -1 || x == w || y == h) {
      return;
    }
    //primary base case
    if ( _maze[x][y] == EXIT) {
       System.out.println( this ); //refresh screen
	     _solved = true;
       System.exit(0);
    }
    //other base cases
    else if (_maze[x][y] != PATH) {
      System.out.println( this ); //refresh screen
      return;
    }
    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else {
      _maze[x][y] = HERO;
      int[] xOffset = {0, 1, 0, -1};
      int[] yOffset = {1, 0, -1, 0};
      for (int i = 0; i < 4; i++) {
        solve(x + xOffset[i], y + yOffset[i]);
      }
      System.out.println( this ); //refresh screen
      _maze[x][y] = VISITED_PATH;
      System.out.println( this ); //refresh screen
    }
  }

//   //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) {
    return _maze[x][y] == PATH;
  }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "[2J" );

    //display maze
    System.out.println( ms );

    //drop hero into the maze (coords must be on path)
    // ThinkerTODO: comment next line out when ready to randomize startpos
    //ms.solve( 3, 2 );

    //drop our hero into maze at random location on path
    // YOUR RANDOM-POSITION-GENERATOR CODE HERE
    int startX = (int)(Math.random()*ms.w);
    int startY = (int)(Math.random()*ms.h);
    while (!(ms.onPath(startX, startY))) {
      startX = (int)(Math.random()*ms.w);
      startY = (int)(Math.random()*ms.h);
    }
    ms.solve( startX, startY ) ;
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class Maze// double johns; Ziying Jian, John Gupta-she, Rin Fukouka
// APCS pd8
// HW70 -- Thinkers of the Corn
// 2022-03-05
// time spent: .6 hrs

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 *
 * USAGE:
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 *
 * ALGORITHM for finding exit from starting position:
 * The algorithm first checks if the hero is on one of the sides. If so, the method is exited.
 * Otherwise, if the current hero is at the exit, the maze is solved. Otherwise, if the hero
 * cannot find a path, then exit the method. Otherwise, check the top, bottom, left, and right
 * for a possible path. Turn all paths into visited paths.
 *
 * DISCO
 * return exits the method
 * [2J clears the screen
 * protection needs to be changed depending on if they're used between classes
 * a legend can be super helpful! and can really help simplify things
 *
 * QCC
 * How exactly does System.out.print(this) work?
 *
 *
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  public int h, w; // height, width of maze
  private boolean _solved;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
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
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y )
  {
    delay( FRAME_DELAY ); //slow it down enough to be followable

    if (x == -1 || y == -1 || x == w || y == h) {
      return;
    }
    //primary base case
    if ( _maze[x][y] == EXIT) {
       System.out.println( this ); //refresh screen
	     _solved = true;
       System.exit(0);
    }
    //other base cases
    else if (_maze[x][y] != PATH) {
      System.out.println( this ); //refresh screen
      return;
    }
    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else {
      _maze[x][y] = HERO;
      int[] xOffset = {0, 1, 0, -1};
      int[] yOffset = {1, 0, -1, 0};
      for (int i = 0; i < 4; i++) {
        solve(x + xOffset[i], y + yOffset[i]);
      }
      System.out.println( this ); //refresh screen
      _maze[x][y] = VISITED_PATH;
      System.out.println( this ); //refresh screen
    }
  }

//   //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) {
    return _maze[x][y] == PATH;
  }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "[2J" );

    //display maze
    System.out.println( ms );

    //drop hero into the maze (coords must be on path)
    // ThinkerTODO: comment next line out when ready to randomize startpos
    //ms.solve( 3, 2 );

    //drop our hero into maze at random location on path
    // YOUR RANDOM-POSITION-GENERATOR CODE HERE
    int startX = (int)(Math.random()*ms.w);
    int startY = (int)(Math.random()*ms.h);
    while (!(ms.onPath(startX, startY))) {
      startX = (int)(Math.random()*ms.w);
      startY = (int)(Math.random()*ms.h);
    }
    ms.solve( startX, startY ) ;
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class Maze
