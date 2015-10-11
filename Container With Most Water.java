public class Solution {
  public int maxArea(int[] height) {
    int i = 0, j = height.length - 1;
    int max = 0;
    while (i < j) {
      max = Math.max(max, (j - i) * Math.min(height[i], height[j]));

      // 如果不移短的只移长的，短的决定高度，不会变大，所以移短的
      // 为什么往内移动？反证法
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return max;
  }
}
