class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
       Pair[] pairs = new Pair[n];
       for(int i = 0; i<n;i++)
       pairs[i] = new Pair(start[i],end[i]);
       
       
       //sort 
       Arrays.sort(pairs,new Comparator<Pair>(){
           public int compare(Pair t,Pair o){
               return t.end - o.end;
           }
       });
       
       int count = 0,next = 0;
       for(int i = 0; i<n;i++){
           if(pairs[i].start > next){
               count++;
               next = pairs[i].end;
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
