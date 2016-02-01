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
--------------
public class Solution {
  public int maxArea(int[] height) {
    int low = 0;
    int high = height.length - 1;
    int ret = 0;
    while (low < high) {
      int h = Math.min(height[low], height[high]);
      ret = Math.max(ret, h * (high - low));
      if (height[low] < height[high]) {
        while (low < high && height[low] <= h) {
          low++;
        }
      } else if (height[low] > height[high]) {
        while (low < high && height[high] <= h) {
          high--;
        }
      } else {
        while (low < high && height[low] <= h) {
          low++;
        }
        while (low < high && height[high] <= h) {
          high--;
        }
      }
    }
    return ret;
  }
}
