class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0,needed = 0;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '(')
                open++;
            else{
                if(open > 0)
                    open--;
                else
                    needed++;
            }
        i++; 
        }
        return needed + open;
    }
}