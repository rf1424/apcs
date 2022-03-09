// Team Fred - Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish
// APCS pd8
// HW72 - So So Fast
// 2022-03-08
// time spent: 1 hrs

/**
* ALGO
* 1. Start with the last element of the array as the pivot position
* 2. Go through a list of elemnts from low, to high, the values depending on the previous partition results. The initial values for
* low/high are going to be 0/arr.length respectively
* 3. Once partitioned, if the pivot position is equal to the asked value, you return the element at the pivot position, as it is going to be
* guaranteed to be in its sorted position.
* 4. If not, you repeat the partition step until you reach a point where 3. is true, or you've sorted the array.
*
* DISCO
* - We found it interesting how the best complexity you can get with FastSelect is O(n*logn). We thought that the already sorted array would be easy to
* go through, but the algorithm still has to go through its divide-and-conquer step to be able to find the nth smallest element.
* - It is interesting to note how we know that the complexity of FastSelect is O(n*logn). Although the partition method is O(n), because we're using it in an
* algorithm which utilizes a divide-and-conquer technique, the O() must be amended to include a logarithm of n.
*
* QCC
* - We're not sure if our understanding of this algorithm's big O notation was correct. Would the already sorted array be the BEST CASE scenario, or would the
* inversely sorted array be the BEST CASE scenario?
* - What's the point of using FastSelect as opposed to MergeSort? At the end of the day, having one sorted position is not as good as having an entire array sorted.
*
*
* q0: What does it do?
* The FastSelect (MYSTERION) method takes in two parameters: the y-th smallest element you want to know, and the array from you which you want to get the element.
* Using partition, FastSelect is able to find the y-th smallest element without going through the entire array n*2 times!
*
* q1: What is its Big-Oh runtime?
* typical is O(n*logn)
* BEST CASE: the array is already sorted, so the typical runtime is O(n*logn)
*
* WORST CASE: the array is inversely sorted, so the typical runtime is O(n^2)
*
**/
import java.util.Arrays;

public class FastSelect{

 //----------------------------HELPERS----------------------------//
 //swap an array
 public static void swap(int[] arr, int c, int b){
     int temp = arr[c];
     arr[c] = arr[b];
     arr[b] = temp;
 }
 //shuffle an array (from closet's HW71)
 public static void shuffle( int[] d )
 {
   int tmp;
   int swapPos;
   for( int i = 0; i < d.length; i++ ) {
     tmp = d[i];
     swapPos = i + (int)( (d.length - i) * Math.random() );
     swap(d, i, swapPos);
   }
 }

  //return int array of size s, with each element fr range [0,maxVal) (from closet's HW71)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

  public static int partition(int[] arr, int low, int high, int pvtOriginal){
      int pvtPos = 0;
      int pvtVal = arr[pvtOriginal];
      swap(arr, pvtOriginal, high);
      pvtPos = low;
      for(int i=low; i<high;i++){
          if(arr[i]<pvtVal){
              swap(arr, pvtPos, i);
              pvtPos++;
          }
      }
      swap(arr, high, pvtPos);
      return pvtPos;
  }
 //----------------------------HELPERS END----------------------------//

 public static int FastSelect(int y, int[] arr){
  //Categorize the execution time of your algorithm using Big-Oh notation.
  int low, high, pvtOriginal;
  low = 0;
  high = arr.length-1;
  pvtOriginal = arr.length-1;
  for(int i = 0; i<arr.length; i++){
    //partition
    int position = partition(arr, low, high, pvtOriginal);
    //check if the position equals to y
    if(position==y) return arr[y];
    //check whether the position of the pivot is greater/less than y
    //if it is, change the values of high, low, and pvtOriginal
    if(position<y){
      low = pvtOriginal;
      high = arr.length;
      pvtOriginal++;
    }
    else if(position>y){
      low = 0;
      high = pvtOriginal;
      pvtOriginal--;
    }
  }
  return -1;
 }

 public static void main(String[] args){
    //init test arrays of magic numbers
    int[] arr1 = {8,21,17,69,343};
    int[] arr2 = {1,20,300,4000,50000};
    int[] arr3 = {20,16,13,10,6};
    // run FastSelect on each array,
    // holding a & b fixed, varying c...
    System.out.println("arr1: ");
    Arrays.toString(arr1);
    System.out.println("Select i-th smallest value of the array");
    for(int i=0;i<arr1.length;i++){
      System.out.println(FastSelect(i, arr1));
    }
    System.out.println("-----------------------");
    System.out.println("BEST CASE: ALREADY SORTED - arr2: ");
    Arrays.toString(arr2);
    System.out.println("Select i-th smallest value of the array");
    for(int i=0;i<arr1.length;i++){
      System.out.println(FastSelect(i, arr2));
    }
    System.out.println("-----------------------");
    System.out.println("BEST CASE: INVERSELY SORTED - arr3: ");
    Arrays.toString(arr3);
    System.out.println("Select i-th smallest value of the array");
    for(int i=0;i<arr1.length;i++){
      System.out.println(FastSelect(i, arr3));
    }
    System.out.println("-----------------------");
 }
}
