public class Solution {
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int ret = 1;
    while (ret <= citations.length && citations[citations.length - ret] >= ret) {
      ret++;
    }
    return ret - 1;
  }
}
