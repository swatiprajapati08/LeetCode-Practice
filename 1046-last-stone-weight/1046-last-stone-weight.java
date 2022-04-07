class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0)
            return 0;
        if(stones.length == 1)
            return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones)
            pq.add(i);
        
        while(pq.size() >= 2){
            int a = pq.remove();
            int b = pq.remove();
            if(a == b) continue;
            else pq.add(a - b);
        }
        return pq.size() == 0 ? 0: pq.remove();
    }
}