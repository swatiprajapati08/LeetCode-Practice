class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1)
            return 1;
        int ptr[] = new int[primes.length];
        Arrays.fill(ptr,1);
        int ugly[] = new int[n+1];
        ugly[1] = 1;
        
         for(int i = 2;i<=n;i++){
             int min = Integer.MAX_VALUE;
             for(int p = 0; p < primes.length;p++)
                 min = Math.min(min,ugly[ptr[p]] * primes[p]);
             ugly[i] = min;
             for(int p = 0; p < primes.length;p++){
                  if(min == ugly[ptr[p]] * primes[p]) ptr[p]++;
              }
         }
        return ugly[n];
    }
}