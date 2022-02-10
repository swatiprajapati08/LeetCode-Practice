class Solution {
    public int[] asteroidCollision(int[] ast) {
       Stack<Integer> st =new Stack<Integer>();
        for(int val: ast){
            
            // System.out.println(st);
            
           
            if(val < 0){
               boolean destroy = false;
                while(st.size() > 0 && st.peek() > 0){
                 
                    if(st.peek() == -val){
                        st.pop();
                        destroy = true; // skip that
                        break;
                    }
                    else if(st.peek() < -val){
                        st.pop();
                    }else{
                       destroy = true;
                       break;
                    }  
                }
                if(destroy == false)
                    st.push(val);
            }
            else
                st.push(val);
        }
        int arr[] = new int[st.size()];
        int p = st.size() - 1;
        while(p >= 0){
            arr[p--] = st.pop();
        }
        return arr;
    }
}