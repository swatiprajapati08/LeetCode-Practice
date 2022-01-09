class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int max = Integer.MAX_VALUE, left = 0;
        int sum = 0;
        for(int right = 0; right < nums.length;right++){
            
            
            sum += nums[right];
            
            //valid --> left increment
            while(sum >= target){
                
                max = Math.min(max,right - left + 1);
                
                sum -= nums[left];
                left++;
            }
        }
        if(max == Integer.MAX_VALUE) return 0;
        return max;
    }
}