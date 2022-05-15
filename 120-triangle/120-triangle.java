class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        //last row to same hi hoga
        for(int i = row - 2;i >= 0;i--){
            // traverse row
            for(int j = 0; j<triangle.get(i).size();j++){
                int same = triangle.get(i + 1).get(j);
                int right = triangle.get(i + 1).get(j + 1);
                int val = Math.min(same,right) + triangle.get(i).get(j);
                triangle.get(i).set(j,val);
            }
        }
        return triangle.get(0).get(0);
    }
}