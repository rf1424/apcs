// Team Rin-Sensei: Julia Kozak(Flopsy), Rin Fukuoka(Tape), John Gupta-She(Po)
// APCS pd08
// HW55: Never Fear, Big Oh Is Here!
// 2022-01-11t
// time spent: 0.5 hrs

/*
 * DISCO:
 * -In most methods, the best case is O(1).
 * QCC:
 * -Can there be best/worse cases for toString and size?
*/

import java.util.ArrayList;

public class OrderedArrayList {

  private ArrayList<Integer> _data;

  //Constructor OrderedArrayList
  //the creation of _data independent of any variables, so it is O(1)
  public OrderedArrayList() {
    _data = new ArrayList<>();
    for(int i=0; i<23; i++) {
	     _data.add(i);
     }
  }

  //toString method
  //there is no best/worst case
  //the execution time is always linear, depending on the size variable of _data, so it is O(n)
  public String toString() {
    String ans = "{ ";
    for (int i=0; i<_data.size(); i++) {
  	   ans += _data.get(i) + ", ";
     }
     ans = ans.substring(0, ans.length()-2);
     ans += " }";
     return ans;
  }

  //remove
  //the best case is when the item being removed is last in the ArrayList, in which case it is O(1)
  //the worst case is when the item is first, in which case it is O(n) (depending on size of the ArrayList)
  public Integer remove( int i ) {
    int temp = _data.get(i);
    _data.remove(i);
    return temp;
  }

  //returns size, an instance variable, which is O(1)
  //no best/worst case, as it takes the same amount of time to retrieve one value
  public int size() {
    return _data.size();
  }

  //returns term at index i, which is O(1)
  //no best/worst case, as it takes the same amount of time to retrieve one value
  public Integer get( int i ) {
    return _data.get(i);
  }

  //add value using Linear search
  //best case: value belongs at the first position, in which case it is O(1) as it takes one comparison
  //worst case: value belongs at the last position, which is O(n) as it will be compared with all prior values
  public void addLinear(Integer newVal) {
    if (_data.size() < 1) {
	     _data.add(newVal);
     } else {
       for (int i=0; i<_data.size()-1; i++) {
  	      if(_data.get(i) > newVal) {
  		      _data.add(i, newVal);
  		      break;
  	      }
        }
          if (_data.get(_data.size()-1) < newVal) {
  	        _data.add(newVal);
          }
      }
  }

  //add value using Binary search
  //best case: value belongs in the middle, which is O(1) as it takes one comparison
  //worst case: value belongs at one of the ends, which is O(log_2(n)) since each step is cutting possibilities in half
  public void addBinary(Integer newVal) {
  int min = 0;
  int max = _data.size() - 1;
    while (min <= max) {
      int middle = min + (max - min) / 2;
      if (_data.get(middle) == newVal) {
        _data.add(middle, newVal);
      }
      if (_data.get(middle) < newVal)  {
        min = middle + 1;
      } else {
        max = middle - 1;
      }
    }
  }

  public static void main( String[] args ) {


    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.addLinear( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    // testing binary search
    Franz = new OrderedArrayList();
    for( int i = 0; i < 15; i++ )
      Franz.addBinary( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

  }//end main()

}//end class OrderedArrayLists
