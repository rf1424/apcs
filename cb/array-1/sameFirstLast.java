public class sameFirstLast{

  //Given an array of ints, return true if the array is length 1 or more,
  //and the first element and the last element are equal.
  public static boolean sameFirstLast(int[] nums) {
    return (nums.length>0 && nums[0] == nums[nums.length-1]);
  }

  //test cases
  public static void main(String[] args){
    System.out.println(sameFirstLast(new int[] {1, 2, 3})); // false
    System.out.println(sameFirstLast(new int[] {1, 2, 3, 1})); // true
    System.out.println(sameFirstLast(new int[] {1, 2, 1})); // true
  }

}
