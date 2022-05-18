//Rin-Sensei: Julia Kozak, John Gupta-She, Rin Fukuoka
//APCS pd08
//HW102 -- Heap On Heapin' On
//2022-05-18
//time spent: 0.5 hrs

/*
DISCO:
- You can maintain a balanced tree by adding/removing each element
  to/from the end of your ArrayList.
- If everything is balanced, you don't need null placeholders in the
  ArrayList.

QCC:
- Where should minOf have been used?

*/

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList<>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    String ret = "";
    int pow = 1;
    for (int i=0; i<_heap.size(); i++) {
      if (i + 1 == (int)Math.pow(2, pow)) {
        ret += "\n";
        pow++;
      }
      ret += _heap.get(i) + " ";
    }
    ret += "\n";
    return ret;
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.size() <= 0;
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * 1. Add element to the end, left-justified, by adding it to the ArrayList.
   * 2. While the added element has a parent and its parent is greater than it,
   *    swap it up with its parent.
   */
  public void add( Integer addVal )
  {
    int pos = _heap.size();
    _heap.add(addVal);
    while ((pos-1)/2 >= 0 && _heap.get((pos-1)/2) > _heap.get(pos)) {
      swap(pos, (pos-1)/2);
      pos = (pos-1)/2;
    }
  }//O(logn)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * 1. swap the minimum (root) with the element that was last added, and
   *    remove the last element (to be returned).
   * 2. for the current position of the last value (starts at root), check if
   *    either of its two children are less than it, and if so, swap it with
   *    the smallest child.
   */
  public Integer removeMin()
  {
    if (_heap.size() == 1) return _heap.remove(0);
    else {
      int pos = 0;
      swap(0, _heap.size()-1);
      Integer ret = _heap.remove(_heap.size()-1);
      while((2*pos+1 < _heap.size() && _heap.get(pos).compareTo(_heap.get(2*pos+1)) > 0)
          ||(2*pos+2 < _heap.size() && _heap.get(pos).compareTo(_heap.get(2*pos+2)) > 0)) {
        int swapPos = minChildPos(pos);
        swap(pos, swapPos);
        pos = swapPos;
      }

      return ret;
    }
  }//O(logn)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    if (2*pos+1 > _heap.size()) return -1;
    else if (2*pos+2 > _heap.size()) return 2*pos+1;
    else {
      if (_heap.get(2*pos+1).compareTo(_heap.get(2*pos+2)) < 0) {
        return 2*pos+1;
      } else {
        return 2*pos+2;
      }
    }
  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
    ///*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
