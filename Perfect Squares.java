public class Solution {
  public int numSquares(int n) {
    List<Integer> pool = new ArrayList<>();
    for (int i = 1; i * i <= n; i++) {
      pool.add(i * i);
    }
    int level = 0;
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(n);
    while (!queue.isEmpty()) {
      level++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int m = queue.poll();
        for (int k : pool) {
          if (m - k > 0)
            queue.offer(m - k);
          else if (m - k == 0)
            return level;
          else
            break;
        }
      }
    }
    return n;
  }
}
