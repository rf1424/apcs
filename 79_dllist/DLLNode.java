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


public class DLLNode
{
  //instance vars
  private DLLNode prevcdr;
  private String cargo;
  private DLLNode cdr;

  // constructor
  public DLLNode( DLLNode prev, String value, DLLNode next )
  {
    this.prevcdr = prev;
    this.cargo = value;
    this.cdr = next;

  }

  public DLLNode( String value, DLLNode next){
    this.prevcdr = null;
    this.cargo = value;
    this.cdr = next;
  }

  public DLLNode(String cargo) {
    this.prevcdr = null;
    this.cargo = cargo;
    this.cdr = null;
  }


  //--------------v  ACCESSORS  v--------------
  public DLLNode getPrev(){
    return this.prevcdr;
  }

  public String getCargo()
  {
    return this.cargo;
  }

  public DLLNode getNext()
  {
    return this.cdr;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public DLLNode setPrev( DLLNode newPrev){
    DLLNode temp = this.prevcdr;
    this.prevcdr = newPrev;
    return temp;
  }

  public String setCargo( String newCargo )
  {
    String temp = this.cargo;
    this.cargo = newCargo;
    return temp;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode temp = this.cdr;
    this.cdr = newNext;
    return temp;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return cargo;

  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    DLLNode first = new DLLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", null ) );
    System.out.println(first.toString());

    //A naive list traversal, has side effects.... ??
    //   while( first != null ) {
    //   System.out.println( first );
    //   first = first.getNext();
    //   }


    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: the node it just left disappears. into the abyss.
    //...so better: ?
    DLLNode temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }

  }//end main

}//end class DLLNode
