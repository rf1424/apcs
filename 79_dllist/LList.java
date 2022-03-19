/*
 Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 APCS PD8
 HW 78: Double Up
 2022-03-16
 Spent: 0.5 hrs
*/

/*
 * DISCO
 * - It takes a lot less time to amend algorithms as opposed to write them
 * - Presenting today made our code a lot cleaner and optimized!
 * QCC
 * - Would we traverse if there was no size instance variable?
 * - Should a size instance variable always be initialized for a class with Lists or Arrays?
 *
 * ALGO ADD
 * - If the size of the list is 0, or index is 0, invoke the simpler add method
 * - Create a _new node with the value of newVal and a next of null
 * - create two references to the list (_temp1 and _temp2), and set the _new node between the two. Make sure to create a _prev for the new node
 * - increment the size of the List by 1
 *
 * ALGO REM
 * - If the input index is 0, simply take the next Node and the rest (cdr) by invoking getNext()
 * - Otherwise, if the index you need to remove is at the end, simply set the next of the previous DLLNode equal to null
 * - If all above fails, go to the node you want to remove
 * - setNext() the node that comes before the removed node to the getNext() of the removed node
 * - setPrev() the node that comes after it to the getPrev() of the removed node
 * - At the end, reduce size by 1
*/

/***
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private DLLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    if(_size == 0){
      DLLNode tmp = new DLLNode( newVal, _head );
      _head = tmp;
      _size++;
      return true;
    }
    else{
      DLLNode tmp = new DLLNode( newVal, _head );
      DLLNode lastHead = _head;
      _head = tmp;
      lastHead.setPrev(_head);
      _size++;
      return true;
    }
  }

  public void add( int index, String newVal ){
		DLLNode _new = new DLLNode( newVal, null );
    if(_size == 0 || index == 0) add( newVal );
    else{
      DLLNode _position = _head;
      for(int i=0; i<index;i++){
        _position = _position.getNext();
      }
      _position.setNext(new DLLNode(_position, newVal, _position.getNext()));
    	_size++;
    }
  }

  public String remove(int index){
    String original = this.get(index);
      if (index == 0) _head = _head.getNext(); //check if you only need to get rid of the first one
    	else if( index == _size-1) { //check if you need to get rid of the end
        DLLNode _temp = _head;
        for(int i=0;i<index-1;i++){
          _temp = _temp.getNext();
        }
        _temp.setNext(null);
      }
    	else {
        DLLNode _temp = _head;
        for(int i=0; i<index;i++){
          _temp = _temp.getNext();
        }
        _temp.getPrev().setNext(_temp.getNext());
        _temp.getNext().setPrev(_temp.getPrev());
      }
      _size--;
    	return original;
  }



  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }

  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );

    james.add( 0, "hi" );
    System.out.println( james );

     james.add( 4, "hello" );
     System.out.println( james );

     james.remove(0);
    System.out.println( james );

     james.remove(4);
     System.out.println( james );

     james.remove(2);
     System.out.println( james );

     DLLNode last = james._head;
     for(int i=0;i<james.size();i++){
       System.out.println( "element: " + last);
       System.out.println( "previous: " + last.getPrev() );
       System.out.println( );
       last = last.getNext();
     }


  }

}//end class LList
