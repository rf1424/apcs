//Team stingRAY (Rin Furuoka, Abdullah Faruque, Yuki Feng)
//APCS pd8
// HW71 -- Reading for intent, tracing for VICTORY
//2022-03-07
//time spent: 0.5 hrs


/***
 * SKEELTON for
 * class Mysterion
 * tests preliminary hypotheses re: utility of mystery algo
 *
 * <h1>It's a Bird, It's a Plane! It's.... MYSTERION</h1>
 * The Mysterion method
 * value a, b, and c are the first, last, and "middle" value respectively, but c can be anything.
 * the method iterates through the array. if an element is less than the value at c, then it is sent to the beginning
 * of the array, where it would in a position behind c.
 * result: elements behind position c are less than the element at c. elements infront of position c are more than element at c.
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Trey Parker, Matt Stone
 * @version 3.1415926535897932384626433
 * @since   2022-03-07m
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
 *
 * DISCO
 * value a, b, and c are the first, last, and "middle" value respectively, but c can be anything.
 * the method iterates through the array. if an element is less than the value at c, then it is sent to the beginning
 * of the array, where it would in a position behind c.
 * result: elements behind position c are less than the element at c. elements infront of position c are more than element at c.
 *
 * QCC - n/a
 *
 * q0: What does it do?
 * a0:divides the array into two sections, the first section being less than the element at position c, the second
 * position being greater than the element at position c.
 *
 * q1: O(?)
 * a1: O(n) since the iterates through the the array and makes swaps when applicable.
 *
 ***/


public class Mysterion
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
   * int mysterion(int[],int,int,int)
   * DESCRIP
   *
   * @param arr
   * @param a
   * @param b
   * @param c
   * @return int
   *
   */
  public static int mysterion( int arr[], int a, int b, int c)
  {
	int v = arr[c];
    swap(c, b, arr);
    int s = a;
    for(int i = a; i < b; i++){
        if (arr[i] < v){
            swap(s, i, arr);
            s++;
        }
    }
    swap(b, s, arr);
    return 1;
  }//end mysterion


  //main method for testing
  public static void main( String[] args )
  {


    //init test arrays of magic numbers
    int[] arr1 = {8,21,17,69,343};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};


    // run mysterion on each array,
    // holding a & b fixed, varying c...
    for( int testC = 0; testC < 5; testC++ ) {
    System.out.println("arr1: ");
    printArr(arr1);
    mysterion(arr1,0,4,testC);
    System.out.println("after mysterion w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr1);
    System.out.println("-----------------------");

    System.out.println("arr3:");
    printArr(arr3);
    mysterion(arr3,0,4,testC);
    System.out.println("after mysterion w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr3);
    System.out.println("-----------------------");

    System.out.println("arr4:");
    printArr(arr4);
    mysterion(arr4,0,4,testC);
    System.out.println("after mysterion w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr4);
    System.out.println("-----------------------");

    System.out.println("arr5:");
    printArr(arr5);
    mysterion(arr5,0,4,testC);
    System.out.println("after mysterion w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr5);
    System.out.println("-----------------------");

  }//end main

}
}//end class Mysterion
