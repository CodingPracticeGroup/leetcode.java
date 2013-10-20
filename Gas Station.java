public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		int total = gas.length;
		int gas_sum = 0;
		int cost_sum = 0;
		for (int i = 0; i < total; i++) {
			gas_sum += gas[i];
			cost_sum += cost[i];
		}
		if (cost_sum > gas_sum) {
			return -1;
		}
		int current = 0;
		for (; current < total;) {
			gas_sum = 0;
			cost_sum = 0;
			boolean pass = true;
			int i;
			for (i = current; i < total; i++) {
				gas_sum += gas[i];
				cost_sum += cost[i];
				if (cost_sum > gas_sum) {
					current = i + 1;
					pass = false;
					break;
				}
			}
			if (pass) {
				return current;
			}
		}
		return current;
	}
}