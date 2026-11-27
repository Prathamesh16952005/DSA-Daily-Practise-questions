class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] value = new int[n];

        // Calculate the benefit of each item
        for (int i = 0; i < n; i++) {
            int freeCopies = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    freeCopies++;
                }
            }

            value[i] = 1 + freeCopies;
        }

        // 0/1 Knapsack
        int[] dp = new int[budget + 1];

        java.util.Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int benefit = value[i];

            for (int c = budget; c >= price; c--) {
                if (dp[c - price] != -1) {
                    dp[c] = Math.max(
                        dp[c],
                        dp[c - price] + benefit
                    );
                }
            }
        }

        // Calculate maximum total copies
        int answer = 0;

        for (int c = 0; c <= budget; c++) {
            if (dp[c] != -1) {
                int extra = (budget - c) / minPrice;

                answer = Math.max(
                    answer,
                    dp[c] + extra
                );
            }
        }

        return answer;
    }
}