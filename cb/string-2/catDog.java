public class catDog {
    public static void main(String[] args) {
        System.out.println(catDog("catdog")); // true
        System.out.println(catDog("catcat")); // false
        System.out.println(catDog("1cat1cadodog")); // true
    }

    /*
     * Return true if the string "cat" and "dog" appear the same number of times
     * in the given string.
     */
    public static boolean catDog(String str) {
      int numberCat = 0;
      int numberDog = 0;

      //count cat
      for (int index = 0; index+2 < str.length(); index++) {
        String testCat = (str.substring(index, index+3));
        if (testCat.equals("cat")) {numberCat++;}
      }

      //count dog
      for(int index = 0; index+2 < str.length(); index++) {
        String testDog = (str.substring(index, index+3));
        if (testDog.equals("dog")) {numberDog++;}
      }

      //equal?
      return (numberCat == numberDog);

    }
}
