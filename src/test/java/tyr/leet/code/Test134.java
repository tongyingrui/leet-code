package tyr.leet.code;

import org.junit.Before;
import org.junit.Test;

public class Test134 {

  private Solution134.Solution solution;

  @Before
  public void myInit() {
      solution = new Solution134.Solution();
  }

  @Test
  public void test() {
    int[] gas = new int[]{1, 2, 3, 4, 5};
    int[] cost = new int[]{3, 4, 5, 1, 2};
    System.out.println(solution.canCompleteCircuit(gas, cost));
  }

}
