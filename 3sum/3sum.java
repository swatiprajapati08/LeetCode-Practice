class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>>  ans = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2;i++){
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    ans.add(res);
                    j++;
                    k--;
                }
                else if(sum < 0)
                    j++;
                else
                    k--;
            }
        }
        return new ArrayList<List<Integer>>(ans);
    }
}