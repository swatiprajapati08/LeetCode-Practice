class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i:people){
            if(i >= limit) count++;
            else{
                arr.add(i);
            }
        }
        Collections.sort(arr);
        int l = 0, r = arr.size() - 1;
        while(l <= r){
            if(arr.get(l) + arr.get(r) > limit){
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