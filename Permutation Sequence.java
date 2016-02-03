public class Solution {
    public String getPermutation(int n, int k) {
        int factorial[] = new int [n+1];
        factorial[1] = 1;
        for (int i=2; i<n; i++) {
            factorial[i] = i*factorial[i-1];
        }
        
        List<Integer> pool = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            pool.add(i);
        }
        
        StringBuilder sb =new StringBuilder();
        k--;
        for (int i=n-1; i>=1; i--) {
            int idx = k/factorial[i];
            k = k%factorial[i];
            sb.append(pool.get(idx));
            pool.remove(idx);
        }
        sb.append(pool.get(0));
        return sb.toString();
    }
}
----------------
public class Solution {
  public String getPermutation(int n, int k) {
    k--;
    LinkedList<Integer> l = new LinkedList<>(); // numbers
    l.offerLast(1);
    LinkedList<Integer> f = new LinkedList<>(); // factorial
    f.offerLast(1);
    for (int i = 2; i <= n; i++) {
      l.offerLast(l.peekLast() + 1);
      f.offerLast(f.peekLast() * i);
    }
    f.pollLast();

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < n; i++) {
      // Collections.sort(l);
      int idx = k / f.peekLast();
      k = k % f.peekLast();
      sb.append(l.get(idx));

      l.remove(idx);
      f.pollLast();
    }
    sb.append(l.pollLast());
    return sb.toString();
  }
}
