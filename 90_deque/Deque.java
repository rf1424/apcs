// Team FRED - Andrey Sokolov + Geese & Rin Fukuoka + Tape, Kartik Vanjani + Krish
// APCS pd8
// HW90/91 - KAchoo Deque
// 2022-04-12/13
// time spent: 0.5 hours

public interface Deque<Cards> {
  //adds an element to the end of deque and returns true
  public boolean add( Cards card);
  //adds an element to the beginning of deque
  public void addFirst( Cards card);
  //adds an element to the end of deque
  public void addLast( Cards card);
  //removes the element from the head of deque and returns it
  public Cards remove();
  //removes the first appeareance of the element from the deque and returns true
  public boolean remove( Cards card);
  //retrieves and removes the first element of deque
  public Cards removeFirst();
  //retrieves and removes the last element of deque
  public Cards removeLast();
  //returns true if this deque contains the specified element
  public boolean contains( Cards card );
  //returns the size of the deque
  public int size();
  //retrieves, but does not remove, the head of the queue
  public Cards peek();
  //retrieves, but does not remove, the head of the queue
  public Cards peekFirst();
  //retrieves, but does not remove, the tail of the queue
  public Cards peekLast();
  //retrieves, and remove, the tail of the queue
  public Cards pop();
  //removes the first appeareance of the element from the deque and returns true
  public boolean removeFirstOccurrence( Cards card );
  //removes the last appeareance of the element from the deque and returns true
  public boolean removeLastOccurrence( Cards card );
/*
*/
}//end of class
