class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>>  ans = new ArrayList();
        //remove duplicate
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2;i++){
            int j = i + 1, k = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]) { continue;}
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    ans.add(res);
                    //skip duplicate 
                    while(j < k && nums[j + 1] == nums[j]) j++;
                    while(j < k && nums[k - 1] == nums[k]) k--;
                    
                    j++;
                    k--;
                 }
                else if(sum < 0)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }
}