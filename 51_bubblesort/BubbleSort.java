// Cute Cyclops Cult | Tasnim Chowdhury, Rin Fukuoka, Huebert and Tom, Faiza Huda, Mary, Tape
// APCS Pd. 8
// HW51 -- implementing bubblesort
// 2022-01-04
// time spent: 0.6 hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 * 0. Starting from the end
 * 1. Compare the current element to the one before it (index - 1)
 * 2. If the current is less than the previous, swap the two
 * 3. Now go down and turn index - 1 into your new current and do steps 2 and 3 again until you make it to the element that is at the index (pass#)
 * 4. Repeat steps 0-3 for every pass until pass# == to arraylist length - 1
 *
 * DISCO:
 * - Forgot everything bro
 * - when traversing thru arraylist, you only need to do pass number of passes, since the ones after are alr sorted
 *
 * QCC
 * q0: If a pass requires no swaps, what do you know?
 * a0: The array is sorted.
 * q1: After pass p, what do you know?
 * a1: All values decreasing from index  p-1 (inclusive) are sorted.
 * q2: How many passes are necessary to completely sort?
 * a2: For an array of length n it needs n -1 passes.
 *
 ******************************/


import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
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
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    // does length-1 passes bc that is when everything is for sure sorted
    for (int j = 0; j < data.size()-1; j++){
    	// traversing thru array from last element to 0 index
    	for (int i = data.size()-1; i > j; i--){
		Comparable mainObj = data.get(i);
		Comparable adjacentObj = data.get(i-1);
	      	if (mainObj.compareTo(adjacentObj) < 0) {
		        // swap
			data.set(i, adjacentObj);
			data.set(i-1, mainObj);
      		}
        }
    }
  }

  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
   	ArrayList<Comparable> output = new ArrayList<Comparable>();
	// adding all of input's elements into output
	for (int i = 0; i < input.size(); i++){
		output.add(input.get(i));
	}
	//sort the copy
  	bubbleSortV(output);

	return output;
  }

  public static void main( String [] args )
  {

    //===============for VOID methods=============
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
     // ===========================================
     /*
    //==========for AL-returning methods==========
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
    //============================================
    */
  }//end main

}//end class BubbleSort
