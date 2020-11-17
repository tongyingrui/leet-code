package tyr.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Solution1030 {

  /**
   * solution with radix sort
   */
  class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
      int[][] ret = new int[R * C][2];
      int[] distCount = new int[R + C];
      for (int i = 0; i < C; i++) {
        for (int j = 0; j < R; j++) {
          int dist = Math.abs(i - r0) + Math.abs(j - c0);
          distCount[dist]++;
        }
      }

      for (int i = 1; i < distCount.length; i++) {
        distCount[i] = distCount[i - 1] + distCount[i];
      }

      for (int i = 0; i < C; i++) {
        for (int j = 0; j < R; j++) {
          int dist = Math.abs(i - r0) + Math.abs(j - c0);
          ret[--distCount[dist]] = new int[]{i, j};
        }
      }

      return ret;
    }
  }

  /**
   * solution with BFS
   */
  class SolutionOld {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
      List<int[]> list = new ArrayList<>();
      int longest = R + C;
      add(list, new int[]{r0, c0}, R, C);
      for (int i = 1; i < longest; i++) {
        for (int x = 0; x <= i; x++) {
          int y = i - x;
          addTo(list, r0, c0, x, y, R, C);
        }
      }
      return list.toArray(new int[0][]);
    }

    private void addTo(List<int[]> list, int r0, int c0, int x, int y, int R, int C) {
      add(list, new int[]{r0 + x, c0 + y}, R, C);
      if (y != 0) {
        add(list, new int[]{r0 + x, c0 - y}, R, C);
      }
      if (x != 0) {
        add(list, new int[]{r0 - x, c0 + y}, R, C);
      }
      if (x != 0 && y != 0) {
        add(list, new int[]{r0 - x, c0 - y}, R, C);
      }
    }

    private void add(List<int[]> list, int[] coor, int R, int C) {
      if (coor[0] >= 0 && coor[0] < R && coor[1] >= 0 && coor[1] < C) {
        list.add(coor);
      }
    }
  }
}
