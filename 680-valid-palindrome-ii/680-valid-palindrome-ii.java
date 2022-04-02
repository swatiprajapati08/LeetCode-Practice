class Solution {
    public boolean validPalindrome(String s) {
         int l = 0, r = s.length() -1;
        int count =0;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return (checkPalindrome(s, l, r - 1) || checkPalindrome(s, l + 1, r));
            }
                l++;
                r--;
        }
        return true;
    }
    boolean checkPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}