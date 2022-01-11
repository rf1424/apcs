import java.util.ArrayList;
public class MySorts {

/*
0. Starting from the end.
1. Compare the current element to the one before it (index - 1).
2. If the current is less than the previous, swap the two.
3. Now go down and turn index - 1 into your new current and do steps 2 and 3
   again until you make it to the element that is at the index (pass#).
4. Repeat steps 0-3 for every pass until pass# == to arraylist length - 1.
*/
  public static void bubbleSort( ArrayList<Comparable> data ) {
    for(int i = 0; i < data.size()-1; i++) {

    	for(int j = data.size() - 1; j > i; j--){
    		if((data.get(j)).compareTo(data.get(j-1)) < 0) {
          Comparable temp = data.get(j);
          data.set(j, data.get(j - 1));
          data.set(j-1, temp);
    		}
    	}
    }
  }


/*
0. Take the minimum value and swap with the rightmost element.
1. Take the next minimum value and swap with next rightmost element.
2. Repeat step 1, n-1 times.
*/
  public static void selectionSort( ArrayList<Comparable> data ) {
    int minPos;

    for(int i=0; i<data.size()-1; i++) {
      minPos = i;

      for(int j=i+1; j<data.size(); j++) {
        if ((data.get(j)).compareTo(data.get(minPos)) < 0) {
          minPos = j;
        }
      }
      Comparable temp = data.get(i);
      data.set(i, data.get(minPos));
      data.set(minPos, temp);
    }
  }


/*
0. Partition into sorted and unsorted regions. (First element in the array is already sorted)
1. "Walk" an element from unsorted region up to where it belongs in sorted region.
2. Increase size of sorted partition by 1.
3. Repeat 2,3 until sorted.
*/
  public static void insertionSort( ArrayList<Comparable> data ) {
    for( int i=1; i<data.size(); i++ ) {
      for( int j=i; j>0; j-- ) {
        if ((data.get(j)).compareTo(data.get(j-1)) < 0 ) {
          Comparable temp = data.get(j);
          data.set(j, data.get(j-1));
          data.set(j-1, temp);
        } else {
          break;
        }

      }
    }
  }

} //end of class
