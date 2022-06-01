class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = false, dec = false;
        for(int i = 1; i< nums.length;i++){
            if(nums[i - 1] < nums[i]) inc = true;
            if(nums[i - 1] > nums[i]) dec = true;
        }
        return inc && dec ? false : true;
    }
}