class Solution {
    public int longestValidParentheses(String s) {
        int val = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i< s.length();i++){

            if(s.charAt(i) == '(')
                st.push(i);
            else{
               if(st.size() > 0 && s.charAt(st.peek()) == '(')
                   st.pop();
                else
                    st.push(i);
            }
            int j = st.size() == 0 ? -1 : st.peek();
            val = Math.max(val,i - j);
        }
        return val;
    }
}