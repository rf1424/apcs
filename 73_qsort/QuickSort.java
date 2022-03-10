//Team Fred - Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish
//APCS pd8
//HW72 -- QuickSort
//2022-03-09w
//time spent: 1h

// DISCO
// The bound in the loop should be high instead of d.length - 1. (IT TOOK US 5 MINUTES TO FIGURE THAT OUT)
// Duplicates have to be taken care of in partition code.

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Summary of QuickSort algorithm: The algorithm is set to partition the array according to a pivot position,
 * and the array will be ordered with the least elements at the left and the greater at the right.
 * Then we recursively call this method to then partition again based on a new pivot position and then the array will eventually be sorted from least to greatest.
 *
 * 2a. Worst pivot choice and associated run time:
 * Worst pivot choice and associated run time: O(n^2) because it would take two for loops to sort an array that needs one or more partition,
 * the worst pivot choice is random because you do not know if this value will allow the array to be sorted quickly enough and it will take more time.
 *
 * 2b. Best pivot choice and associated run time:
 * Best pivot choice and associated run time: O(n) and high because if it compares
 * it to its highest value and goes through the array once through, the array will
 * be sorted with only one for loop necessary.
 *
 * 3. Approach to handling duplicate values in array:
 * When you check if the element at index i is less than or equal to b,
 * you swap both lesser values and duplicates. If you swap both, the final pivot position be right.
 *
 **/
public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------




  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    qsortHelper(d, 0, d.length-1);
  }

  //you may need a helper method...
  public static int[] qsortHelper(int[] d, int low, int high){
    //base case: array is sorted
    //if(d.length == 1) return d;
    if (low<high) {
      //pivot is the upper bound value
      int pivot = Partition.partition(d, low, high, high);
      //smaller half
      qsortHelper(d, low, pivot-1);
      //larger half
      qsortHelper(d, pivot+1, high);
    }
    return d;
  }




  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);

    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
