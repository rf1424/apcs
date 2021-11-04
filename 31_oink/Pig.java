/***
Duck Duck Goose: Gloria Lee (Flounder), Jonathan Song (Phoenix), Rin Fukuoka (Tape)
APCS
HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
2021-11-3
time spent: 1 hr

DISC:
-The HW name is "Not By The Hair Of My Chinnee Chin Chin.
-A lot of the methods that we created in the beginning of the code
    could be used later on in later methods.
QCC:
-Why do you need to return the invocation of hasA inside the method isVowel? Does it not automatically return?
-Is there a way to create nested comments?
-How do you utilize these methods to make a Pig Lation translator?
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
  //Q: How does this initialization make your life easier?
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter )
  {
    /* YOUR IMPLEMENTATION HERE */
    if(letter.length()!=1){
      System.out.println("Letter must have length 1.");
      return false;
    }
    if(w.length()<1){
      System.out.println("String w length cannot be less than 1.");
      return false;
    }
    if (-1 != w.indexOf(letter)) {
      return true;
    }
    else {
      return false;
    }
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter )
  {
    /* YOUR IMPLEMENTATION HERE */
    if (letter.length() != 1) {
      System.out.println("Letter must have length 1.");
      return false;
    }
    return hasA(VOWELS, letter);

  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w )
  {
    if(w.length()<1){
      System.out.println("String w length cannot be less than 1.");
      return -1;
    }
    int counter = 0;
    for (int index = 0; index < w.length(); index++) {
      String letter = w.substring(index, index+1);
      if ( isAVowel(letter)) {
        counter++;
      }
    }
    return counter;

  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) {
    if(w.length()<1){
      System.out.println("String w length cannot be less than 1.");
      return false;
    }
    for (int index = 0; index < w.length(); index++) {
      String letter = w.substring(index, index+1);
      if ( isAVowel(letter)) {
       return true;
      }
    }
    return false;

  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w )
  {
    if(w.length()<1){
      System.out.println("String w length cannot be less than 1.");
      return "";
    }
    String output = "";
  	for (int index = 0; index < w.length(); index++) {
    	String letter = w.substring(index, index+1);
      if ( isAVowel(letter)) {
      output += letter;
      }
    }
    return output;
  }


  public static void main( String[] args )
  {
    System.out.println(hasA("203247", "7")); //expecting true
    System.out.println(hasA("apple", "p")); //expecting true
    System.out.println(hasA("tester", "p")); //expecting false
    System.out.println(hasA("tester", "te")); //expecting false
    System.out.println("==========================");
    System.out.println(isAVowel("b")); //false
    System.out.println(isAVowel("i")); //true
    System.out.println(isAVowel("")); //false
    System.out.println("==========================");
    System.out.println(countVowels("dance")); //expecting 2
    System.out.println(countVowels("apple-pie")); //expecting 4
    System.out.println(countVowels("rhythm")); //expecting 0
    System.out.println("==========================");
    System.out.println(hasAVowel("dance")); //expecting true
    System.out.println(hasAVowel("apple-pie")); //expecting true
    System.out.println(hasAVowel("rhythm")); //expecting false
    System.out.println("==========================");
    System.out.println(allVowels("dance")); //expecting "ae"
    System.out.println(allVowels("apple-pie")); //expecting "aeie"
    System.out.println(allVowels("rhythm")); //expecting ""



  }//end main()


}//end class Pig
