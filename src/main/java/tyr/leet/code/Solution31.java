package tyr.leet.code;

import java.util.Arrays;

public class Solution31 {

  class Solution {
    public void nextPermutation(int[] nums) {
      int targetStart = -1;
      for (int i = nums.length - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
          targetStart = i;
          break;
        }
      }
      if (targetStart == -1) {
        int start = 0, end = nums.length - 1;
        while (end > start) {
          int tmp = nums[start];
          nums[start] = nums[end];
          nums[end] = tmp;
          start++;
          end--;
        }
      } else {
        int ceilingIndex = targetStart + 1;
        for (int i = targetStart + 2; i < nums.length; i++) {
          if (nums[i] > nums[targetStart] && nums[i] < nums[ceilingIndex]) {
            ceilingIndex = i;
          }
        }
        int tmp = nums[ceilingIndex];
        nums[ceilingIndex] = nums[targetStart];
        nums[targetStart] = tmp;
        Arrays.sort(nums, targetStart + 1, nums.length);
      }
    }
  }

}
