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