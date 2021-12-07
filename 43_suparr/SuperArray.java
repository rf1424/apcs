/**
 Cute Cyclops Cult | Tasnim Chowdhury, Rin Fukuoka, Huebert and Tom, Faiza Huda, Mary, Tape
 APCS pd8
 HW43 -- encapsulation (basic SuperArray functionality)
 2021-12-07
 Time Spent: 1

 DISCO
 - A temporary array is needed to store the original array before expanding the original array.

 QCC
 - What is the point of returning the oldVal in set() method?

**/

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
 public SuperArray()
  {
   _data = new int[10];
   _size = _data.length;
  }



  //output SuperArray in [a,b,c] format
	public String toString()
  	{
    	String ans = "[";
    	for (int i = 0; i < _size; i++) {
        	if (i != _size - 1){
            	ans += _data[i] + ", ";
        	}
        	else {
            	ans += _data[i] + "]";
        	}
    	}
    	return ans;
  	}


  //double capacity of SuperArray
  private void expand()
  {
    /* YOUR IMPLEMENTATION HERE */
    //copy original array
    int[] temp = new int[_size];
    for (int i = 0; i < _size; i++){
      temp[i] = _data[i];
    }
    //create double capacity
    _data =  new int[_size * 2];
    for (int i = 0; i < _size; i++){
      _data[i] = temp[i];
    }
    _size = _data.length;
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
    int oldVal = _data[index];
    _data[index] = newVal;
    return oldVal;
  }


  //main method for testing
  public static void main( String[] args )
  {

      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
    	//curtis.expand();
      //System.out.println( curtis );


      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      }

  }//end main()


}//end class
