public class Solution {
  public int nthUglyNumber(int n) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    int l2 = 0;
    int l3 = 0;
    int l5 = 0;
    for (int i = 2; i <= n; i++) {
      int u2 = list.get(l2) * 2;
      while (u2 <= list.peekLast()) {
        u2 = list.get(++l2) * 2;
      }
      int u3 = list.get(l3) * 3;
      while (u3 <= list.peekLast()) {
        u3 = list.get(++l3) * 3;
      }
      int u5 = list.get(l5) * 5;
      while (u5 <= list.peekLast()) {
        u5 = list.get(++l5) * 5;
      }
      int min = Math.min(u2, Math.min(u3, u5));
      if (u2 == min) {
        list.offerLast(u2);
        l2++;
      } else if (u3 == min) {
        list.offerLast(u3);
        l3++;
      } else if (u5 == min) {
        list.offerLast(u5);
        l5++;
      }
    }
    return list.peekLast();
  }
}