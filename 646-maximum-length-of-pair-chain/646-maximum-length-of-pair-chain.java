class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> { return a[1] - b[1]; });
        
        
        int limit = -1004,ans =0;
        for(int[] pair :pairs){
            if(pair[0] > limit){
                ans++;
                limit = Math.max(pair[1],limit);
            }
            
        }
        return ans;
    }
}