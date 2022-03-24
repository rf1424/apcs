/*
 Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 APCS PD8
 HW 80: Find and Replace
 2022-03-22
 Spent: 0.5 hrs
*/

/*
 * DISCO
 * - Fairly straight task. Find and replace is a really good friend.
 * QCC
 * - What would happen if I were to hypothetically make T and actual class?
 *
 * ALGO ADD
 * - If the size of the list is 0, or index is 0, invoke the simpler add method
 * - Create a _new node with the value of newVal and a next of null
 * - create two references to the list (_temp1 and _temp2), and set the _new node between the two. Make sure to create a _prev for the new node
 * - increment the size of the List by 1
 *
 * ALGO REM
 * - If the input index is 0, simply take the next Node and the rest (cdr) by invoking getNext()
 * - Otherwise, if the index you need to remove is at the end, simply set the next of the previous DLLNode<T> equal to null
 * - If all above fails, go to the node you want to remove
 * - setNext() the node that comes before the removed node to the getNext() of the removed node
 * - setPrev() the node that comes after it to the getPrev() of the removed node
 * - At the end, reduce size by 1
*/

/***
 * class LList
 * Implements a linked list of DLLNode<T>s, each containing String data
 **/

public class LList<T> implements List<T> //interface def must be in this dir
{

  //instance vars
  private DLLNode<T> _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add(T newVal)
  {
    if(_size == 0){
      DLLNode<T> tmp = new DLLNode<T>( newVal, _head );
      _head = tmp;
      _size++;
      return true;
    }
    else{
      DLLNode<T> tmp = new DLLNode<T>( newVal, _head );
      DLLNode<T> lastHead = _head;
      _head = tmp;
      lastHead.setPrev(_head);
      _size++;
      return true;
    }
  }

  public void add( int index, T newVal ){
		DLLNode<T> _new = new DLLNode<T>( newVal, null );
    if(_size == 0 || index == 0) add( newVal );
    else{
      DLLNode<T> _position = _head;
      for(int i=0; i<index;i++){
        _position = _position.getNext();
      }
      _position.setNext(new DLLNode<T>(_position, newVal, _position.getNext()));
    	_size++;
    }
  }

  public T remove(int index){
    T original = this.get(index);
      if (index == 0) _head = _head.getNext(); //check if you only need to get rid of the first one
    	else if( index == _size-1) { //check if you need to get rid of the end
        DLLNode<T> _temp = _head;
        for(int i=0;i<index-1;i++){
          _temp = _temp.getNext();
        }
        _temp.setNext(null);
      }
    	else {
        DLLNode<T> _temp = _head;
        for(int i=0; i<index;i++){
          _temp = _temp.getNext();
        }
        _temp.getPrev().setNext(_temp.getNext());
        _temp.getNext().setPrev(_temp.getPrev());
      }
      _size--;
    	return original;
  }



  public T get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    T retVal;
    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public T set( int index, T newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode<T> tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    T oldVal = tmp.getCargo();

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
    DLLNode<T> tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo().toString() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList<String> james = new LList<String>();

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

     DLLNode<String> last = james._head;
     for(int i=0;i<james.size();i++){
       System.out.println( "element: " + last);
       System.out.println( "previous: " + last.getPrev() );
       System.out.println( );
       last = last.getNext();
     }


  }

}//end class LList
