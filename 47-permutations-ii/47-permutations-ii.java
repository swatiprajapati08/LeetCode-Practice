class Solution {
//     HashSet<ArrayList<Integer>> hs = new HashSet<>();
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
        
//         permutation(nums,new ArrayList<Integer>());
        
//         for(ArrayList<Integer> arr: hs)
//             ans.add(arr);
//         return ans;
//     }
    
//     void permutation(int nums[], List<Integer> temp){
//         if(nums.length == temp.size()){
//             hs.add(new ArrayList<>(temp));
//             return;
//         }
        
//         for(int i =0;i < nums.length;i++){
//             if(nums[i] != 15){
//                 int curr = nums[i];
//                 nums[i] = 15;
//                 temp.add(curr);
//                 permutation(nums,temp);
//                 //backtrack
//                 temp.remove(temp.size() - 1);
//                 nums[i] = curr;
//             }
//         }
//     }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        HashMap<Integer,Integer> hs = new HashMap<>();
        // now going to traverse using the hash value
        for(int i:nums)
            hs.put(i,hs.getOrDefault(i,0) + 1);
        
        permutation(hs,new ArrayList<Integer>(),ans,nums.length);
        
        return ans;
    }
    
    void permutation(HashMap<Integer,Integer> hm, List<Integer> temp,List<List<Integer>> ans, int n){
        if(temp.size() == n){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        
        //traverse the hashMap then add so no possiblity of repeating
        
        for(int key :hm.keySet()){
            
            int val = hm.get(key);
            if(val > 0){
                
            hm.put(key,val - 1);
            temp.add(key);
                
            permutation(hm,temp,ans,n);
                
            temp.remove(temp.size() - 1);
            hm.put(key, hm.getOrDefault(key,0) + 1);
            }
             
        }
    }
}