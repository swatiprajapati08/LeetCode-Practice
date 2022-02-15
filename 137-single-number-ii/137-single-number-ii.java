class Solution {
    public int singleNumber(int[] nums) {
        // 3 x + 1  = n
        int ans = 0;
        for(int i = 0;i< 32;i++){
            int sum = 0;
            for(int j = 0; j< nums.length;j++){
                //count the no. of bits equal to 1 for ith bit
                if(((nums[j] >> i) & 1) == 1)
                    sum++;
            }
            sum %= 3;
            
            if(sum != 0)
                ans |= sum << i; //set 1 at ith bit
        }
        return ans;
    }
}