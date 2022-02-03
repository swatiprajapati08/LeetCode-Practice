class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> ab = new HashMap<>();
        
        for(int x : nums1)
            for(int y:nums2)
                ab.put(x + y, ab.getOrDefault(x + y, 0) + 1);
        
        int count = 0;
        
        for(int c:nums3)
            for(int d:nums4)
                count += ab.getOrDefault(- c - d, 0);
        
        return count;
    }
}