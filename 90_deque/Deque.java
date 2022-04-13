public interface Deque<Cards> {
  //adds an element to the end of deque and returns true
  public boolean add( Cards card);
  //adds an element to the beginning of deque
  public void addFirst( Cards card);
  //adds an element to the end of deque
  public void addLast( Cards card);
  //removes the element from the head of deque and returns it
  public Cards remove();
  ////removes the first appeareance of the element from the deque and returns true
  public boolean remove( Cards card);
  //retrieves and removes the first element of deque
  public Cards removeFirst();
  //retrieves and removes the last element of deque
  public Cards removeLast();
  //returns true if this deque contains the specified element
  public boolean contains( Cards card );
  //returns the size of the deque
  public int size();
}//end of class
