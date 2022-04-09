class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i:nums)
            hs.put(i,hs.getOrDefault(i,0) + 1);
        // customise in min heap
        Queue<Integer> q = new PriorityQueue<>((a,b) -> hs.get(a) - hs.get(b));
        
        for(int n: hs.keySet()){
            q.add(n);
            if(q.size() > k)
                q.poll();
        }
         int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = q.poll();
        }
        return top;
        
        
    }
}