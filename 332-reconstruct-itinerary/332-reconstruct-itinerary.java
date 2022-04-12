class Solution {
    LinkedList<String> ans;
    HashMap<String,PriorityQueue<String>> map;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        ans = new LinkedList<>();
        
        for(List<String> t : tickets){
            String src = t.get(0);
            String dest = t.get(1);

            if(!map.containsKey(src))
               map.put(src,new PriorityQueue<String>());
            map.get(src).add(dest);
        }

        dfs("JFK");
        return ans;
    }
    
    void dfs(String src){
        PriorityQueue<String> nbr = map.get(src);
        while(nbr != null && nbr.size() > 0){
            String n = nbr.remove();
            dfs(n);
        }
        ans.addFirst(src);
    }
}