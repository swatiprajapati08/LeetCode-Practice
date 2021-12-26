class Solution {
    public int candy(int[] arr) {
        int N = arr.length;
        int left[] = new int[N];
       int right[] = new int[N];
       
       //left process
       left[0] = 1;
       for(int i = 1; i< N;i++){
           if(arr[i] > arr[i - 1])
           left[i] = left[i - 1] + 1;
           else
           left[i] = 1;
       }
       
       //right process
       right[N - 1] = 1;
       for(int i = N - 2; i >= 0;i--){
           if(arr[i] > arr[i + 1])
           right[i] = right[i + 1] + 1;
           else
           right[i] = 1;
       }
       
       int sum = 0;
       for(int i = 0;i < N;i++){
           sum += Math.max(left[i],right[i]);
       }
       return sum;
    }
}