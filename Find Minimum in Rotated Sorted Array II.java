public class Solution {
    private int findMin_range(int[] nums, int start, int end) {
        if (start+1==end) return nums[start];
        if (start+2==end) return Math.min(nums[start], nums[start+1]);
        int mid = (start+end)/2;
        if(nums[start]<nums[mid] && nums[mid]<nums[end-1]) {
            return nums[start];
        } else if (nums[start]<nums[mid]) {
            return Math.min(nums[start], findMin_range(nums, mid+1, end));
        } else if (nums[mid]<nums[end-1]) {
            return Math.min(nums[mid], findMin_range(nums, start, mid));
        } else {
            return Math.min(findMin_range(nums, start, mid), findMin_range(nums, mid, end));
        }
    }
    public int findMin(int[] nums) {
        return findMin_range(nums, 0, nums.length);
    }
}