import java.util.ArrayDeque;

public class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        String[] words = path.split("/");
        for (int i=0; i<words.length; i++) {
            if (words[i].equals("") || words[i].equals(".")){
                // nothing
            } else if (words[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(words[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0 , stack.pop()+"/");
        }
        if (sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.insert(0 , "/");
        return sb.toString();
    }
}