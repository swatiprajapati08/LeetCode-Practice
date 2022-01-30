class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            }else{
                if(st.size() == 1){
                    arr.add(st.pop());
                    arr.add(i);
                }
                else st.pop();
            }
        }
        int p =0;
        for(int i=0;i<s.length();i++){
            if(arr.get(p) == i){p++;}
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}