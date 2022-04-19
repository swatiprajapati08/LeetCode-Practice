class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
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
            count++;
            for(int u:graph[top]){
                indegree[u]--;
                if(indegree[u] == 0)
                    q.add(u);
            }
            
            
        }
        return count == n ? true : false;
    }
}