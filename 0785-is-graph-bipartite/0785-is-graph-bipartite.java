class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;

        int[] color = new int[n];

        Arrays.fill(color, -1);

        for(int start =0;start<n;start++){
            if(color[start]!=-1){
                continue;
            }

            Queue<Integer> q = new LinkedList<> ();

            color[start] =0;
            q.offer(start);

            while(!q.isEmpty()){
                int node = q.poll();

                for(int neighbor:graph[node]){
                    if(color[neighbor] ==-1){
                        color[neighbor] = 1-color[node];
                        q.offer(neighbor);
                    }

                    else if(color[neighbor] == color[node]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}