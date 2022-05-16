import java.util.*;

public class ArrayPriorityQueue implements PriorityQueue {

  private ArrayList<int[]> _queue;


  // constructor
  public ArrayPriorityQueue() {
    _queue = new ArrayList<>();
  }

  // add: O(1)
  public void add( int obj, int priority ) {
    int[] ret = new int[2];
    ret[0] = obj;
    ret[1] = priority;
    _queue.add(ret);
  }

  // isEmpty: O(1)
  public boolean isEmpty() {
    return _queue.size() <= 0;
  }

  // peekMin: O(n)
  public int peekMin() {
    int min = _queue.get(0)[1];
    int minIndex = 0;
    for (int i=1; i<_queue.size(); i++) {
      if (_queue.get(i)[1] < min) {
        min = _queue.get(i)[1];
        minIndex = i;
      }
    }
    return _queue.get(minIndex)[0];
  }


  // removeMin: O(n)
  public int removeMin() {
    int min = _queue.get(0)[1];
    int minIndex = 0;
    for (int i=1; i<_queue.size(); i++) {
      if (_queue.get(i)[1] < min) {
        min = _queue.get(i)[1];
        minIndex = i;
      }
    }
    int ret = _queue.get(minIndex)[0];
    _queue.remove(minIndex);
    return ret;
  }

  public static void main(String[] args) {
    ArrayPriorityQueue a = new ArrayPriorityQueue();
    a.add(7, 1);
    a.add(36, 2);
    a.add(1, 5);
    a.add(55, 4);
    System.out.println(a.peekMin());
    System.out.println(a.removeMin());
    System.out.println(a.peekMin());
    System.out.println(a.isEmpty());
    System.out.println(a.removeMin());
    System.out.println(a.removeMin());
    System.out.println(a.removeMin());
    System.out.println(a.isEmpty());
  }
}
