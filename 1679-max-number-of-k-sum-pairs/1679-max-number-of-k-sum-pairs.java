class Solution {
    public int maxOperations(int[] nums, int k) {
        // int count = 0;
        // Arrays.sort(nums);
        // int l = 0, r = nums.length - 1;
        // while(l < r){
        //     if(nums[l] + nums[r] == k){
        //         count++;
        //         l++;
        //         r--;
        //     }else if(nums[l] + nums[r] > k)
        //         r--;
        //     else
        //         l++;
        // }
        // return count; 
        
        int count = 0;
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i:nums){
            if(hs.containsKey(k - i)){
                if(hs.get(k - i) >= 2)
                    hs.put(k - i, hs.get(k - i) - 1);
                else 
                    hs.remove(k - i);
                count++;
            }else{
                hs.put(i,hs.getOrDefault(i,0) + 1);
            }
        }
        return count;
    }
}