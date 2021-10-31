public class countHi {
    public static void main(String[] args) {
        System.out.println(countHi("abc hi ho")); // 1
        System.out.println(countHi("ABChi hi")); // 2
        System.out.println(countHi("hihi")); // 2
    }

    /*
     * Return the number of times that the string "hi" appears anywhere in the
     * given string.
     */
    public static int countHi(String str) {
        int numberHi = 0;
        String test;
        for (int index = 0; index+1 < str.length(); index++) {
          test = str.substring(index, index+2);
          if (test.equals("hi")) {
            numberHi += 1;
          }
        }
        return numberHi;
    }
}
