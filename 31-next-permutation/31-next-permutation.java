class Solution {
    //https://www.youtube.com/watch?v=6qXO72FkqwM
    public void nextPermutation(int[] nums) {
        if(nums.length == 1)
            return;
        
        int lastIdx = -1;
        int n = nums.length;
        int j = 1;
        while(j < n){
            if(nums[j] > nums[j - 1]){
                lastIdx = j;
            }
            j+=1;
        }
        
        if(lastIdx == -1){
            for(int i =0;i<n/2;i++){
                int temp = nums[i];
                nums[i] =nums[n - i - 1];
                nums[n - i - 1] = temp;
            }
                
            return;
        }
        //special case for swapping
        int idx = lastIdx;
        for(int i = lastIdx; i < nums.length;i++){
            if(nums[i] > nums[lastIdx - 1] && nums[i] < nums[idx])
                idx = i;
        }
        
        //swap that
        int temp = nums[idx];
        nums[idx] =nums[lastIdx- 1];
        nums[lastIdx - 1] = temp;
        
        Arrays.sort(nums,lastIdx,n);        
        return;
        
    }
}