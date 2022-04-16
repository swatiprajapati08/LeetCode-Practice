class Solution {
    public int findMin(int[] nums) {
        // move till unsorted
       
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = low +(high - low)/2;
           // ans = Math.min(nums[mid],ans);
            if(nums[high] < nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }
}