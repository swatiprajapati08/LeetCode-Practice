class Solution {
    public int findLongestChain(int[][] intervals) {
        int n = intervals.length;
        Pair[] pairs = new Pair[n];
       for(int i = 0; i<n;i++)
       pairs[i] = new Pair(intervals[i][0],intervals[i][1]);
       
       
       //sort 
       Arrays.sort(pairs,new Comparator<Pair>(){
           public int compare(Pair t,Pair o){
               return t.end - o.end;
           }
       });
       
       int count = 0,limit = Integer.MIN_VALUE;
       for(int i = 0; i<n;i++){
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
        this.end=end;// add your code here
    }
}