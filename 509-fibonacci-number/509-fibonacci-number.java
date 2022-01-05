class Solution {
    int dp[] = new int[31];
    
    public int fib(int n) {
    if(n == 0 || n == 1)
        return n;
        
        if(dp[n] != 0)
            return dp[n];
        
        int l = dp[n - 2] != 0 ? dp[n - 2] : fib(n - 2);
        int r = dp[n - 1] != 0 ? dp[n - 1] : fib(n - 1);
        
        dp[n] = r + l;
        return dp[n];
    }
    
}