class Solution {
    static class Edge{
        int src;
        int dst;
        int wt;
        public Edge(int s, int d, int wt){
            this.src=s;
            this.dst=d;
            this.wt=wt;
        }
    }
    
    static class Info{
        int v;
        int cost;
        int stop;

        public Info(int v, int c, int s){
            this.v=v;
            this.cost=c;
            this.stop=s;
        }
    }


    public static void creategrph(int [][] flights, ArrayList<Edge> graph[]){


        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int dst= flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src,dst,wt);
            graph[src].add(e);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<Edge> graph[] = new ArrayList[n];
        creategrph(flights,graph);

        int dist []= new int[n];
        for(int i=0;i<n;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
         q.add(new Info(src,0,0));

         while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stop>k){
                break;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e = graph[curr.v].get(i);
                int u= e.src;
                int v=e.dst;
                int wt = e.wt;

                if(curr.cost + wt <dist[v] && curr.stop<=k){
                    dist[v]=curr.cost + wt;
                    q.add(new Info(v,dist[v],curr.stop +1));
                }
            }
         }

         if(dist[dst]==Integer.MAX_VALUE){
            return -1;
         }else{
            return dist[dst];
         }
    }
}