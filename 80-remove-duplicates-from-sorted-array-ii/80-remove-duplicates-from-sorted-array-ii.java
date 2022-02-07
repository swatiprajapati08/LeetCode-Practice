class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0,k =0;
        while(j < nums.length){
            int temp = nums[j];
            int count = 0;
            while(j < nums.length && temp == nums[j]){
                count++;
                j++;
            }
            nums[k++] = temp;
            if(count > 1)
            nums[k++] = temp;
        }
       return k; 
    }
}