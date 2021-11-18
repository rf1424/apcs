public class bigDiff {
    /**
     * Given an array length 1 or more of ints, return the difference between
     * the largest and smallest values in the array. Note: the built-in
     * Math.min(v1, v2) and Math.max(v1, v2) methods  return the smaller or
     * larger of two values.
     */
    public static int bigDiff(int[] nums) {
      int biggestNow = nums[0];
      int smallestNow = nums[0];
      //find biggest
      for (int index = 1; index < nums.length; index++) {
        biggestNow = Math.max(biggestNow, nums[index]);
      }
      //find smallest
      for (int index = 1; index < nums.length; index++) {
        smallestNow = Math.min(smallestNow, nums[index]);
      }

      //difference
      return biggestNow - smallestNow;

    }
    //test cases
    public static void main(String[] args) {
        System.out.println(bigDiff(new int[] {10, 3, 5, 6})); // 7
        System.out.println(bigDiff(new int[] {7, 2, 10, 9})); // 8
        System.out.println(bigDiff(new int[] {2, 10, 7, 2})); // 8
    }
}
