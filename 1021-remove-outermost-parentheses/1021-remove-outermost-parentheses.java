class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        // ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            }else{
                int j = st.pop();
                if(st.isEmpty())
                    sb.append(s.substring(j+1,i));
            }
        }
        return sb.toString();
    }
}