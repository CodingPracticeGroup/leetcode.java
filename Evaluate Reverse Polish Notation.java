import java.util.ArrayDeque;

public class Solution {
	public static int evalRPN(String[] tokens) {
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>(tokens.length);
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int operand2 = stack.pollLast();
				int operand1 = stack.pollLast();
				stack.offerLast(operand1 + operand2);
			} else if (tokens[i].equals("-")) {
				int operand2 = stack.pollLast();
				int operand1 = stack.pollLast();
				stack.offerLast(operand1 - operand2);
			} else if (tokens[i].equals("*")) {
				int operand2 = stack.pollLast();
				int operand1 = stack.pollLast();
				stack.offerLast(operand1 * operand2);
			} else if (tokens[i].equals("/")) {
				int operand2 = stack.pollLast();
				int operand1 = stack.pollLast();
				stack.offerLast(operand1 / operand2);
			} else {
				stack.offerLast(Integer.valueOf(tokens[i]));
			}
		}
		return stack.pollLast();
	}
	
	public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<Integer>();
        if(tokens==null) return -1;
        int size = tokens.length;
        int result=-1;
        if(size==0) return -1;
        
        for(int i=0;i<size;i++){
           
            int temp;
            try{
                temp=Integer.valueOf(tokens[i]);
                numbers.push(temp);
                continue;
            }catch(Exception e){
            }
            
            if(numbers.empty()) return -1;
            int number1 = numbers.pop();
            if(numbers.empty()) return -1;
            int number2 = numbers.pop();
            
            if(tokens[i].equals("+")) temp= number1 + number2;
            else if(tokens[i].equals("/")) temp= number2 / number1;
            else if(tokens[i].equals("*")) temp= number1 * number2;
            else if(tokens[i].equals("-")) temp= number2 - number1;
            else  return -1; 
            
            numbers.push(temp);
        }
        if(numbers.empty()) return -1;
        result= numbers.pop();
        
        return result;
    }

	public static void main(String[] args) {
		String[] expr = new String[5];
		expr[0] = "2";
		expr[1] = "1";
		expr[2] = "+";
		expr[3] = "3";
		expr[4] = "*";
		int r = evalRPN(expr);
	}
}
