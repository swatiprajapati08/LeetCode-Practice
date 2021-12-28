class Solution {
    public int[][] merge(int[][] intervals) {
      
        Arrays.sort(intervals,(a,b) -> {return a[0] - b[0];});
        ArrayList<int[]> ans = new ArrayList<>();
        
        int limit[] = intervals[0];
        
        for(int i = 1; i < intervals.length;i++){
            if(limit[1] >= intervals[i][0]) //7 > 5 overlapping
            {
                limit[1] = Math.max(limit[1],intervals[i][1]);
            }
            else{
               //deep copy
                int res[] = new int[2];
                res[0] = limit[0];
                res[1] = limit[1];
                ans.add(res);
                
                limit[0] = intervals[i][0];
                limit[1] = intervals[i][1];
            }
        }
        ans.add(limit);
        
        int temp[][] = new int[ans.size()][2];
        
       for(int i = 0; i< ans.size();i++){
           int x[] = ans.get(i);
           temp[i][0] = x[0];
           temp[i][1] = x[1];
       }
    return temp;
    }

}