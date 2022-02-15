public String noX(String str) {
  if (str.length() == 0) {
    return "";
  } else if (str.charAt(0) == 'x') {
    return noX(str.substring(1));
  } else {
    return str.charAt(0) + noX(str.substring(1));
  }
}
