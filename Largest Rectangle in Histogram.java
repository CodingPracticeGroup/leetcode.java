public class Solution {
  public int largestRectangleArea(int[] height) {
    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
        int idx = stack.pop();
        int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
        int rightBoundary = i;
        int area = height[idx] * (rightBoundary - leftBoundary - 1);
        max = Math.max(max, area);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int idx = stack.pop();
      int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
      int rightBoundary = height.length;
      int area = height[idx] * (rightBoundary - leftBoundary - 1);
      max = Math.max(max, area);
    }
    return max;
  }
}
