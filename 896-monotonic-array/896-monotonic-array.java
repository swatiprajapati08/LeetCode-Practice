class Solution {
    public boolean isMonotonic(int[] nums) {
       if(nums.length == 1) return true;
        boolean inc = true;
        int j= 0;
        while(j +1 < nums.length && nums[j] == nums[j + 1])
            j++;
        if(j + 1<nums.length && nums[j] > nums[j + 1]) inc = false;
        
        for(int i = 1; i < nums.length; i++){
            // decreasing needed and curr become increasing
            if(inc == false && nums[i - 1] < nums[i])
                return false;
            else if(inc == true && nums[i - 1] > nums[i])
                return false;
        }
        return true;
    }
}