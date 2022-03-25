/*
 Team Fred (Andrey Sokolov + Geese, Rin Fukuoka + Tape, Kartik Vanjani + Krish)
 APCS PD8
 HW 81: It works!
 2022-03-22
 Spent: 0.5 hrs
*/

/*
 * DISCO
 * - Fairly straightforward tool to peruse
 * - This is just like a Scanner!
 * - Interesting how you can use an interface to do most things in methods
 *
 * QCC
 * - What other methods does the Iterator class have?
 * - How come you can initialize Iterator using LIST_INSTANCE.iterator()?
 * - What's the big difference between using Iterator and a FOREACH loop?
 *
 * FIRST:
 * The Iterator interface is defined as an abstract method of obtaining values from a list of said values one at a time.
 * As opposed to a more defined FOREACH loop, the Iterator can be used in cases when creating a loop would involve the
 * usage of a Scanner Object to make elements in a source into a list.
 *
 * SECOND:
 * The Iterator is a fancy loop. You can use it to get rid of elements easily.
 *
 */

/***
 * class ItrWork
 * Facilitates familiarization with iterators
 **/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    for(int i=0;i<L.size();i++){
      if(L.get(i) == key) return true;
    } return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    Iterator<Integer> it = L.iterator();
    while(it.hasNext()){
      if(it.next() == key) return true;
    } return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    List<Integer> odds = new ArrayList<Integer>();
    for(int i=0; i<L.size(); i++){
      if(L.get(i) % 2 == 1) odds.add(L.get(i));
    }
    return odds;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    Iterator<Integer> it = L.iterator();
    List<Integer> odds = new ArrayList<Integer>();
    while(it.hasNext()){
      int num = it.next();
      if(num % 2 == 1) odds.add(num);
    } return odds;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Iterator<Integer> it = L.iterator();
    while(it.hasNext()){
      if(it.next() % 2 == 0) it.remove();
    }
  }


  public static void main( String [] args )
  {

    //var type: List   obj type: ?
    List<Integer> L = new ArrayList<Integer>();

    for( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
    for( int i = 0; i < L.size(); i++){
      System.out.print(i);
      if(i < L.size() -1 ) System.out.print(", ");
    }

    System.out.print("\n \n");

    // b) explicitly using an iterator
    Iterator<Integer> it = L.iterator();
    while(it.hasNext()){
      System.out.print(it.next()+" ");
    }
    System.out.print("\n");

    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
