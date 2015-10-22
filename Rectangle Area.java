public class Solution {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int twoarea = (C - A) * (D - B) + (G - E) * (H - F);
    if (E >= C || G <= A || H <= B || F >= D) { // no overlap
      return twoarea;
    } else {
      int overlap = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
      return twoarea - overlap;
    }
  }
}
