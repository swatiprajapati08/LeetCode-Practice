class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        // find n
        int max = 0;
        for(int[] e : edges){
            max = Math.max(max,Math.max(e[0],e[1])); 
        }
        for(int i= 0;i<=max;i++)
            arr.add(new ArrayList<Integer>());
        //add all in list
        for(int[] e: edges){
            arr.get(e[0]).add(e[1]);
            arr.get(e[1]).add(e[0]);
        }

        int maxSize = 0, index = -1;
        for(int i = 0;i<=max;i++){
            if(arr.get(i).size() >= maxSize){
                maxSize = arr.get(i).size();
                index = i;
            }
        }
        return index;
    }
}