//Team Fred - Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish
//APCS pd8
// Code from HW 71 - Whut Dis
// 2022-03-07
// time spent: 0.5 hrs

/***
 *  DISCO:
 *
 *  - Its interesting that if you use the wrong values for a, b, and c the algorithm is not going to work.
 *  - Fred seemed pretty excited today! Didn't see a lot of George, though.
 *
 *  QCC:
 *
 *  - Is the point of the Mysterion to be an extremely fast sorter?
 *  - At what point does using this algorithm becomes useless?
 *
 *  q0: What does it do?
 *
 *  The Mysterion is an algorithm which takes in an array, and then sorts the array based on whether the values in the array are greater than
 *  arr[c], or lower than arr[c].
 *
 *  q1: What is its Big-Oh runtime?
 *
 *  The Big O notation of the Mysterion Algorithm is O(n).
 *
***/

/***
 * class Parition (née Mysterion)
 *
 * <h1>MYSTERION is PARTITION</h1>
 * The Mysterion method ... <YOUR TRIO'S DESCRIPTION HERE>
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Trey Parker, Matt Stone
 * @version 3.1415926535897932384626433
 * @since   2022-03-08t
 *
 * algo as pseudocode:
 * ------------------------------
 *     v = arr[c]
 *     swap arr[c], arr[b]
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s]
 **/


public class Partition
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
   * int partition(int[],int,int,int)
   * Utilizing a single loop, the partition method is able to quickly sort a list of elements to be less than or greater than the element at pvtPos.
   * It also sorts the element at pvtPos to be now located in its proper, sorted position.
   *
   * @param arr input array of ints.
   * @param loPos the low bound of the array partitioned  .
   * @param hiPos the upper bound of the array partitioned.
   * @param pvtPos the position of the array all the other positions are compared to.
   * @return int position of the sorted value which used to be at pvtPos.
   *
   */
  public static int partition( int arr[], int loPos, int hiPos, int pvtPos)
  {
    int v = arr[pvtPos];

    swap( pvtPos, hiPos, arr);
    int s = loPos;

    for( int i = loPos; i < hiPos; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,hiPos,arr);

    return s;
  }//end partition


  //main method for testing
  public static void main( String[] args )
  {

    //init test arrays of magic numbers
    int[] arr1 = {8,21,17,69,343};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};


    // run partition on each array,
    // holding loPos & hiPos fixed, varying pvtPos...
    for( int testPIVOT = 0; testPIVOT < 5; testPIVOT++ ) {
      System.out.println("arr1: ");
      printArr(arr1);
      partition(arr1,0,4,testPIVOT);
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
                         + testPIVOT +"...");
      printArr(arr1);
      System.out.println("-----------------------");

      System.out.println("arr3:");
      printArr(arr3);
      partition(arr3,0,4,testPIVOT);
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
                         + testPIVOT +"...");
      printArr(arr3);
      System.out.println("-----------------------");

      System.out.println("arr4:");
      printArr(arr4);
      partition(arr4,0,4,testPIVOT);
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
                         + testPIVOT +"...");
      printArr(arr4);
      System.out.println("-----------------------");

      System.out.println("arr5:");
      printArr(arr5);
      partition(arr5,0,4,testPIVOT);
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
                         + testPIVOT +"...");
      printArr(arr5);
      System.out.println("-----------------------");
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }
  }//end main

}//end class Partition
