public class Solution {
  public int bulbSwitch(int n) {
    /*
     * 对于第i栈灯泡，当i的因子个数为奇数时，最终会保持点亮状态，例如9的因子为1，3，9
	 * 而当i的因子个数为偶数时，最终会保持熄灭状态，例如8的因子为：1，2，4，8
     * 当且仅当i为完全平方数时，其因子个数为奇数
     */
    return (int) Math.sqrt(n);
  }
}
------------------
public class Solution {
  public int bulbSwitch(int n) {
    return (int) Math.sqrt(n);
  }
}
