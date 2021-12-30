class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0 , minDiff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1 , k = nums.length - 1;
            sum = nums[i];
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum < target){
                    j++;
                }
                else if(target == sum){
                    return sum;
                }
                else
                    k--;
                
                if(minDiff > Math.abs(sum - target)){
                       minDiff = Math.abs(sum - target);
                       ans = sum;
                   } 
            }
        }
        return ans;
    }
}