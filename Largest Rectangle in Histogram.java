public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
        Stack<Integer> increasing = new Stack<Integer>();
        int cur = 0;
        int result= 0;
        while (cur < height.length) {  
            if (increasing.isEmpty() || height[cur] >= height[increasing.peek()]) {  
                increasing.push(cur++);
            } else {
                int top = increasing.pop();
                result = Math.max(result, height[top]*(increasing.isEmpty() ? cur : (cur-increasing.peek()-1)));
            }
            
       }  
       while (!increasing.isEmpty()) {  
           int top = increasing.pop();  
           result = Math.max(result, height[top]*(increasing.isEmpty() ? cur : (cur-increasing.peek()-1)));  
       }  
       return result; 
    }
}