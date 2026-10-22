
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int pos0 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos0 = i;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        // Case 1: Sorted by cyclic rotation
        boolean valid = true;

        for (int i = 0; i < n; i++) {
            if (nums[(pos0 + i) % n] != i) {
                valid = false;
                break;
            }
        }

        if (valid) {
            ans = Math.min(pos0, n - pos0 + 2);
        }

        // Case 2: Sorted by reversed cyclic rotation
        int r = (n - 1 - pos0 + n) % n;
        valid = true;

        for (int i = 0; i < n; i++) {
            int idx = (n - 1 - ((i + r) % n) + n) % n;

            if (nums[idx] != i) {
                valid = false;
                break;
            }
        }

        if (valid) {
            ans = Math.min(ans, Math.min(r + 1, n - r + 1));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
