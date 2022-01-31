class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        for(int i = cost.length - 1; i>=0;i-=2){
            sum += cost[i] + (i >= 1 ? cost[i - 1] : 0);
            //skip 
            i--; // 3rd one
        }
        return sum;
    }
}