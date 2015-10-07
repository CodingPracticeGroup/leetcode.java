import java.util.HashMap;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> val_idx = new HashMap<>();
    
        int[] halves = new int[] {-1, -1};
    
        IntStream.range(0, nums.length).map(i -> {
          if (nums[i] * 2 == target) {
            if (halves[0] == -1) {
              halves[0] = i+1;
            } else if (halves[1] == -1) {
              halves[1] = i+1;
            }
          } else {
            val_idx.put(nums[i], i);
          }
          return i;
        }).count();
    
        if (halves[1] > -1) {
			Arrays.sort(halves);
          return halves;
        }
    
        return IntStream.range(0, nums.length)
            .filter(i -> val_idx.containsKey(target - nums[i]))
            .sorted().map(i -> i + 1).toArray();
	}
}