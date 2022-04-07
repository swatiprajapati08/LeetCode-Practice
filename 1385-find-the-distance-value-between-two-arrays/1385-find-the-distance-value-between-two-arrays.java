class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
       
        Arrays.sort(arr2);
        int count = 0;
        for(int i:arr1){
            boolean flag = false;
            int low = 0,high = arr2.length - 1;
            while(low <= high){
                int mid = low +(high - low)/2;
                if(Math.abs(arr2[mid] - i) <= d){
                    flag = true;
                    break;
                }else if(arr2[mid] < i)
                    low = mid + 1;
                else
                    high = mid - 1;
                
            }
            if(!flag)
                count++;
        }
        return count;
    }
}