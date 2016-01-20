public class Solution {
  private boolean computeArea_overlap(int A, int B, int C, int D, int E, int F, int G, int H) {
    if (G <= A || C <= E)
      return false;
    if (H <= B || D <= F)
      return false;
    return true;
  }

  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int a1 = (C - A) * (D - B);
    int a2 = (G - E) * (H - F);
    if (computeArea_overlap(A, B, C, D, E, F, G, H)) {
      int x1 = Math.max(A, E);
      int y1 = Math.max(B, F);
      int x2 = Math.min(C, G);
      int y2 = Math.min(D, H);
      int overlap = (x2 - x1) * (y2 - y1);
      return a1 + a2 - overlap;
    } else {
      return a1 + a2;
    }
  }

  private boolean notOverlap(int A, int B, int C, int D, int E, int F, int G, int H) {
    return (C <= E || G <= A) || (H <= B || D <= F);
  }

  public int computeArea_(int A, int B, int C, int D, int E, int F, int G, int H) {
    int ret = (D - B) * (C - A) + (H - F) * (G - E);
    if (!notOverlap(A, B, C, D, E, F, G, H)) {
      ret -= (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
    }
    return ret;
  }
}
