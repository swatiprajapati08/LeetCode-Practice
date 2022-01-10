class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        
    HashSet<ArrayList<Integer>> hs = new HashSet<>();
        List <List <Integer>> ans = new ArrayList<>();
        
        Helper(arr,0,new ArrayList<Integer>(), hs);
        
        for(ArrayList<Integer> res : hs)
        ans.add(res);
        return ans;
    }
    
    static void Helper(int arr[], int index,ArrayList<Integer> res,HashSet<ArrayList<Integer>> hs){
        //all choices has been explored
        
        //if(index > arr.length) return;
        
        if(index == arr.length){
            // deep copy
            ArrayList<Integer> temp = new ArrayList<>(res);
            hs.add(temp);
            return;
        }
        
        //dont include
        Helper(arr,index+1,res,hs);
        //include that
        res.add(arr[index]);
        Helper(arr,index + 1,res,hs);
        
        res.remove(res.size()-1);
        return;
    }
}
