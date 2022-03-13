class Solution {
    private int MOD = 1000000007;
    private long[][] pascal;
    public int numOfWays(int[] nums) {
        if(pascal == null)
            calculatePascal();
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i:nums)
            arr.add(i);
            
        return (int)(noOfWays(arr)) - 1;
    }
    
    long noOfWays(ArrayList<Integer> nums){
        if(nums.size() <= 2)
            return 1;
        
        int root = nums.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for(int i=1;i<nums.size();i++){
            if(root > nums.get(i))
                left.add(nums.get(i));
            else
                right.add(nums.get(i));
        }
        
        return pascal[left.size() + right.size()][left.size()]% MOD * noOfWays(left) % MOD * noOfWays(right) % MOD;
    }
    
    void calculatePascal(){
        pascal = new long[1000][1000];
        for(int i = 0;i<1000;i++){
            for(int j = 0; j<=i;j++){
                if(j == 0 || j == i)
                    pascal[i][j] = 1;
                else
                    pascal[i][j] = (pascal[i - 1][j - 1] + pascal[i - 1][j]) % MOD;
            }
        }
    }
}