class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //topological sort
        int n = numCourses;
        int order[] = new int[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        int indegree[] = new int[n];
        
        for(int i = 0;i< n;i++)
            graph[i] = new ArrayList<Integer>();
        
        //adding the edge
        for(int[] i: prerequisites){
            graph[i[1]].add(i[0]);
            indegree[i[0]]++;
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        
           for(int i = 0; i < n; i++){
               if(indegree[i] == 0)
                   q.add(i);
           }
        
        while(!q.isEmpty()){
            int top = q.poll();
            order[count] = top;
            count++;
            
            for(int u:graph[top]){
                indegree[u]--;
                if(indegree[u] == 0)
                    q.add(u);
            }
            
            
        }
        return count == n ? order : new int[]{};
    }
}