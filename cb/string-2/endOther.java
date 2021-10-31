public class endOther {
    public static void main(String[] args) {
        System.out.println(endOther("Hiabc", "abc")); // true
        System.out.println(endOther("AbC", "HiaBc")); // true
        System.out.println(endOther("abc", "kkabXabc")); // true
    }

    /*
     * Given two strings, return true if either of the strings appears at the
     * very end of the other string, ignoring upper/lower case differences (in
     * other words, the computation should not be "case sensitive"). Note:
     * str.toLowerCase() returns the lowercase version of a string.
     */
    public static boolean endOther(String a, String b) {
        String shorterStr;
        String longerStr;

        if (a.length() > b.length()) {
          shorterStr = b.toLowerCase();
          longerStr = a.toLowerCase();
          }
        else {
          shorterStr = a.toLowerCase();
          longerStr = b.toLowerCase();
        }
        int lLength = longerStr.length();
        int sLength = shorterStr.length();

        return shorterStr.equals(longerStr.substring(lLength-sLength, lLength));
    }
}
