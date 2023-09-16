class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        HashMap<Integer,Integer> hs = new HashMap();
        for(int i = 0; i < nums.length; i++)
            hs.put(nums[i],i);
        
        for(int i = 0; i<nums.length;i++){
            int left = (target - nums[i]);
            if(hs.containsKey(left) && hs.get(left) != i){
                arr[0] = i;
                arr[1] = hs.get(left);
                return arr;
            }
        }
        return arr;
    }
}