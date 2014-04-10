public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(null==num) return result;
        int len=num.length;
        if(len<3) return result;
        
        Arrays.sort(num);
        
        for(int i=0;i<len-2;i++){
            //remove duplicates
            if(i>0&&num[i]==num[i-1]) continue;
            //two sum
            int head=i+1;
            int tail=len-1;
            while(head<tail){
                if(num[head]+num[tail]+num[i]==0){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[head]);temp.add(num[tail]);temp.add(num[i]);
                    Collections.sort(temp);
                    result.add(temp);
                    do{head++;}while(head<tail&&num[head]==num[head-1]); 
                    do{tail--;}while(head<tail&&num[tail]==num[tail+1]); 
                }else if(num[head]+num[tail]+num[i]<0){
                    head++;
                }else{
                    tail--;
                }
            }
        }
        
        return result;
    }
}
