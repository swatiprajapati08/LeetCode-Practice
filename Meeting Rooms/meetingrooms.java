/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {

        //sort the array on basis on end index

        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval thisI,Interval other){
                return thisI.end - other.end;
            }
        });

        for(int i = 1; i < intervals.size();i++){
            if(intervals.get(i - 1).end > intervals.get(i).start)
            return false;
        }
        
        return true;
    }
}
