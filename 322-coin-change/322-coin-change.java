class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp,-1);
        int ans = memo(dp,amount,coins);
            
        return  ans == Integer.MAX_VALUE ? -1 : ans;
    }
    int memo(int dp[],int amt,int coins[]){
       //if(amt < 0) return Integer.MAX_VALUE;
        if(amt == 0) return 0; //minimum coins
        
        if(dp[amt] != -1)
            return dp[amt];
        int min = Integer.MAX_VALUE - 1;
        
        for(int i =0; i<coins.length;i++){
            if(amt - coins[i] >= 0)
                min = Math.min(min,memo(dp,amt - coins[i],coins));
        }
        
        return dp[amt] = 1 + min;
    }
}