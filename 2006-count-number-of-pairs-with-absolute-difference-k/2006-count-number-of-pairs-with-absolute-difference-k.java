class Solution {
    public int countKDifference(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        for(int i:nums)
            hm.put(i,hm.getOrDefault(i,0)+1);
        
       for(Integer key:hm.keySet()){
           int freq1 = hm.get(key);
           
           if(target == 0)
               count += (target *(target+1))/2;
           else{
               int freq2 = hm.getOrDefault(target + key,0);
               count+= freq1 * freq2;
           }
       }
        return count;
    }
}