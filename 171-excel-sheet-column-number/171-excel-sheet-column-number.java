class Solution {
    public int titleToNumber(String S) {
        int ans = 0;
        for(int i = 0;i<S.length();i++){
            int val = (S.charAt(i) - 'A') + 1;
            ans = ans * 26 + val;
        }
        return ans;
    }
}