/*
Cute Cyclops Cult | Tasnim Chowdhury, Rin Fukuoka, Huebert and Tom, Faiza Huda, Mary, Tape
APCS
HW40 -- 2D arrays
2021-11-30
time spent: .5
QCC
- What other way can you print out arrays?
- Is it possible to create a 3D array, 4D, array, and so on?
DISCO
- If you try printing an array without making it a string, it will return a memory code.
- A 2D array with 0 rows and columns, when printed, will not display anything.
*/

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
    for (int i = 0; i < a.length; i++) {
      for (int j=0; j < a[i].length; j++ ) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
    for (int[] set : a) {
      for (int element : set) {
      System.out.print(element + " ");
    }
    System.out.println();
    }
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    int ans = 0;
    for (int[] set : a) {
      for (int element : set) {
        ans += element;
      }
    }
    return ans;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
    // YOUR IMPLEMENTATION HERE
    int ans = 0;
    for (int i=0; i < m.length; i++) {
      ans += sumRow(i, m);
    }
    return ans;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    int ans = 0;
    for (int i =0; i < a[r].length; i++) {
      ans += a[r][i];
    }
    return ans;
  }

  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    // *** YOUR IMPLEMENTATION HERE ***
    int summer = 0;
      for (int element : m[r]) {
        summer += element;
      }
    return summer;
  }


  public static void main( String [] args )
  {

      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };
      int [][] m4 = new int[0][0];
      print1(m1);
      print1(m2);
      print1(m3);
      print1(m4);
      print2(m1);
      print2(m2);
      print2(m3);
      print2(m4);
      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1));
      System.out.println("sum m2 : " + sum1(m2));
      System.out.println("sum m3 : " + sum1(m3));
      System.out.println("sum m4 : " + sum1(m4));
      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));
      System.out.println("sum m4 : " + sum2(m4));

    // your own custom test cases welcomed and encouraged
  }

}//end class TwoDimArray
