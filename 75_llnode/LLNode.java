//Team Fred - Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish
//APCS pd8
//HW74 -- LLNode
//2022-03-11w
//time spent: 1h

// DISCO
// - This wasn't as hard as we though it was going to be!
// - Despite feeling like it wouldn't work, using LLNode for cdr works like a charm.

// QCC
// - How exactly should the toString() return the nodes?
// - Will we be able to rename this class at a later date?


public class LLNode
{
  //instance vars
  private String cargo;
  private LLNode cdr;

  // constructor
  public LLNode( String value, LLNode next )
  {
    this.cargo = value;
    this.cdr = next;

  }

  public LLNode(String cargo) {
    this.cargo = cargo;
    this.cdr = null;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return this.cargo;
  }

  public LLNode getNext()
  {
    return this.cdr;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String temp = this.cargo;
    this.cargo = newCargo;
    return temp;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode temp = this.cdr;
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
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );
    System.out.println(first.toString());

    //A naive list traversal, has side effects.... ??
       while( first != null ) {
       System.out.println( first );
       first = first.getNext();
       }


    //Q: when head ptr moves to next node in list, what happens to the node it just left?

    //...so better: ?
    //
    //
    //

  }//end main

}//end class LLNode
