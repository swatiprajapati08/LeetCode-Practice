class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int  i= 0;
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> hs = new HashSet<>();
        
        for(int j = 0; j< popped.length;j++){
            
               
            if(hs.contains(popped[j])){
                // if present then top p hi hona chahiye
                if(st.size() == 0|| popped[j] != st.peek())
                    return false;
                hs.remove(st.pop());
            }else{
                while(popped[j] != pushed[i]){
                    hs.add(pushed[i]);
                    st.push(pushed[i]);
                    i++;
                }
                i++; // for ultimately pop that
            }
        }
        
        return st.isEmpty();
    }
}