class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int leftMax = 0,rightMax = 0;
        int left = 0, right = n - 1,water = 0;
        while(left < right){
            if(arr[left] > leftMax) leftMax = arr[left];
            if(arr[right] > rightMax) rightMax = arr[right];
            if(leftMax < rightMax){
                water += (leftMax - arr[left]);
                left++;
            }
            else{
                water += (rightMax - arr[right]);
                right--;
            }
        }
        return water;
    }
}