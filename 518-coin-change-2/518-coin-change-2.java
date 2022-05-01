class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[amount + 1][coins.length];
        for(int i = 0; i<= amount;i++){
            for(int j = 0; j<coins.length;j++)
                dp[i][j] = -1;
        }
        int ans = memo(dp,coins,0,amount);
        if(ans == Integer.MAX_VALUE) return 0;
        return ans;
        
    }
     int memo(int dp[][],int coins[],int idx, int amount){
         if(amount == 0)
             return 1;
         if(idx == coins.length) return 0;
         if(dp[amount][idx] != -1)
             return dp[amount][idx];
         int count = 0;
         for(int i = 0; amount >= (coins[idx] * i);i++)
             count += memo(dp,coins,idx + 1,amount -(coins[idx] * i));
         
         return dp[amount][idx] = count;
     }
}