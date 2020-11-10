package tyr.leet.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution973 {

  class Solution {

    private boolean usePriorityQueue = true;

    public int[][] kClosest(int[][] points, int K) {
      Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
      if (usePriorityQueue) {
        Comparator<int[]> comparator = Comparator.comparingInt(p -> -calculate(p, cache));
        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
        for (int[] point : points) {
          if (queue.size() >= K) {
            if (comparator.compare(point, queue.peek()) > 0) {
              continue;
            }
            queue.poll();
          }
          queue.add(point);
        }
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
          ret[i] = queue.poll();
        }
        return ret;
      } else { // sort all
        Arrays.sort(points, Comparator.comparingInt(p -> calculate(p, cache)));
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
          ret[i] = points[i];
        }
        return ret;
      }
    }

    private int calculate(int[] point, Map<Integer, Map<Integer, Integer>> cache) {
      return point[0] * point[0] + point[1] * point[1];
//          cache.computeIfAbsent(point[0], p -> new HashMap<>())
//          .computeIfAbsent(point[1], p -> point[0] * point[0] + point[1] * point[1]);
    }

  }

}
