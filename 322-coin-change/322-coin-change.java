class Solution {
    public int coinChange(int[] coins, int amount) {
        // int dp[] = new int[amount + 1];
//         Arrays.fill(dp,-1);
//         int ans = memo(dp,amount,coins);
            
//         return  ans == Integer.MAX_VALUE ? -1 : ans;
        
        // dp[0] = 0;
        // for(int i = 1;i<=amount; i++){
        //     int min = Integer.MAX_VALUE - 1;
        //     for(int j = 0; j < coins.length;j++){
        //         if(dp[i] - coins[j] >= 0)
        //             min = Math.min(min,dp[i] - coins[j]);
        //     }
        //     dp[i] = 1 + min;
        // }
        // return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        
        
        int dp[][] = new int[amount + 1][coins.length];
        for(int i = 0; i<= amount;i++){
            for(int j = 0; j<coins.length;j++)
                dp[i][j] = -1;
        }
        int ans = memo3(dp,coins,amount,0);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    int memo(int dp[],int amt,int coins[]){
        
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
    
    int memo2(int dp[][],int coins[], int amt, int idx){
        if(amt == 0) return 0;
        if(coins.length == idx) return Integer.MAX_VALUE;
        
        if(dp[amt][idx] != -1)
            return dp[amt][idx];
        
        int minCoins = Integer.MAX_VALUE;
        // 9 -- 2(X), 2(1),2(2),2(3),2(4),cant take 2(5) bcz is greater
        for(int i = 0; amt >= coins[idx] * i;i++){
            int ans = memo2(dp,coins,amt - coins[idx],idx + 1);
            if(ans < Integer.MAX_VALUE) ans += i;
            minCoins = Math.min(minCoins, ans);
        }
        
        return dp[amt][idx] = minCoins;
    }
    int memo3(int dp[][],int coins[], int amt, int idx){
        if(amt == 0) return 0;
        if(coins.length == idx || amt < 0) return Integer.MAX_VALUE;
        
        if(dp[amt][idx] != -1)
            return dp[amt][idx];
        
        int minCoins = Integer.MAX_VALUE - 1 ;
        int no = memo3(dp,coins,amt,idx + 1);
        int yes = memo3(dp,coins,amt - coins[idx],idx);
        if(yes != Integer.MAX_VALUE) yes++;
        return dp[amt][idx] = Math.min(no,yes);
    }
}