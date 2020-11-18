package tyr.leet.code;

public class Solution134 {

  static class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int minIndex = 0;
      int min = 0;
      int left = 0;
      for (int i = 0; i < gas.length; i++) {
        left += gas[i];
        left -= cost[i];
        if (left <= min) {
          min = left;
          minIndex = i + 1;
        }
      }
      int startIndex = minIndex % gas.length;
        /* left = 0;
        for (int i = 0; i < gas.length; i++) {
            int index = (startIndex + i) % gas.length;
            left += gas[index];
            left -= cost[index];
            if (left < 0) {
                return -1;
            }
        } */
      if (left < 0) return -1;
      return startIndex;
    }
  }

}
