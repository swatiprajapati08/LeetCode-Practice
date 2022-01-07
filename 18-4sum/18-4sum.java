class Solution {
    //k sums
    
    public List<List<Integer>> twoSum(int nums[],int left, int target){
        
        List<List<Integer>> ans = new ArrayList<>();
        int start = left;
        int right =  nums.length - 1;
        while(left < right){
            
            if(left > start && nums[left - 1] == nums[left]){
                left++;continue;
            }
            
            int sum = nums[left] + nums[right];
            
            if(sum == target){
                List<Integer> p = new ArrayList<>();
                p.add(nums[left]);
                p.add(nums[right]);
                ans.add(p);
                left++;
                right--;
            }
            else if( sum < target)
                left++;
            else
                right--;
        }
        return ans;
    }
    
    public List<List<Integer>> kSums(int nums[],int start,int target, int k){
        if(k == 2)
            return twoSum(nums,start,target);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = start; i <= nums.length - k;i++){
            
            if(i > start && nums[i] == nums[i - 1]) continue;
            
             List<List<Integer>> res = kSums(nums,i + 1,target-nums[i],k-1);
             for(List<Integer> temp : res){
                 temp.add(0,nums[i]);
                 ans.add(temp);
             }
        }
        return ans;
    }
    
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSums(nums,0,target,4);
    }
}