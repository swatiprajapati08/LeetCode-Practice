class Solution {
    public int findMinArrowShots(int[][] pairs) {
       Arrays.sort(pairs, (a, b) -> { return a[1] > b[1] ? 1:-1; });
        int limit = pairs[0][1],ans =1;
        for(int[] pair : pairs){
            
            //non-overlapping
            
            if(pair[0] > limit){
                ans++;
            limit = Math.max(pair[1],limit);
            }
            
        }
        return ans;  
    }
}