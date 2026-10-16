
class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] sum;
    private long[] sq;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];
            last[nums[i]] = i + 1;

            update(1, 0, n - 1, prev, i);

            ans = (ans + sq[1]) % MOD;
        }

        return (int) ans;
    }

    private void apply(int node, int l, int r, long x) {
        long len = r - l + 1L;

        // Update sum of squares using the OLD sum.
        sq[node] = (sq[node]
                + 2L * x % MOD * sum[node] % MOD
                + x * x % MOD * len % MOD) % MOD;

        // Update sum of distinct counts.
        sum[node] = (sum[node] + x * len) % MOD;

        lazy[node] = (lazy[node] + x) % MOD;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] == 0 || l == r) {
            return;
        }

        int mid = (l + r) / 2;

        apply(node * 2, l, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, r, lazy[node]);

        lazy[node] = 0;
    }

    private void update(int node, int l, int r,
                        int ql, int qr) {
        if (ql > r || qr < l) {
            return;
        }

        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }

        push(node, l, r);

        int mid = (l + r) / 2;

        update(node * 2, l, mid, ql, qr);
        update(node * 2 + 1, mid + 1, r, ql, qr);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}
