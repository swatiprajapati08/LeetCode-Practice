class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> score = new Stack<>();
        
        for(char c:s.toCharArray()){
            if(c == '(')
                score.push(-1);
            else{
                int val = 0;
                
                while(score.peek() != -1)
                    val+= score.pop();
                
                score.pop(); //remove =-1
                if(val == 0){ // () -> 1
                    score.push(1);
                }else{
                   score.push(2*val);
                }
            }
        }
        
        int val = 0;
        while(score.size() > 0)
            val += score.pop();
        
        return val;
    }
}