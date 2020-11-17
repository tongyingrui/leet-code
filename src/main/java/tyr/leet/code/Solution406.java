package tyr.leet.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution406 {

  public static void main(String[] args) {
    int[][] people = new int[][]{
        new int[]{7, 0},
        new int[]{4, 4},
        new int[]{7, 1},
        new int[]{5, 0},
        new int[]{6, 1},
        new int[]{5, 2},
    };
    System.out.println(Arrays.deepToString(new Solution().reconstructQueue(people)));
  }


  static class Solution {

    public int[][] reconstructQueue_old(int[][] people) {
      Arrays.sort(people, Comparator.<int[]>comparingInt(o -> -o[0]).thenComparingInt(o -> -o[1]));
      LinkedList<int[]> list = new LinkedList<>();
      for (int[] peo : people) {
        list.add(peo[1], peo);
      }
      return list.toArray(new int[people.length][]);
    }

    public int[][] reconstructQueue(int[][] people) {
      Arrays.sort(people, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> -o[1]));
      int[][] ret = new int[people.length][];
      SegmentTree tree = new SegmentTree(ret.length);
      for (int[] peo : people) {
        ret[tree.insert(peo[1])] = peo;
      }
      return ret;
    }

    // segment tree

    class SegmentTree {

      final int size;
      final Node root;

      SegmentTree(int size) {
        this.size = size;
        this.root = new Node(0, size);
        init(root);
      }

      private void init(Node root) {
        if (root.start + 1 == root.end) {
          return;
        }
        root.left = new Node(root.start, (root.start + root.end) / 2);
        root.right = new Node((root.start + root.end) / 2, root.end);
        init(root.left);
        init(root.right);
      }

      public int insert(int emptyIndex) {
        Node node = root;
        while (true) {
          node.size--;
          if (node.left == null || node.right == null) {
            return node.start;
          }
          if (node.left.size > emptyIndex) {
            node = node.left;
          } else {
            emptyIndex -= node.left.size;
            node = node.right;
          }
        }
      }

    }

    class Node {

      int start;
      int end;
      int size;
      Node left;
      Node right;

      public Node(int start, int end) {
        this.start = start;
        this.end = end;
        this.size = end - start;
      }
    }

  }
}
