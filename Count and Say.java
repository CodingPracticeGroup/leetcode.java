public class Solution {
    public String countAndSay(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        while(n>1){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int previous=result.get(0);
            int count=0;
            for(int i=0;i<result.size();i++){
                if(result.get(i)!=previous){
                    temp.add(count);
                    temp.add(previous);
                    count=1;
                    previous=result.get(i);
                }else{
                    count++;
                }
            }
            temp.add(count);
            temp.add(previous);
            result=temp;
            n--;
        }
        StringBuilder sb = new StringBuilder();
        for(Integer i:result){
            sb.append(i);
        }
        return sb.toString();
    }
}
