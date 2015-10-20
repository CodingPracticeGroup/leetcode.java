public class Solution {
  public int candy(int[] ratings) {
    int dpLR[] = new int[ratings.length];
    dpLR[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        dpLR[i] = dpLR[i - 1] + 1;
      } else {
        dpLR[i] = 1;
      }
    }
    int dpRL[] = new int[ratings.length];
    dpRL[ratings.length - 1] = 1;
    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        dpRL[i] = dpRL[i + 1] + 1;
      } else {
        dpRL[i] = 1;
      }
    }
    return IntStream.range(0, ratings.length).map(i -> Math.max(dpLR[i], dpRL[i]))
        .reduce(0, Integer::sum);
  }
}
