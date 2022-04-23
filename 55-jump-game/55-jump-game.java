class Solution {
    public boolean canJump(int[] jumps) {
        //O(N2)
      // int n = nums.length;
      //  int dp[] = new int[n];
      //  dp[n - 1] = 0; // min moves des to des
      //  for(int cell = n - 2; cell >= 0; cell--){
      //      int min = 10003;
      //      for(int jump = 1; jump <= nums[cell] && jump + cell < n ; jump++)
      //          min = Math.min(min,dp[jump + cell] + 1);
      //      dp[cell] = min;
      //  }
      //   return dp[0] == 10003 ? false : true;  

  //WILL USE GREEDY SOLUTION
        int reach = 0;
        for(int i = 0; i<jumps.length;i++){
            if(i > reach) return false;
            
            if(i + jumps[i] > reach)
                reach = i + jumps[i];
        }
        return true;
    }
}