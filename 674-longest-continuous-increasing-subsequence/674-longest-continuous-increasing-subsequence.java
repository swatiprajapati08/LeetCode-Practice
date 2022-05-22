class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int maxCount = 1;
        for(int i = 1; i< nums.length;i++){
            if(nums[i - 1] < nums[i]){
                count += 1; // extend the previous subarray
            }else
                count = 1; // start a new increasing subarray
            maxCount = Math.max(maxCount,count);
        }
     return maxCount;
    }
}