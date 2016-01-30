public class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (Arrays.stream(gas).reduce(0, Integer::sum) < Arrays.stream(cost).reduce(0, Integer::sum))
      return -1;
    int gas_cost[] = IntStream.range(0, gas.length).map(i -> gas[i] - cost[i]).toArray();
    int idx = 0;
    int sum = 0;
    for (int i = 0; i < gas.length; i++) {
      sum += gas_cost[i];
      if (sum < 0) {
        sum = 0;
        idx = i + 1;
      }
    }
    return idx;
  }
}
--------------
public class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (Arrays.stream(cost).sum() > Arrays.stream(gas).sum()) {
      return -1;
    }
    int tank = 0;
    int ret = 0;
    for (int i = 0; i < gas.length; i++) {
      tank += gas[i];
      tank -= cost[i];
      if (tank < 0) {
        tank = 0; // always >=0
        ret = i + 1; // ret idx starts when tank ==0
      }
    }
    return ret;
  }
}
