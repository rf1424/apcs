// Rin Fukuoka, Julia Kozak, John Gupta-She
// APCS pd0
// HW52 -- implementing selection sort
// 2022-01-05w
// time spent:  0.5hrs

/******************************
 *   class SelectionSort -- implements SelectionSort algorithm
 *
 * ALGO:
 * 0. Take the minimum value and swap with the rightmost element.
 * 1. Take the next minimum value and swap with next rightmost element.
 * 2. Repeat step 1, n-1 times.
 * DISCO
 * - Typecast elements of array in order to compare them.
 *   (Or use compareTo method)
 * QCC
 * - Which is more efficient: SelectionSort or BubbleSort?
 *
 * q0: How many passes to sort n elements?
 * a0: It will take n-1 passes.
 * q1: What do you know after pass p?
 * a1: You know that the first p elements are correct.
 * q2: How do you know if sorted?
 * a2: n-1 elements are in place.
 * q3: What does a pass boil down to?
 * a3: comparing n-k elements where k is the pass.
 ******************************/


import java.util.ArrayList;

public class SelectionSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi )
  {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places smallest value at "rightmost" end

    //minPos will point to position of SELECTION (smallest value)
    int minPos;

    for(int i=0; i<data.size()-1; i++) {
      System.out.println( "\nbegin pass " + (i+1));//diag
      minPos = i;


      for(int j=i; j<data.size(); j++) {
        if ((int)data.get(j) < (int)data.get(minPos)) {
          minPos = j;
        }
        System.out.println( "minPos: " + minPos );//diag
        System.out.println( data );//diag
      }

      int temp = (int)data.get(i);
      data.set(i, data.get(minPos));
      data.set(minPos, temp);
      System.out.println( "after swap: " +  data );//diag
    }
  }//end selectionSort


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }//end selectionSort


  public static void main( String [] args )
  {


    /*ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    selectionSortV(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );*/

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      System.out.println();
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );

  }//end main

}//end class SelectionSort
