public class countCode {
    public static void main(String[] args) {
        System.out.println(countCode("aaacodebbb")); // 1
        System.out.println(countCode("codexxcode")); // 2
        System.out.println(countCode("cozexxcope")); // 2
    }

    /*
     * Return the number of times that the string "code" appears anywhere in the
     * given string, except we'll accept any letter for the 'd', so "cope" and
     * "cooe" count.
     */
    public static int countCode(String str) {
      int codeNumber = 0;
      String testCo;
      String testE;
      for (int index = 0; index + 3 < str.length(); index++) {
        testCo = str.substring(index, index+2);
        testE = str.substring(index+3, index+4);
        if ( testCo.equals("co") && testE.equals("e")) {
          codeNumber++;
        }
      }
      return codeNumber;
    }



}//end of class
