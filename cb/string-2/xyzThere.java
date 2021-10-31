public class xyzThere {
    public static void main(String[] args) {
        System.out.println(xyzThere("abcxyz")); // true
        System.out.println(xyzThere("abc.xyz")); // false
        System.out.println(xyzThere("xyz.abc")); // true
    }

    /*
     * Return true if the given string contains an appearance of "xyz" where the
     * xyz is not directly preceeded by a period (.). So "xxyz" counts but
     * "x.xyz" does not.
     */
    public static boolean xyzThere(String str) {

      for(int index = 0; index+2 < str.length(); index++) {
        String testStr = str.substring(index, index+3);
        if (testStr.equals("xyz")) {
          if (index == 0) {return true;}
          String testPd = str.substring(index-1, index);
          if (!(testPd.equals("."))) {return true;}
        }
      }
      return false;

    }
}
