class Solution {
    public String reverseParentheses(String s) {
        
        Stack<StringBuilder> st = new Stack<>();
        // StringBuilder sb = new StringBuilder();
        StringBuilder open = new StringBuilder("(");
        
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '(')
                st.push(open);
            
            
            else if(ch == ')'){
                StringBuilder sb = new StringBuilder("");
                while(st.peek() != open){
                    StringBuilder top =st.pop();
                    top.reverse();
                    sb.append(top);
                }
                st.pop(); // '('
                st.push(sb);
            }
            else {
              if(st.size() == 0 || st.peek() == open)
                  st.push(new StringBuilder(ch +""));
                else
                st.peek().append(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(st.size() > 0){
            StringBuilder top =st.pop();
                    top.reverse();
                    ans.append(top);
        }
           
        
        return ans.reverse().toString();
    }
}