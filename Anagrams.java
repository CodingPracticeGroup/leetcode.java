public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(strs==null) return null;
		ArrayList<String> result = new ArrayList<String>();
		HashMap<String,ArrayList<String>> hm= new HashMap<String,ArrayList<String>>();
		for(int i=0;i<strs.length;i++){
			char[] temp=strs[i].toCharArray();
			Arrays.sort(temp);
			String sorted = new String(temp);
			if(hm.containsKey(sorted)){
				hm.get(sorted).add(strs[i]);
			}else{
				ArrayList<String> tempal= new ArrayList<String>();
				tempal.add(strs[i]);
				hm.put(sorted, tempal);
			}
		}
		
		for(String str:hm.keySet()){
			if(hm.get(str).size()>1){
			    for(String strtemp:hm.get(str)){
				    result.add(strtemp);
			    }
			}
		}
		return result;
    }
}