class TreeAncestor {

    int[][] up;
    int LOG;

    public TreeAncestor(int n, int[] parent) {

        LOG = 20; // since n <= 5 * 10^4

        up = new int[n][LOG];

        // 2^0 ancestor
        for(int i = 0; i < n; i++)
            up[i][0] = parent[i];

        // Build binary lifting table
        for(int j = 1; j < LOG; j++) {

            for(int i = 0; i < n; i++) {

                if(up[i][j-1] == -1)
                    up[i][j] = -1;
                else
                    up[i][j] = up[up[i][j-1]][j-1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        for(int j = 0; j < LOG; j++) {

            if((k & (1 << j)) != 0) {

                node = up[node][j];

                if(node == -1)
                    return -1;
            }
        }

        return node;
    }
}