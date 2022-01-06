class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int ans[] = new int[nums.length - k + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int p = 0; 
        for(int i = 0; i<nums.length;i++){
            
            if(q.size() > 0 && q.getFirst() <= i - k)
                q.removeFirst();
            
            while(q.size() > 0 && nums[q.getLast()] < nums[i])
                q.removeLast();
            
            q.addLast(i);
            
            if(i >= k - 1) ans[p++] = nums[q.getFirst()];
        }
        return ans;
    }
}