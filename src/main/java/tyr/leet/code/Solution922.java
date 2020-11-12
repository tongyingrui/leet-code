package tyr.leet.code;

public class Solution922 {

  class Solution {
    public int[] sortArrayByParityII(int[] A) {
      int even = 0;
      int odd = 1;
      while (Math.max(odd, even) < A.length) {
        while (even < A.length) {
          if (A[even] % 2 != 0) {
            break;
          }
          even += 2;
        }
        while (odd < A.length) {
          if (A[odd] % 2 == 0) {
            break;
          }
          odd += 2;
        }
        if (odd < A.length && even < A.length) {
          int tmp = A[odd];
          A[odd] = A[even];
          A[even] = tmp;
        }
      }
      return A;
    }
  }

}
