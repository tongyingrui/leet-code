package tyr.leet.code;

public class Solution283 {

  class Solution {

    public void moveZeroes(int[] nums) {
      int zeroIndex = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          if (i > zeroIndex) {
            nums[zeroIndex] = nums[i];
          }
          zeroIndex++;
        }
      }
      for (int i = zeroIndex; i < nums.length; i++) {
        nums[i] = 0;
      }
    }

  }

}
