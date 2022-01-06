class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        for(int res[]:trips){
            hm.put(res[1],hm.getOrDefault(res[1],0) + res[0]);
            hm.put(res[2],hm.getOrDefault(res[2],0) - res[0]);
        }
        
        for(int val : hm.values()){
            capacity -= val;
            if(capacity < 0)
                return false;
        }
        return true;
    }
}