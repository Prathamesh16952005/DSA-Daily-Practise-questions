class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0;i<graph.length;i++){
            graph[i]=new ArrayList<>();

        }

        for(int[] edge:invocations){
            graph[edge[0]].add(edge[1]);

        }

        boolean[] s = new boolean[n];
        Queue<Integer> q =new LinkedList<>();
        q.offer(k);
        s[k]= true;

        while(!q.isEmpty()){
            int curr= q.poll();
            for(int next: graph[curr]){
                if(!s[next]){
                    s[next]=true;
                    q.offer(next);

                }
            }
        }

        for(int[] edge:invocations){
            int from = edge[0];
            int to = edge[1];


            if(!s[from]&& s[to]){
                List<Integer> ans = new ArrayList<>();
                for(int i = 0;i<n;i++){
                    ans.add(i);

                }
                return ans;
            }

        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(!s[i]){
                ans.add(i);

            }
        }
        return ans;
    }
}