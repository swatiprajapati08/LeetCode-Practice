class Solution {
    int prefix[];
    Random random = new Random();
    int max = 0;
    public Solution(int[] w) {
        
        prefix = new int[w.length];
        
        prefix[0] = w[0];
        for(int i = 1;i<w.length;i++)
            prefix[i] = prefix[i - 1] + w[i];
        
        max = prefix[prefix.length - 1];
    }
    
    public int pickIndex() {
        int target = 1 + random.nextInt(max);
        return BS(target);
    }
    
    public int BS(int target){
        int ans = -1;
        int l = 0,h = prefix.length - 1;
        while(l <= h){
            int mid = l +(h - l)/2;
            if(prefix[mid] == target)
                return mid;
            else if(target > prefix[mid])
                l = mid + 1;
            else{
                h = mid - 1;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */