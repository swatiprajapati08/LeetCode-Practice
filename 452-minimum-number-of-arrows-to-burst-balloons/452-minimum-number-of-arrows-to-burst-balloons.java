class Solution {
    public int findMinArrowShots(int[][] intervals) {
       
        int n = intervals.length;
        Pair[] pairs = new Pair[n];
       for(int i = 0; i<n;i++)
       pairs[i] = new Pair(intervals[i][0],intervals[i][1]);
       
       
       //sort 
       Arrays.sort(pairs,new Comparator<Pair>(){
           public int compare(Pair t,Pair o){
               return t.end < o.end ? -1 : 1;
           }
       });
       
         int count = 1;
         long limit = pairs[0].end;
        
        //number of max.overlapping
        
       for(int i = 1; i<n;i++){
           if(pairs[i].start > limit){
               count++;
               limit = Math.max(limit,pairs[i].end);
           }
       }
       return count;
    }
}
class Pair{
    
    int start=0,end=0;
    Pair(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
}