class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length + 1];
        for(int[] arr: dp)
            Arrays.fill(arr,-1);
        return dp(0,-1,nums,dp);
    }
    int dp(int index, int prev,int[] nums, int dp[][]){
        //base case
        if(index == nums.length)
            return 0; //length of empty subset 
        
        if(dp[index][prev + 1] != -1)
            return dp[index][prev + 1];
        
        
        int yes = (prev == -1 || nums[index] > nums[prev]) ? 
                dp(index + 1,index,nums,dp) + 1 : 0;
        int no = dp(index + 1,prev,nums,dp);
      
       return dp[index][prev + 1] = Math.max(yes,no);
    }
}