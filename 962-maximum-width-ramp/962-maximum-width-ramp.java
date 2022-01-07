class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int max = nums[n - 1];
        int rMax[] = new int[n];
        rMax[n-1] = nums[n - 1];
        for(int i = n - 2;i >= 0;i--){
            rMax[i] = Math.max(rMax[i+1],nums[i]);
        }
        int i = 0,j = 0,ans = 0;
        while(i < n && j < n){
            
            if(nums[i] <= rMax[j]){
                ans = Math.max(ans,j - i);
                j++;
            }
            else i++;
        }
        return ans;
    }
}