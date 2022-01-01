class Solution {
    public int triangleNumber(int[] nums) {
       Arrays.sort(nums);
       int count = 0;
       int i = nums.length - 1;
        while(i >= 2){
            int l = 0, r = i - 1;
            while(l  <  r){
                int sum = nums[l] + nums[r];
                if(sum > nums[i]){
                    count += (r - l);
                    r--;
                }
                else
                    l++;
            }
            i--;
        }
        return count;
    }
}