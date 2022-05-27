class Solution {
    public int wiggleMaxLength(int[] nums) {
        int inc[] = new int[nums.length];
        int dec[] = new int[nums.length];
        Arrays.fill(inc,1);
        Arrays.fill(dec,1);
        int max = 0;
        
        for(int i = 0; i < nums.length;i++){
            // explore all its choice
            for(int j = 0; j < i;j++){
                
                if(nums[j] > nums[i])
                    // we are decreasing
                    dec[i] = Math.max(inc[j] + 1,dec[i]);
                else if(nums[j] < nums[i])
                    // we are increasing
                    inc[i] = Math.max(inc[j],dec[j] + 1);
               
            }
             max = Math.max(max,Math.max(inc[i], dec[i]));
        }
        return max;
    }
}