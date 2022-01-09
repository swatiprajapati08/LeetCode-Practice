class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(k == 0) return 0;
         
        int prod = 1, left = 0,count = 0;
         for(int right = 0; right < nums.length;right++){
            prod *= nums[right];
            
            //invalid --> left increment
            while(left < nums.length && prod >= k){
                prod = prod / nums[left];
                left++;
            }
             
            if(prod < k)
           count += right - left + 1 ;
        }
        //if(max == Integer.MAX_VALUE) return 0;
        return count;
    }
}