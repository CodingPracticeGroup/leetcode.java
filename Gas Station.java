public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n=gas.length;
        
        int residule=0;
        int sumgas=0;
        for(int i=0;i<n;i++){
            sumgas+=gas[i];
        }
        int sumcost=0;
        for(int i=0;i<n;i++){
            sumcost+=cost[i];
        }
        if(sumgas<sumcost) return -1;
        int result=0;
        
        for(int i=0;i<n;i++){
            residule=gas[i]-cost[i];
            result=i;
            while(residule>0&&i<n-1){
                i++;
                residule+=gas[i]-cost[i];
            }
        }
        
        return result;
    }
}