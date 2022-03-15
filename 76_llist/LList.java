/*
 Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 APCS PD8
 HW 76 We Got A Little Ol Convoy
 2022-03-14
*/
/***
 * DISCO:
 * Communication is key,
 * The CAR value is the value sotred in the list cell.
 * QCC:
 * How are lists different from array lists?
 * What constitutes a list not returning null?
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
    _head = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    if (_head == null) {
      _head = new LLNode(newVal, null);
    } else {
      LLNode temp = _head;
      while (temp.getNext() != null) {
      temp = temp.getNext();
      }
      temp.setNext( new LLNode(newVal, null));

    }
    _size += 1;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    int counter = 0;
    LLNode temp = _head;
    while (counter < index) {
      temp = temp.getNext();
      counter += 1;
    }
    return temp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    int counter = 0;
    LLNode temp = _head;
    while (counter < index) {
      temp = temp.getNext();
      counter += 1;
    }
    String temp2 = temp.getCargo();
    temp.setCargo(newVal);
    return temp2;
  }


  //return number of nodes in list
  public int size()
  {
    // int ctr = 0;
    //   for (int index = 0; index < size(); index++){
    //     return;
    //   }
    // ctr++;
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    	//return "james.get(0) + james.get(1) + james.get(2)";

    String result = "";
    LLNode temp = _head;
    while (temp != null) {
      result += temp.getCargo();
      result += " ";
      temp = temp.getNext();
    }
    return result;
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
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
