
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m = queries.length;
        int[] ans = new int[m];

        // Step 1: Sort logs by request time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Store queries with their original indices
        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Maintain server request counts
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        // Number of servers receiving at least one request
        int activeServers = 0;

        // Step 4: Process queries in sorted order
        for (int[] query : sortedQueries) {

            int time = query[0];
            int index = query[1];

            int start = time - x;

            // Add logs with time <= query time
            while (right < logs.length &&
                   logs[right][1] <= time) {

                int server = logs[right][0];

                map.put(server, map.getOrDefault(server, 0) + 1);

                if (map.get(server) == 1) {
                    activeServers++;
                }

                right++;
            }

            // Remove logs with time < start
            while (left < right &&
                   logs[left][1] < start) {

                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                    activeServers--;
                }

                left++;
            }

            // Servers without requests
            ans[index] = n - activeServers;
        }

        return ans;
    }
}
