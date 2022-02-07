class Solution {
    public int maxArea(int[] arr) {
        int water = 0,val = 0;
        int left = 0, right = arr.length - 1;
        while(left < right){
           
            if(arr[left] < arr[right]){
                val = arr[left] * (right - left); left++;
            }
            else{
                val = arr[right] * (right - left); right--;
             }
            // System.out.println(val);
            water = Math.max(val,water);
        }
        return water;
    }
}