public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder  sb = null;
        int num=words.length;
        int index=0;
        while(index<num){
            sb = new StringBuilder();
            int end = index;
            int lenofWords = 0;
            //greedy add words
            while((end<num) && ((lenofWords+words[end].length())<=L) ){
                lenofWords+=words[end++].length()+1;
            }
            int numofWords = end - index;
            if(numofWords>1){
                int space = L-(lenofWords-numofWords);
                int meanSpace = end==num?1:space/(numofWords-1);
                int moreSpace = end==num?0:space%(numofWords-1);
                //construct one line of result
                for(int i=index;i<end-1;i++){
                    sb.append(words[i]);
                    for(int j=0;j<meanSpace;j++){
                        sb.append(" ");
                    }
                    if(moreSpace-->0) sb.append(" ");
                }
                sb.append(words[end-1]);
                if(end==num){
                    for(int j=0;j<L-lenofWords+1;j++){
                        sb.append(" ");
                    }
                }
                //add one line
                result.add(sb.toString());
            }else{
                sb.append(words[index]);
                for(int i=0;i<(L-words[index].length());i++){
                    sb.append(" ");
                }
                result.add(sb.toString());
            }
            index=end;
        }
        return result;
    }
}
