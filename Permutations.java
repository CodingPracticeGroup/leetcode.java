public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num==null||num.length==0) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        boolean[] visit = new boolean[num.length];
        ArrayList<Integer> one = new ArrayList<Integer>();
        per(num,visit,one,result);
        return result;
    }
    
    public void per(int[] num, boolean[] visit, ArrayList<Integer> one, ArrayList<ArrayList<Integer>> result){
        if(one.size()==num.length){
            result.add(new ArrayList<Integer>(one));return;
        }
        
        for(int i=0;i<num.length;i++){
            if(visit[i]){continue;}
            visit[i]=true;
            one.add(num[i]);
            per(num,visit,one,result);
            one.remove(one.size()-1);
            visit[i]=false;
        }
        
    }
}