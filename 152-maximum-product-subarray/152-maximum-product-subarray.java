class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i:nums)
            max = Math.max(i,max);
        
        int currMax = 1, currMin = 1;
        for(int i:nums){
            if(i == 0){
                currMax = 1;
                currMin = 1;
            }
            
            int temp = currMax * i;
            int temp2 = currMin * i;
            
            currMax = Math.max(i,Math.max(temp,temp2));
            currMin = Math.min(i,Math.min(temp,temp2));
            
            max = Math.max(currMax,max);
        }
        return max;
    }
}