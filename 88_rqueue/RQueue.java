
/**
 * Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 * APCS PD8
 * HW 87: BPC Kiddies Do Not Wait in Line Either
 * 2022-04-04
 * Spent: 0.5 hrs
 *
 * DISCO
 * - dequeue() is really similar to remove() from llist!
 * - sampling works like a charm!
 *
 * QCC
 * - is there a more optimized way to create a dequeue() method?
 * - was using a nextElement int the best way to track a random front?
 *
 *
 **/

/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/

 import java.util.NoSuchElementException;


public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;
  private int nextElement;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = null;
    _size = 0;
    nextElement = 0;
  }

  public RQueue(SWASHBUCKLE cargo)
  {
    this();
    enqueue(cargo);
  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    //empty
    if (isEmpty()) _front = _end = new LLNode<SWASHBUCKLE>(enQVal, null);
    else {
      _end.setNext(new LLNode<SWASHBUCKLE>(enQVal, null));
      _end = _end.getNext();
    }
    _size++;
    this.sample();
  }//O(1)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {
    if (isEmpty()) throw new NoSuchElementException();
    SWASHBUCKLE original = this.peekFront(); //save the element you remove
    if (nextElement == 0) _front = _front.getNext(); //check if you only need to get rid of the first one
    else if (nextElement == _size-1) { //check if you need to get rid of the end
      LLNode<SWASHBUCKLE> _temp = _front;
      for (int i=0; i<nextElement-1; i++) {
        _temp = _temp.getNext();
      }
      _temp.setNext(null);
    }
    else { //nextElement is somewhere in the middle
      LLNode<SWASHBUCKLE> _temp = _front;
      for (int i=0; i<nextElement-1; i++) {
        _temp = _temp.getNext();
      }
      _temp.setNext(_temp.getNext().getNext());
    }
    _size--;
    this.sample();
    return original;

  }//O(n) //O(1) if first element


  public SWASHBUCKLE peekFront()
  {
    if (isEmpty()) return null;
    LLNode<SWASHBUCKLE> _temp = _front;
    for (int i = 0; i<nextElement; i++) {
      _temp = _temp.getNext();
    }
    return _temp.getCargo();
  }//O(n)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   * 1. set nextElement equal to a random number in between 0 (inclusive) and size (exclusive)
   **/
  public void sample ()
  {
    nextElement = (int)(Math.random()*_size);
  }//O(1)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String retStr = "FRONT->";
            LLNode<SWASHBUCKLE> tmp = _front; //init tr
            for( int i=0; i <_size; i++) {
                retStr += tmp.getCargo().toString();
                if(i==nextElement){
                    retStr+="(NEXT)";
                }
                retStr += "->";
                tmp = tmp.getNext();
            }
    retStr += "NULL";
    return retStr;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {



    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n");
    System.out.println( PirateQueue.dequeue() );
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
