class Solution {
    public String removeOuterParentheses(String s) {
        // Stack<Integer> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
       int open = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                if(open > 0) sb.append(c);
                open++;
            }else{
               open--;
               if(open > 0) sb.append(c);
            }
        }
        return sb.toString();
    }
}