import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int maxPoints(Point[] points) {
    if (points.length == 0)
      return 0;
    int max = 1;
    for (int i = 0; i < points.length; i++) {
      int i_max = 1;
      Map<Double, Integer> k_count = new HashMap<>();
      int inf_count = 1;
      int duplicate = 0;
      for (int j = i + 1; j < points.length; j++) {
        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          duplicate++;
        } else if (points[i].x == points[j].x) {
          inf_count++;
          i_max = Math.max(i_max, inf_count);
        } else {
          int bigx = i;
          int smallx = j;
          if (points[bigx].x < points[smallx].x) {
            bigx = j;
            smallx = i;
          }
          double k =
              (points[bigx].y - points[smallx].y) * 1.0 / (points[bigx].x - points[smallx].x);
          if (k_count.containsKey(k)) {
            int newcount = k_count.get(k) + 1;
            k_count.put(k, newcount);
            i_max = Math.max(i_max, newcount);
          } else {
            k_count.put(k, 2);
            i_max = Math.max(i_max, 2);
          }
        }
      }
      max = Math.max(max, i_max + duplicate);
    }
    return max;
  }
}
