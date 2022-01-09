class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int count = 0;
        int maxCount = 0;
        while(i < nums.length){
            
            while(i < nums.length && nums[i] == 1){
                count++;
                i++;
            }
            maxCount = Math.max(count,maxCount);
            count = 0;
            i++;
            
        }
        return maxCount;
    }
}