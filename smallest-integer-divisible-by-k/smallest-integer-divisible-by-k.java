class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0)
            return -1;
        //make up all digit
        int r = 0;
        for(int N = 1; N <= k;N++){
            
            r = (r * 10 + 1) % k;
            if(r == 0)
                return N;
        }
      return -1;
    }
}