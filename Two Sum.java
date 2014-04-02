import java.util.HashMap;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		int[] ret = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) != i) {
				ret[0] = i + 1;
				ret[1] = map.get(target - numbers[i]) + 1;
				return ret;
			}
		}
		return ret;
	}
}