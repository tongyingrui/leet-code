package tyr.leet.code;

import java.util.Arrays;

public class Solution514 {
  class Solution {

    public int findRotateSteps(String ring, String key) {
      int[][] cache = new int[ring.length()][key.length()];
      for (int[] line : cache) {
        Arrays.fill(line, -1);
      }
      return dfs(ring, 0, key, 0, cache);
    }

    public int dfs(String ring, int ringIndex, String key, int keyStart, int[][] cache) {

      if (cache[ringIndex][keyStart] > 0) {
        return cache[ringIndex][keyStart];
      }

      int min = -1;
      char target = key.charAt(keyStart);
      for (int i = 0; i < ring.length(); i++) {
        int index = (ringIndex + i) % ring.length();
        if (ring.charAt(index) == target) {
          int move = Math.min(i, ring.length() - i) + 1;
          if (keyStart < key.length() - 1) {
            move += dfs(ring, index, key, keyStart + 1, cache);
          }
          if (min < 0 || min > move) {
            min = move;
          }
        }
      }
      cache[ringIndex][keyStart] = min;
      return min;
    }

  }
}
