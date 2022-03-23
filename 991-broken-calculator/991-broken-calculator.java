class Solution {
    public int brokenCalc(int startValue, int target) {
        // do it in opposite ways
        // make the target to startValue as target -> sv can go upto expoential
        int ans = 0;
        while(target > startValue){
            if(target % 2 == 0)
                target /= 2;
            else
                target++;
            ans++;
        }
        return ans + (startValue - target);
    }
}