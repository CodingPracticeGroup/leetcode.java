public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		Set s = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++)
			s.add(numbers[i]);
		int ret[] = new int[2];
		int i;
		for (i = 0; i < numbers.length; i++)
			if (s.contains(target - numbers[i])) {
				ret[0] = i + 1;
				break;
			}
		for (int j = i; j < numbers.length; j++)
			if (numbers[j] == target - numbers[ret[0] - 1]) {
				ret[1] = j + 1;
			}
		return ret;
	}
}