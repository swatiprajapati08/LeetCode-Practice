class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
       ans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        generatePalin(s,temp);
        return ans; 
    }
      void generatePalin(String S,List<String> temp){
        
        if(S.length() == 0){
            ans.add(new ArrayList<String>(temp));
            return;
        }
        
        for(int i = 0; i < S.length();i++){
            //generate palindromic prefix 
            String ss = S.substring(0,i+1);
            if(isPalin(ss)){
                
                temp.add(ss);
                generatePalin(S.substring(i+1),temp);
                //bactrack
                temp.remove(temp.size()-1);
            }
        }
    }
    
     boolean isPalin(String s){
        if(s.length() == 1)
        return true;
        int l = 0, r = s.length() - 1;
        char ch[] = s.toCharArray();
        while(l <= r){
            if(ch[l] != ch[r])
            return false;
            l++;
            r--;
        }
        return true;
    }
}