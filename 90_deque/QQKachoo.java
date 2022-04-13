import java.util.*;

public class QQKachoo<Cards> implements Deque<Cards> {
  private LinkedList<Cards> _arr;
//----------CONSTRUCTOR----------//
  public QQKachoo(){
    _arr = new LinkedList<Cards>();
  }
//-------------------------------//

//-----------ACCESSORS-----------//
  //returns true if this deque contains the specified element
  public boolean contains( Cards card ){
    return _arr.contains(card);
  }

  //returns the size of the deque
  public int size(){
    return _arr.size();
  }

  //toString()
  public String toString(){
    return _arr.toString();
  }
//-------------------------------//

//-----------MUTATORS-----------//
  //adds an element to the end of deque and returns true
  public boolean add( Cards card) {
    return _arr.add(card);
  }

  //adds an element to the beginning of deque
  public void addFirst( Cards card) {
    _arr.addFirst(card);
  }

  //adds an element to the end of deque
  public void addLast( Cards card) {
    _arr.addLast(card);
  }

  //removes the element from the head of deque and returns it
  public Cards remove(){
    return _arr.removeLast();
  }
  ////removes the first appeareance of the element from the deque and returns true
  public boolean remove( Cards card){
    return remove(card);
  }
  //retrieves and removes the first element of deque
  public Cards removeFirst() {
    return _arr.removeFirst();
  }
  //retrieves and removes the last element of deque
  public Cards removeLast() {
    return _arr.removeLast();
  }
//-------------------------------//

  public static void main(String[] args){
    //props to THEODORE YOCHUM for writing this lovely main like 3 weeks ago :D
    AddLast15();
    AddFirst15();

  }

  public static void AddLast15() {
    QQKachoo<Integer> test = new QQKachoo<Integer>();
    //Deque real = new ArrayDeque<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
//      real.addLast(i);
    }
//    System.out.println("Should print a deque of numbers 0 to 14 in linear order incrementing by 1");
    System.out.println(test);
//    System.out.println("Correct: " + (real.toString().equals(test.toString())));
//    System.out.println();
  }

  public static void AddFirst15() {
    QQKachoo<Integer> test = new QQKachoo<Integer>();
    //Deque real = new ArrayDeque<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addFirst(i);
//      real.addFirst(i);
    }
    System.out.println("Should print a deque of numbers 14 to 0 in reverse linear order deceremnting by 1");
    System.out.println(test);
//    System.out.println("Correct: " + (real.toString().equals(test.toString())));
//    System.out.println();
  }


}
