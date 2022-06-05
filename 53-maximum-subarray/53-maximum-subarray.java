class Solution {
    public int maxSubArray(int[] nums) {
        int max = 0, maxSum = Integer.MIN_VALUE;
        
        for(int i: nums){
            // phle vale sum me add ho jao
           if(i <= max + i)
               max = max + i;
            else
                max = i;
            maxSum = Math.max(max,maxSum);
        }
        return maxSum;
    }
}