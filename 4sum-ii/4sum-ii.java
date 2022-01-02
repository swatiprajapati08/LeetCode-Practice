class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        //make a  AB pair
        for(int i = 0; i < nums1.length;i++){
           // if(i > 0 && nums1[i - 1] == nums1[i]) continue;
            for(int j = 0;j<nums2.length;j++){
                //if(j > 0 && nums2[j - 1] == nums2[j]) continue;
                int sum = nums1[i] + nums2[j];
                hm.put(sum,hm.getOrDefault(sum,0)+1);
            }
        }
        //make a CD Pair
        HashMap<Integer,Integer> hm2 = new HashMap<>();
         for(int i = 0; i < nums3.length;i++){
            //if(i > 0 && nums3[i - 1] == nums3[i]) continue;
            for(int j = 0;j<nums4.length;j++){
                //if(j > 0 && nums4[j - 1] == nums4[j]) continue;
                int sum = nums3[i] + nums4[j];
                hm2.put(sum,hm2.getOrDefault(sum,0)+1);
            }
        }
        
        
        //make a pair
        int count = 0;
        for(Integer i: hm.keySet()){
            int val = hm2.containsKey(-i) ? hm2.get(-i) : 0;
            count += hm.get(i) * val;
        }
        return count;
    }
}