class Solution {
    HashSet<ArrayList<Integer>> hs = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        permutation(nums,new ArrayList<Integer>());
        
        for(ArrayList<Integer> arr: hs)
            ans.add(arr);
        return ans;
    }
    
    void permutation(int nums[], List<Integer> temp){
        if(nums.length == temp.size()){
            hs.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i =0;i < nums.length;i++){
            if(nums[i] != 15){
                int curr = nums[i];
                nums[i] = 15;
                temp.add(curr);
                permutation(nums,temp);
                //backtrack
                temp.remove(temp.size() - 1);
                nums[i] = curr;
            }
        }
    }
}