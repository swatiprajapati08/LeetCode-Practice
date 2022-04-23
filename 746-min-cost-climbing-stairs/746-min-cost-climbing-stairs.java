class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length + 2];
        int n = cost.length;
        // Arrays.fill(dp,-1);
        // memo(0,cost,dp);
        dp[n + 1] = 0;
        dp[n] = 0;
        for(int i = n - 1;i >= 0;i--)
            dp[i] = Math.min(dp[i + 1],dp[i + 2]) + cost[i];
        
        return Math.min(dp[0],dp[1]);
    }
    
//     int memo(int src, int[] cost, int dp[]){
//         if(src >= cost.length)
//             return 0;
//         if(dp[src] != -1)
//             return dp[src];
//         int ans1 = memo(src + 1, cost,dp);
//         int ans2 = memo(src + 2, cost,dp);
        
//         return dp[src] = Math.min(ans1,ans2) + cost[src];
//     }
}