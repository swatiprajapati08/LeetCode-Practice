class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums,new ArrayList<>(),ans);
        return ans;
        
    }
    void permutation(int nums[], List<Integer> temp, List<List<Integer>> ans){
        if(nums.length == temp.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i =0;i < nums.length;i++){
            if(nums[i] != 15){
                int curr = nums[i];
                nums[i] = 15;
                temp.add(curr);
                permutation(nums,temp,ans);
                //backtrack
                temp.remove(temp.size() - 1);
                nums[i] = curr;
            }
        }
    }
}