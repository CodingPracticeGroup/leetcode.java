public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        code(n,result);
        return result;
    }
    
    public void code(int n, ArrayList<Integer> result){
        if(0==n) {result.add(0);} 
        else{
            code(n-1,result);
            int size=result.size();
            for(int i=size-1;i>=0;i--){
                int temp=result.get(i);
                temp|=1<<(n-1);
                result.add(temp);
            }
        }
    }
}
