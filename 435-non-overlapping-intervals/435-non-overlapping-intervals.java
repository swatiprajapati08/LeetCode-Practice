class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Pair[] arr = new Pair[n];
       for(int i = 0; i<n;i++)
       arr[i] = new Pair(intervals[i][0],intervals[i][1]);
       
       
       //sort 
               Arrays.sort(arr,new Comparator<Pair>(){
           @Override
           public int compare(Pair t,Pair o){
               return t.end - o.end;
           }
       });
       
      
       int count = 0,limit = Integer.MIN_VALUE;
       for(int i = 0; i<n;i++){
           if(arr[i].start >= limit){
               count++;
               limit = arr[i].end;
           }
       }
       
       return n - count;
    }
        
     
}
class Pair{
    
    int start,end;
    Pair(int start,int end)
    {
        this.start=start;
        this.end=end;// add your code here
    }
}