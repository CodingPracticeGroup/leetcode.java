public class Solution {
  public int hIndex(int[] citations) {
    int low = 0;
    int high = citations.length;
    while (low < high) {
      int mid = low + (int) Math.ceil((high - low) / 2.0);
      if (Arrays.stream(citations).filter(x -> x >= mid).count() >= mid) {
        low = mid;
      } else {
        high = mid - 1;
      }
    }
    return low; // low==high
  }
}
