public class Solution {
    public String simplifyPath(String path) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(path==null) return null;
        int len=path.length();
        if(len==0) return path;
        
        String result="";
        
        Stack<String> folds = new Stack<String>();
        
        int cur=0;
        int end=0;
        
        while(cur<len){
            while(cur<len&&path.charAt(cur)=='/') cur++;
            
            if(cur==len) break;
            
            end=cur;
            while(end<len&&path.charAt(end)!='/') end++;
            
            String temp=path.substring(cur,end);
            
            if(temp.equals("..")){
                if(!folds.isEmpty()) folds.pop();
            }else if(!temp.equals(".")){
                folds.push(temp);
            }
            cur=end;
        }
        
        if(folds.isEmpty()) return "/";
        
        while(!folds.isEmpty()){
            result=folds.pop()+result;
            result="/"+result;
        }
        
        return result;
    }
}