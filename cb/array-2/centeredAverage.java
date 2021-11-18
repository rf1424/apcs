public class centeredAverage {



    /**
     * Return the "centered" average of an array of ints, which we'll say is the
     * mean average of the values, except ignoring the largest and smallest
     * values in the array. If there are multiple copies of the smallest value,
     * ignore just one copy, and likewise for the largest value. Use int
     * division to produce the final average. You may assume that the array is
     * length 3 or more.
     */
    public static int centeredAverage(int[] nums) {
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

      //centered average
      int sum = 0;
      for (int index = 0; index < nums.length; index++) {
        sum += nums[index];
      }
      sum -= biggestNow + smallestNow;
      int avg = sum / (nums.length-2);
      return avg;
    }

    //test cases
    public static void main(String[] args) {
          System.out.println(centeredAverage(new int[] {1, 2, 3, 4, 100})); // 3
          System.out.println(centeredAverage(new int[] {1, 1, 5, 5, 10, 8, 7})); // 5
          System.out.println(centeredAverage(new int[] {-10, -4, -2, -4, -2, 0})); // -3
      }
}
