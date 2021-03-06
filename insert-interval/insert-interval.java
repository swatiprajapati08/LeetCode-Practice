class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
    
         List<int[]> ans = new ArrayList<>();
        for(int i = 0; i < intervals.length;i++){
            
        /*1. No overlap and toAdd appears before current interval, add toAdd to result.*/
            if(intervals[i][0] > newInterval[1]){
                ans.add(newInterval);
                newInterval = intervals[i];
            }
             /*2. Has overlap, update the toAdd to the merged interval.*/
            else if(intervals[i][1] >= newInterval[0]){
                newInterval = new int[]{Math.min(intervals[i][0],newInterval[0]),                                                           Math.max(intervals[i][1],newInterval[1])};
            }
            /*3. No overlap and toAdd appears after current interval, add current interval to result.*/
            else
                ans.add(intervals[i]);
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][2]);
    }
}