class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while(l < r){
            if(nums[l] + nums[r] == k){
                count++;
                l++;
                r--;
            }else if(nums[l] + nums[r] > k)
                r--;
            else
                l++;
        }
        return count;     

    }
}