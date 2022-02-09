class Solution {
    public int findPairs(int[] nums, int target) {
     Arrays.sort(nums);
        int i = 0, j = 1,ans = 0;
        while(i < nums.length && j < nums.length){
            
            if(i > 0 && i < nums.length && nums[i - 1] == nums[i]){i++; continue;}
            
            int diff = nums[j] - nums[i];
            
            if(i == j){
                if(target < 0)
                    i++;
                else
                    j++;
                continue;
            }
            
            if(diff == target){
                ans++;
                i++;
                j++;
            }
            else if(diff < target) j++;
            else
                i++;
        }
        return ans;
    }
}