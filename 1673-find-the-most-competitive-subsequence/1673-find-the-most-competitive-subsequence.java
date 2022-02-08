class Solution {
    public int[] mostCompetitive(int[] num, int k) {
        //same as remove k digit
        k = num.length - k;
         if(num.length == k)
            return null;
        
        Deque<Integer> q = new ArrayDeque<>();
        int reqSize = num.length - k;
        
        for(int i = 0;i<num.length;i++){
        
            while(q.size() > 0 && q.getLast() > num[i] && k > 0){
                q.removeLast();
                k--;
            }
            q.addLast(num[i]);  
        }
        
        // k>0 even though whole string processed
        while(q.size() > 0 && k>0){
            q.removeLast();
            k--;
        }
        
        int arr[] = new int[q.size()];
        int p =0;
        while(q.size() > 0)
            arr[p++] = q.removeFirst();
        
        return arr;
    }
}