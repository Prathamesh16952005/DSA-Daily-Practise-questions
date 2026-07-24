class Solution {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int [] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i = 0; i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
           graph.get(pre[1]).add(pre[0]);
        }

        visited = new int[numCourses];

        for(int i=0; i<numCourses;i++){
            if(dfs(i)){
                return false;
            }
        }
        return true;


        
    }
     private boolean dfs(int node){
            if(visited[node]==1)
            return true;

            if(visited[node] ==2)
            return false;

            visited[node]=1;

            for(int next:graph.get(node)){
                if(dfs(next))
                return true;
            }
             
             visited[node] =2;
             return false;
        }
}