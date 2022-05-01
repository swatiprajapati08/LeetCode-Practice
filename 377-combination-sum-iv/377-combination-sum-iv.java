class Solution {
    public int combinationSum4(int[] nums, int target) {
      int dp[] = new int[target + 1];
        Arrays.fill(dp,-1);
        int ans = memo(dp,target,nums);
            
        return  ans;  
    }
     int memo(int dp[],int amt,int coins[]){
        
        if(amt == 0) return 1; 
        
        if(dp[amt] != -1)
            return dp[amt];
        int count = 0;
        
        for(int i =0; i<coins.length;i++){
            if(amt - coins[i] >= 0)
                count += memo(dp,amt - coins[i],coins);
        }
        
        return dp[amt] = count;
    }
}