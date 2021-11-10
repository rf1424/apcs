/***
 * Team Won: Julia Kozak, Rin Fukuoka
 * APCS
 * L00 -- Etterbay Odingcay Oughthray Ollaborationcay
 * 2021-11-10
 * time spent: .5hrs
 *
 * class Pig
 * a Pig Latin translator
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 ***/
 
/*
 DISCO: Numbers and spaces can be treated as punctuation
          Scanner can accept inputs from a text file with "<"
   QCC: is there a more efficient or simplified way to deal with punctuation?
   HOW WE UTILIZED SCANNER DEMO (v2): we imported the Scanner class as the demo did, created a Scanner object, then ran a while loop similar to the one in the demo but rather than printing each word, the loop would print each translated word
   WHAT CAUSES THE RUNTIME ERROR IN THE SCANNER DEMO: for each run through the while loop, two next lines would be printed. This caused an error by the end, there was only one remaining line but main was instructed to print two.
   NEW IN v2: Fixes a bug related to punctuation (v1 would produce runtime errors if more than one punc was at the end of the String)
              Considers if the first letter is y, and now translates correctly
              Includes scanner
*/
import java.util.Scanner;

public class Pig {

  //static vars
  private static final String VOWELS = "aeiouy";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String PUNCS = ".,:;!? 1234567890";
  //note numbers are treated like punctuation (things before/after numbers form different Strings)

  //checks for specific letter
  public static boolean hasA( String w, String letter ) {
    return w.indexOf(letter) != -1;
  }//end hasA()

  //checks if specific letter is a vowel
  public static boolean isAVowel( String letter ) {
    return VOWELS.indexOf( letter ) != -1;
  }

  //how many vowels in word
  public static int countVowels( String w ) {
    return allVowels(w).length();
  }

  //checks if word has any vowel
  public static boolean hasAVowel( String w ) {
    return countVowels(w) > 0;
  }

  //returns all vowels of a word in a String
  public static String allVowels( String w ) {
    String ans = ""; //init return String
    for( int i = 0; i < w.length(); i++ ) {
      if ( isAVowel( w.substring(i,i+1) ) )
        ans += w.substring( i, i+1 ); //grow the return String
    }
    return ans;
  }

  //finds first vowel in String of allVowels
  public static String firstVowel( String w ) {
    String ans = "";
    if ( hasAVowel(w) )
      ans = allVowels(w).substring(0,1);
    return ans;
  }

  //for case of first vowel and letter being y
  public static String secondVowel( String w ) {
    String ans = "";
    if ( (allVowels(w)).length() > 1 ) {
      ans = allVowels(w).substring(1, 2);
    }
    return ans;
  }

  //checks if first letter is vowel
  public static boolean beginsWithVowel( String w ) {
    return isAVowel( w.substring(0,1) );
  }

  //checks if character is punctuation or space
  public static boolean isPunc( String symbol ) {
    return PUNCS.indexOf( symbol ) != -1;
  }

  //checks if a specific letter is caps
  public static boolean isUpperCase( String letter ) {
    return CAPS.indexOf(letter) != -1;
  }

  //checks for puncs/space/numbers
  public static boolean hasPunc( String w ) {
    for (int i = 0; i < w.length(); i++) {
      if (PUNCS.indexOf(w.substring(i, i+1)) != -1) {
        return true;
      }
    }
    return false;
  }

  //checks if first letter is uppercase
  public static boolean beginsWithUpper( String w ) {
    return isUpperCase(w.substring(0,1) );
   }

   //checks if first letter is Y (special case)
   public static boolean firstLetY( String w ) {
    return (w.substring(0, 1)).toLowerCase() == "y";
   }

  //creates word
  public static String engToPig( String w ) {
    String ans = "";
    //checks for punc, then separates Strings before/after punc
    if (hasPunc(w) && w.length() > 1) {
      for (int i = 0; i < w.length(); i++) {
        if (isPunc(w.substring(i, i+1)) && i+1 < w.length() && i != 0) {
          return engToPig(w.substring(0, i)) + w.substring(i, i+1) + engToPig(w.substring(i+1));
        } else if (isPunc(w.substring(i, i+1)) && i+1 == w.length()){
          return engToPig(w.substring(0, i)) + w.substring(i, i+1);
        } else if (isPunc(w.substring(i, i+1)) && i == 0) {
          return w.substring(0, 1) + engToPig(w.substring(1));
        }
      }
    } else if (hasPunc(w) && w.length() == 1) {
      return w;
    }

    //begins with y
    if (firstLetY(w)) {
      int vPos = w.indexOf( secondVowel(w) );
      ans = w.substring(vPos) + w.substring(0, vPos) + "ay";
    }
    //begins with vowel(but not y)
    else if ( beginsWithVowel(w.toLowerCase()) && !(firstLetY(w))) {
      ans = w + "way";
    }
    //doesn't begin with vowel or y(consonnant)
    else {
      int vPos = w.indexOf( firstVowel(w) );
      ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
    }



    //first letter uppercase
    if (beginsWithUpper(w) && w.length() > 1) {
      String firstLetter = (ans.substring(0, 1)).toUpperCase();
      String restOfWord;
        restOfWord = (ans.substring(1)).toLowerCase();
      ans = firstLetter + restOfWord;
    }
    return ans;
  }

  public static void main( String[] args ) {
    System.out.println(engToPig("testing testing 123"));
    System.out.println(engToPig("Yonder1"));

    Scanner sc = new Scanner( System.in );
    while (sc.hasNext()) {
    	System.out.println(engToPig(sc.next()));
    }
    /*
    for( String word : args ) {
      System.out.println( "allVowels \t" + allVowels(word) );
      System.out.println( "firstVowels \t" + firstVowel(word) );
      System.out.println( "countVowels \t" + countVowels(word) );
      System.out.println( "engToPig \t" + engToPig(word) );
      System.out.println( "---------------------" );
    }
    */
  }//end main()

}//end class Pig
