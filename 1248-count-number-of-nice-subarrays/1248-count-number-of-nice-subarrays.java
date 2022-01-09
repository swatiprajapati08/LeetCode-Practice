class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return AlmostKsubArray(nums,k) - AlmostKsubArray(nums,k-1);
    }
    public int AlmostKsubArray(int nums[],int k){
        int count = 0;
        int left = 0,odd =0 ;
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int right = 0;right<nums.length;right++){
            
            if(nums[right] % 2 != 0)
                odd++;

            
            //invalid
             while(odd > k){
                 
                 if(nums[left] % 2 != 0)
                     odd--;

                left++;
            }
            
            count += right - left + 1;
        }
        return count;
    }
}