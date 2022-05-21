class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        
        Arrays.fill(dp,1); // no call already taken {1},{2} // single element taken
        int maxLIS = 1;
        for(int i = 0; i < nums.length;i++){
            // find all its prev index, if prev index element is smaller then current 
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            maxLIS = Math.max(maxLIS,dp[i]);
        }
        
        // int max = 1;
        // // answer can end any index 
        // for(int i:dp)
        //     max = Math.max(i,max);
        // return max;
        
        return maxLIS;
    }
//         int dp[][] = new int[nums.length][nums.length + 1];
//         for(int[] arr: dp)
//             Arrays.fill(arr,-1);
//         return dp(0,-1,nums,dp);
//     }
    // -1 ko rkhne k liye we have taken extra 1
//     int dp(int index, int prev,int[] nums, int dp[][]){
//         //base case
//         if(index == nums.length)
//             return 0; //length of empty subset 
        
//         if(dp[index][prev + 1] != -1)
//             return dp[index][prev + 1];
        
        
//         int yes = (prev == -1 || nums[index] > nums[prev]) ? 
//                 dp(index + 1,index,nums,dp) + 1 : 0;
//         int no = dp(index + 1,prev,nums,dp);
      
//        return dp[index][prev + 1] = Math.max(yes,no);
//     }
}