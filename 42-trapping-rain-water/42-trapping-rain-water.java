class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int leftMax = 0,rightMax = 0;
        int left = 0, right = n - 1,water = 0;
        while(left <= right){
            if(arr[left] <= arr[right]){
                if(arr[left] < leftMax)  water += (leftMax - arr[left]);
                else   leftMax = arr[left];
                    
                left++;
            }else{
                if(arr[right] < rightMax)  water += (rightMax - arr[right]);
                else   rightMax = arr[right];
                right--;
            }
        }
        return water;
    }
}