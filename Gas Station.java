public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;

		int sumgas = 0;
		int sumcost = 0;
		for (int i = 0; i < len; i++) {
			sumgas += gas[i];
			sumcost += cost[i];
		}
		if (sumgas < sumcost) {
			return -1;
		}

		int tank = 0;
		int ret = -1;
		for (int i = 0; i < len; i++) {
			tank += gas[i];
			tank -= cost[i];
			if (tank < 0) {
				ret = -1;
				tank = 0;
			} else {
				if (ret == -1) {
					ret = i;
				}
			}
		}
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] gas = new int[] { 2, 4 };
		int[] cost = new int[] { 3, 4 };
		new Solution().canCompleteCircuit(gas, cost);
	}

}
