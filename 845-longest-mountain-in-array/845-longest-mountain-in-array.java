class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        
        for(int i = 1; i < n; i++){
            if(arr[i - 1] < arr[i])
                left[i] = Math.max(left[i - 1] + 1,left[i]);
        }
        
         for(int i = n - 2; i >= 0; i--){
            if(arr[i + 1] < arr[i])
                right[i] = Math.max(right[i + 1] + 1,right[i]);
        }
        
        
        int max = 0;
        for(int i = 0; i < n;i++){
            int curr = left[i] + right[i] - 1;
            if(left[i] > 1 && right[i] > 1)
                max = Math.max(max,curr);
        }
        return max;
    }
}