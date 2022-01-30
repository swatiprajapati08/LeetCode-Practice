class Solution {
    public int longestValidParentheses(String s) {
        int val = 0;
        Stack<Integer> st = new Stack<>();
        int start = 0,end = 0;
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
            // if(i - j > start){
            //     start = j + 1;
            //     end = i;
            // }
            val = Math.max(val,i - j);
        }
        // System.out.println(s.substring(start,end + 1)); // will not run for ""
        return val;
    }
}