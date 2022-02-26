class Solution {
    public int countPrimes(int n) {
       //seieve of erathoses
        boolean primes[] = new boolean[n];
        for(int i = 2; i * i < n;i++){
            if(primes[i] == false){
                for(int j = i * i; j < n; j += i)
                    primes[j] = true;
            }
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(primes[i]==false)
                count++;
        }
        return count;
    }
}