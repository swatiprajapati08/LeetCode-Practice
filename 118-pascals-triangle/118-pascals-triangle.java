class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        res.add(temp1);
        for(int i = 1;i<numRows;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 0;j<res.get(i-1).size()-1;j++){
                int ans = res.get(i - 1).get(j) + res.get(i - 1).get(j + 1);
                temp.add(ans);
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}