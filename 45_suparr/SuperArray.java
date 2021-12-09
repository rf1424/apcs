// Cute Cyclops Cult | Tasnim Chowdhury, Rin Fukuoka, Huebert and Tom, Faiza Huda, Mary, Tape
// APCS pd8
// HW44 -- expanding SuperArray functionality, encapsulation
// 2021-12-07
// Time Spent: 0.7
/*
  QCC
- Why doesn't add(index, newVal) not work for add(int newVal)
- Piazza post
- How do we fix _size when index is greater than size?
*/
/***************************
 * class SuperArray version 2.0
 * (SKELETON)
 * Wrapper class for array. Facilitates
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

public class SuperArray implements ListInt
{

  private int[] _data;  //underlying ("encapsulated") container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    if (_size < index){
      _size = index + 1;
    }
    int temp = _data[index];
    _data[index] = newVal;
    return temp;
  }


  //adds an item after the last item
  public void add( int newVal )
  {
    //add( _size, newVal);
    _data[_size] = newVal;
    _size++;
  }


  //inserts an item at index
  public void add( int index, int newVal )
  {
    /* YOUR IMPLEMENTATION HERE */
    if (_data.length - 1< index) {
      //expand();
      System.out.println("out of range");
    }
    else {_size += 1;}
    for (int i = _size - 1; i >= index; i--) {
      _data[i] = _data[i-1];
    }
    _data[index] = newVal;

  }

  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index )
  {
    /* YOUR IMPLEMENTATION HERE */
    if (index < _size) {
      for (int i = index; i < _size - 1; i++){
        _data[i] = _data[i+1];
      }
    _size -= 1;
    _data[_size - 1] = 0;
    }
    else {
    	System.out.println("index out of range");
    }
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {

      SuperArray mayfield = new SuperArray();
      System.out.println("Printing empty SuperArray mayfield...");
      System.out.println(mayfield);

      mayfield.add(5);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);

      System.out.println("Printing populated SuperArray mayfield...");
      System.out.println(mayfield);

      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);

      mayfield.add(3,99);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);

      //Testing out the only interface method that's not preexisting in SuperArray...or maybe it does and I am just blind
      System.out.println(mayfield.size());
  }//end main


}//end class
