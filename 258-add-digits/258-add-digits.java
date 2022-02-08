class Solution {
    public int addDigits(int n) {
        while(n > 9){
            int num = n,sum = 0;
            while(num != 0){
                sum += num%10;
                num /= 10;
            }
            n = sum;
        }
        return n;
    }
}