public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int low = 0, high = matrix.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (target < matrix[mid][0]) {
        high = mid - 1;
      } else if (matrix[mid][0] < target) {
        low = mid + 1;
      } else {
        return true;
      }
    }
    if (0 <= low - 1 && low - 1 < matrix.length) {
      int idx = Arrays.binarySearch(matrix[low - 1], target);
      if (idx >= 0) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}
