// Team FRED - Andrey Sokolov + Geese & Rin Fukuoka + Tape, Kartik Vanjani + Krish
// APCS pd8
// HW90/91 - KAchoo Deque
// 2022-04-12/13
// time spent: 0.5 hours

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

  //retrieves, but does not remove, the head of the queue
  public Cards peek() {
    return _arr.peek();
  }

  //retrieves, but does not remove, the first element of the deque
  public Cards peekFirst() {
    return _arr.peekFirst();
  }
  //retrieves, but does not remove, the end element of this deque
  public Cards peekLast() {
    return _arr.peekLast();
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
  //removes the first appeareance of the element from the deque and returns true
  public boolean removeFirstOccurrence(Cards card) {
    return _arr.removeFirstOccurrence(card);
  }
  //removes the last appeareance of the element from the deque and returns true
  public boolean removeLastOccurrence(Cards card) {
    return _arr.removeLastOccurrence(card);
  }
  //retrieves, and remove, the tail of the queue
  public Cards pop(){
    return _arr.pop();
  }
//-------------------------------//

}
