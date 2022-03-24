//Team Fred - Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish
//APCS pd8
//HW78 -- DLLNode (using the file from homework 74);
//2022-03-16w
//time spent: 1h

// DISCO
// - This wasn't as hard as we though it was going to be!
// - Despite feeling like it wouldn't work, using LLNode for cdr works like a charm.

// QCC
// - How exactly should the toString() return the nodes?
// - Will we be able to rename this class at a later date?


public class DLLNode<T>
{
  //instance vars
  private DLLNode<T> prevcdr;
  private T cargo;
  private DLLNode<T> cdr;

  // constructor
  public DLLNode( DLLNode<T> prev, T value, DLLNode<T> next )
  {
    this.prevcdr = prev;
    this.cargo = value;
    this.cdr = next;

  }

  public DLLNode( T value, DLLNode<T> next){
    this.prevcdr = null;
    this.cargo = value;
    this.cdr = next;
  }

  public DLLNode(T cargo) {
    this.prevcdr = null;
    this.cargo = cargo;
    this.cdr = null;
  }


  //--------------v  ACCESSORS  v--------------
  public DLLNode<T> getPrev(){
    return this.prevcdr;
  }

  public T getCargo()
  {
    return this.cargo;
  }

  public DLLNode<T> getNext()
  {
    return this.cdr;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public DLLNode<T> setPrev( DLLNode<T> newPrev){
    DLLNode<T> temp = this.prevcdr;
    this.prevcdr = newPrev;
    return temp;
  }

  public T setCargo( T newCargo )
  {
    T temp = this.cargo;
    this.cargo = newCargo;
    return temp;
  }

  public DLLNode<T> setNext( DLLNode<T> newNext )
  {
    DLLNode<T> temp = this.cdr;
    this.cdr = newNext;
    return temp;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return cargo.toString();

  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    DLLNode<String> first = new DLLNode<String>( "cat", null );

    //Create a new node after the first
    first.setNext( new DLLNode<String>( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode<String>( "cow", null ) );
    System.out.println(first.toString());

    //A naive list traversal, has side effects.... ??
    //   while( first != null ) {
    //   System.out.println( first );
    //   first = first.getNext();
    //   }


    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: the node it just left disappears. into the abyss.
    //...so better: ?
    DLLNode<String> temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }

    DLLNode<Integer> integer = new DLLNode<Integer>( 5, null );
    System.out.println(integer);

  }//end main

}//end class DLLNode
