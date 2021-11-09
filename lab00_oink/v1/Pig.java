/***
 * Team Won: Julia Kozak, Rin Fukuoka
 * APCS
 * L00 -- Etterbay Odingcay Oughthray Ollaborationcay
 * 2021-11-10
 * time spent: .5hrs
 *
 * DISCO: You can think about spaces as punctuation;
 *        toUpperCase and toLowerCase can be used;
 * QCC: How do we incorporate the Scanner functionality?
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


public class Pig {

  //static vars
  private static final String VOWELS = "aeiou";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String PUNCS = ".,:;!? 0123456789";

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

  public static boolean hasPunc( String w ) {
    for (int i = 0; i < w.length(); i++) {
      if (PUNCS.indexOf(w.substring(i, i+1)) != -1) {
        return true;
      }
    }
    return false;
  }

  public static boolean beginsWithUpper( String w ) {
    return isUpperCase(w.substring(0,1) );
   }

  //creates word
  public static String engToPig( String w ) {
    String ans = "";
    if (hasPunc(w)) {
      for (int i = 0; i < w.length(); i++) {
        if (isPunc(w.substring(i, i+1)) && i+1 < w.length() && i != 0) {
          return engToPig(w.substring(0, i)) + w.substring(i, i+1) + engToPig(w.substring(i+1));
        } else if (isPunc(w.substring(i, i+1)) && i+1 == w.length()){
          return engToPig(w.substring(0, i)) + w.substring(i, i+1);
        } else if (isPunc(w.substring(i, i+1)) && i == 0) {
	  return w.substring(0, 1) + engToPig(w.substring(1));
	}
      }
    }
    if ( beginsWithVowel(w.toLowerCase()) ) {
      ans = w + "way";
    } else {
      int vPos = w.indexOf( firstVowel(w) );
      ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
    }
    if (beginsWithUpper(w) && w.length() > 1) {
      String firstLetter = (ans.substring(0, 1)).toUpperCase();
      String restOfWord;
        restOfWord = (ans.substring(1)).toLowerCase();
      ans = firstLetter + restOfWord;
    }
    return ans;
  }

  public static void main( String[] args ) {
    System.out.println(engToPig("Wow"));
    System.out.println(engToPig("A12s"));
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
