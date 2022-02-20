class Solution {
    public int countEven(int num) {
        int count = 0;
        for(int i = 2; i <= num;i++){
            if(sumEven(i) % 2 == 0)
                count++;
        }
        return count;
    }
    int sumEven(int n){
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}