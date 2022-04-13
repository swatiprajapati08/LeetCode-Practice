class Solution {
    public int[] twoSum(int[] nums, int target) {
       //brute force traverse the whole 2 twice
       // and find
    //     int n = nums.length;
    //    for(int i = 0; i< n - 1;i++){
    //        for(int j = i + 1;j < n;j++){
    //            if(nums[i] + nums[j] == target)
    //                return new int[]{i,j};
    //        }
    //    }
    // return null;
        
        
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hs.containsKey(target - nums[i])){
                int val = hs.get(target - nums[i]);
                return new int[]{val, i};
            }else
                hs.put(nums[i],i);
        }
        return null;
    }
}