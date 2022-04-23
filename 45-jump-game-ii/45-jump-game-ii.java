class Solution {
    public int jump(int[] nums) {
       int n = nums.length;
       int dp[] = new int[n];
       dp[n - 1] = 0; // min moves des to des
       for(int cell = n - 2; cell >= 0; cell--){
           int min = 10003;
           for(int jump = 1; jump <= nums[cell] && jump + cell < n ; jump++)
               min = Math.min(min,dp[jump + cell] + 1);
           dp[cell] = min;
       }
        return dp[0];
    }
}