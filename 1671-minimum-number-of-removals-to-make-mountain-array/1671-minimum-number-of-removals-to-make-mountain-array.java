class Solution {
    public int minimumMountainRemovals(int[] arr) {
        // LIS from left to right and right to left
       // so for that particular index we are getting increasing R -> L and L -> R
      // for that particular index i  = LISlr[i] + LISrl[i] - 1;
        int n = arr.length;
        int LISlr[] = new int[n];
        
        for(int i = 0; i< n;i++){
            LISlr[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i])
                    LISlr[i] = Math.max(LISlr[j] + 1,LISlr[i]);
            }
        }
        
        // right to left
        int LISrl[] = new int[n];
        for(int i = n - 1; i >=0 ;i--){
            LISrl[i] = 1;
            for(int j = n - 1; j > i; j--){
                if(arr[i] > arr[j])
                    LISrl[i] = Math.max(LISrl[j] + 1, LISrl[i]);
            }
        }
        
       // Longest Bitonic Subsequence with peak at index i
        // = LIS ending at i + LDS starting at i - 1
        // -1 represents the peak element occuring in both LIS and LDS
        // Constraint: LIS > 1 && LDS > 1 (Alteast 1 element to the left of peak
        // and atleast 1 element to the right of peak)
        int maxBitonic = 0;
        for (int i = 0; i < n; i++) {
            int curr = LISlr[i] + LISrl[i] - 1;
            if (LISlr[i] > 1 && LISrl[i] > 1) {
                maxBitonic = Math.max(maxBitonic, curr);
            }
        }

        return n - maxBitonic; 
    }
}