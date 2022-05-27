class Solution {
    // TIME O(N2)
    // space -> memo O(N2) tab O(N)
//     public int lengthOfLIS(int[] nums) {
//         int dp[] = new int[nums.length];
        
//         Arrays.fill(dp,1); // no call already taken {1},{2} // single element taken
//         int maxLIS = 1;
//         for(int i = 0; i < nums.length;i++){
//             // find all its prev index, if prev index element is smaller then current 
//             for(int j = 0; j < i; j++){
//                 if(nums[j] < nums[i])
//                     dp[i] = Math.max(dp[i],dp[j] + 1);
//             }
//             maxLIS = Math.max(maxLIS,dp[i]);
//         }
        
        
        
        //
        
        // int max = 1;
        // // answer can end any index 
        // for(int i:dp)
        //     max = Math.max(i,max);
        // return max;
        
    //     return maxLIS;
    // }
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
    
    public int lengthOfLIS(int[] nums){
        // using BInary search
     ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i = 1; i< nums.length;i++){
            if(arr.get(arr.size() - 1) < nums[i])
                arr.add(nums[i]);
            else{
                int index = lowerIndex(arr,nums[i]);
                arr.set(index,nums[i]);
            }
        }
        return arr.size();
    }
    
    int lowerIndex(ArrayList<Integer> nums,int search){
        int low = 0, high = nums.size() -1 ;
        int index = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums.get(mid) >= search){
                index = mid;
                high = mid - 1;
            }else 
                low = mid + 1;
        }
        return index;
    }
}




