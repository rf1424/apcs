/*
Cute Cyclops Cult | Tasnim Chowdhury, Rin Fukuoka, Huebert and Tom, Faiza Huda, Mary, Tape
APCS
HW34 -- A Pirate's Life for Me
2021-11-15
time spent: 2hrs
QCC
- Is there an alternate way to write linSearchR?
DISCO
- Need to use helper function to use counter in lineSearchR because recursion recalls itself so counter would have just resetted
  (if it was local) or counter would not have resetted when recalling the method again in main (if it was instance)
*/

import java.lang.Math;

public class Loopier{


  //populate an existing array
  public static void populate( int[] array){
  	int nElements = array.length;
      for (int i = 0; i < nElements; i++){
        array[i] = (int)(Math.random()*100);
      	}
  }

  //return a String version of an array of ints
  public static String printArray( int[] array) {
    String ans = "";
    for (int element : array) {
    	ans += element + " ";
    }
    return ans;
  }

  //iterative linear search
  public static int linSearch( int[] a, int target) {
    for (int i=0; i < a.length; i++) {
    	if (target == a[i]) {
      	return i;
      }
    }
    return -1;
  }

  //iterative frequency function
  public static int freq( int[] a, int target ) {
  	int ans = 0;
    for (int i=0; i<a.length; i++) {
    	if ( target == a[i]) {
      	ans += 1;
      }
    }
     return ans;
  }


  // This is the main linSearchR
	public static int linSearchR( int[] a, int target ){
  	return linSearchRHelper(a, target, 0);
	}

  // Helper function that actually does all the recursion
  public static int linSearchRHelper( int[] a, int target, int counter ){
   	 if (a.length == 0) {
      return -1;
    } else if (a[0] == target) {
      return counter;
    }
      return linSearchRHelper(lesserArray(a), target, counter + 1);
  }

  //recursive frequency function
  public static int freqRec( int[] a, int target ) {
    if (a.length == 0) {
    	return 0;
    }
    if (a[0] == target) {
      return 1 + freqRec(lesserArray(a), target);
    }
    return freqRec(lesserArray(a), target);
  }


  public static int[] lesserArray(int[] a) {
  	int[] lesserA = new int[a.length - 1];
      for (int i = 0; i < lesserA.length; i++){
        lesserA[i] = a[i + 1];
      }
    return lesserA;
  }

	public static void main(String[] args) {
  	int[] example = new int[8];
    int[] example2 = { 312, 0, 5, 43, 7, 8, 3};
    int[] example3 = { 312, 0, 69, 43, 7, 8, 3};
    int[] example4 = { 19, 0, 10, 19, 19, 8, 3};
    populate( example);
    System.out.println(printArray( example));

    System.out.println(linSearch( example2, 5)); // 2
    System.out.println(linSearch( example3, 5)); // -1

    System.out.println(linSearchR( example2, 5)); // 2
    System.out.println(linSearchR( example3, 5)); // -1

    System.out.println( freq( example2, 5)); //1
    System.out.println( freq( example4, 19)); //3

    System.out.println( freqRec( example2, 5)); //1
    System.out.println( freqRec( example4, 19)); //3


  }



} //end of class
