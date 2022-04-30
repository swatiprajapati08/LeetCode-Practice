class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        int ugly[] = new int[n+1];
        ugly[1] = 1;
        int ptr2 = 1;
        int ptr3 = 1;
        int ptr5 = 1;
        for(int i = 2;i<=n;i++){
            int a = ugly[ptr2] * 2;
            int b = ugly[ptr3] * 3;
            int c = ugly[ptr5] * 5;
            int min = Math.min(a,Math.min(b,c));
            ugly[i] = min;
            
            if(min == a) ptr2++;
            if(min == b) ptr3++;
            if(min == c) ptr5++;
        }
        
        return ugly[n];
    }
}