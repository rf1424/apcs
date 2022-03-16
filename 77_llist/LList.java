/*
 Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 APCS PD8
 HW 77
 2022-03-14
 Spent:
 Quantity of KtS
*/

/*
 * DISCO
 * - The add and remove methods actually have a lot of differences in their implementations.
 * - Returning size is a good thing we noticed because we established that as an instance variable, and the time complexity is O(1) instead of O(n)
 * QCC
 * - Would we traverse if there was no size instance variable?
 * - Should a size instance variable always be initialized for a class with Lists or Arrays?
 *
 * ALGO ADD
 * - If the size of the list is 0, invoke the simpler add method
 * - Create a _new node with the value of newVal and a next of null
 * - If you are trying to add to index 0, simply set _new as the _head of the list and set the rest of the values after _new
 * - Otherwise, create two references to the list (_temp1 and _temp2), and set the _new node between the two.
 * - increment the size of the List by 1
 *
 * ALGO REM
 * - If the input index is 0, simply take the next Node and the rest (cdr) by invoking getNext()
 * - Otherwise, if the index you need to remove is at the end, simply set the next of the previous LLNode equal to null
 * - If all above fails, find the Nodes inbetween the one you want to remove, and set the latter one to be the next of the former
 * - At the end, reduce size by 1
*/

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
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
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }

  public void add( int index, String newVal ){
		LLNode _new = new LLNode( newVal, null );
    if(_size == 0) add( newVal );
    else if(index == 0){
      _new.setNext(_head);
      _head = _new;
      _size++;
    }
    else{
      LLNode _temp = _head; // the latter half of LList the connected to _new
    	for(int i=0; i<index; i++){
      	_temp = _temp.getNext();
    	}
      _new.setNext(_temp); // the previous half of LList the connected to _new
      LLNode _temp2 = _head;
      for(int i=0; i<index-1;i++){
        _temp2 = _temp2.getNext();
      }
    	_temp2.setNext(_new);
    	_size++;
    }
  }

  public String remove(int index){
    String original = this.get(index);
        if (index == 0) _head = _head.getNext(); //check if you only need to get rid of the first one
    	else if( index == _size-1) { //check if you need to get rid of the end
        LLNode _temp = _head;
        for(int i=0;i<index-1;i++){
          _temp = _temp.getNext();
        }
        _temp.setNext(null);
      }
    	else {
        LLNode _temp = _head;
        LLNode _temp2 = _head;
        for(int i=0; i<index-1;i++){
          _temp = _temp.getNext();
        }
        //System.out.println(_temp);
        for(int i=0; i<index+1;i++){
          _temp2 = _temp2.getNext();
        }
        //System.out.println(_temp2);

        _temp.setNext(_temp2);
      }
      _size--;
    	return original;
  }



  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

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

    LLNode tmp = _head; //create alias to head

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
    LLNode tmp = _head; //init tr
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

//     james.add( 3, "hello" );
//     System.out.println( james );

//     james.remove(0);
//     System.out.println( james );

//     james.remove(4);
//     System.out.println( james );

//     james.remove(2);
//     System.out.println( james );


  }

}//end class LList
