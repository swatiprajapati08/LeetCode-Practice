class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
       //gredy cant be use
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<heights.length - 1;i++){
            int diff = heights[i + 1] - heights[i];
            if(diff > 0)
                pq.add(diff);
            // if ladders > pq.size() means elements inside the pq can be easily handdle by ladders
            // else ladder is insufficient for handle building so minimise the diffrenece with bricks
            if(pq.size() > ladders)
                bricks -= pq.poll();
            
            if(bricks < 0)
                return i;
        }
        return heights.length - 1;
    }
}