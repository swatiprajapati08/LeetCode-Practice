class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        int count=0;
        hs.put(0,1);
        int sum = 0;
        for(int i: nums){
            sum+=i;
            if(hs.containsKey(sum - k))
                count+= hs.get(sum - k);
        
            hs.put(sum,hs.getOrDefault(sum,0) + 1);
        } 
        return count;
    }
}