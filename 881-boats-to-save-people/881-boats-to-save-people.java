class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        int count = 0;
        // ArrayList<Integer> arr = new ArrayList<>();
        // for(int i:people){
        //     if(i >= limit) count++;
        //     else{
        //         arr.add(i);
        //     }
        // }
        //no need to do the upper part as it has been already taken care of
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while(l <= r){
            if(arr[l] + arr[r] > limit){
                count++;
                r--;
            }else{
                l++;
                r--;
                count++;
            }
        }
       
        return count;
    }
}