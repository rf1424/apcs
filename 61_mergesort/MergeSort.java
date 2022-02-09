/***
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:

  ***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    //create output array
    int size = a.length + b.length;
    int[] output = new int[size];
    //index
    int indexa = 0;
    int indexb = 0;
    int indexo = 0;

    while (indexa < a.length && indexb < b.length)
   {
     if (a[indexa] > b[indexb]) {
       output[indexo] = b[indexb];
       indexb += 1;
     } else { //equal or b is greater
       output[indexo] = a[indexa];
       indexa += 1;
     }
     indexo += 1;
   }

   if (indexa == a.length){
     for (int i = indexb; i < b.length; i++) {
       output[i+indexa] = b[i];
     }
   } else {
     for (int i = indexa; i < a.length; i++) {
       output[i+indexb] = a[i];
     }
   }

   return output;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
      //base case
    if (arr.length == 1) {
      return arr;
    }
    //recursive case
    int middle = arr.length / 2;
    int[] firstHalf = new int[middle];
    int[] secondHalf = new int[arr.length - middle];

    for (int i = 0; i < middle; i++) {
      firstHalf[i] = arr[i];
    }
    for (int i = 0; i < arr.length - middle; i++)
      secondHalf[i] = arr[i+middle];

    return (merge(sort(firstHalf), sort(secondHalf)));
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  //main method for testing
  public static void main( String [] args )
  {

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );


      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
      /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
