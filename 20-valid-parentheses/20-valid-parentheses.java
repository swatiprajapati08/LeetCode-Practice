class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char c:s.toCharArray()){
           if(c == '(' || c == '{' || c == '[') 
               st.push(c);
            else{
                if(st.size() == 0) return false;
                char ch = st.peek();
                if(c == ')'){
                    if(ch != '(')
                        return false;
                    st.pop();
                }
                else if(c == '}'){
                    if(ch != '{')
                        return false;
                    st.pop();
                }
                else if(c == ']'){
                    if(ch != '[')
                        return false;
                    st.pop();
                }
            }
        }
        if(st.size() > 0) return false;
        return true;
    }
}