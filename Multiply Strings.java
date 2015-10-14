public class Solution {
  public String multiply(String num1, String num2) {
    int[] num1_arr = num1.chars().map(x -> x - '0').toArray();
    int[] num2_arr = num2.chars().map(x -> x - '0').toArray();
    int[] ret = new int[num1_arr.length + num2_arr.length];
    Arrays.fill(ret, 0);
    for (int i = num1_arr.length - 1; i >= 0; i--) {
      for (int j = num2_arr.length - 1; j >= 0; j--) {
        ret[ret.length - 1 - (num1_arr.length - 1 - i) - (num2_arr.length - 1 - j)] +=
            num1_arr[i] * num2_arr[j];
      }
    }
    for (int i = ret.length - 1; i > 0; i--) {
      int tmp = ret[i];
      ret[i] = tmp % 10;
      ret[i - 1] += tmp / 10;
    }
    int n = 0;
    while (n < ret.length - 1 && ret[n] == 0) {
      n++;
    }
    return Arrays.stream(ret).skip(n).mapToObj(x -> String.valueOf(x)).reduce((x, y) -> x + y)
        .get();
  }
}
