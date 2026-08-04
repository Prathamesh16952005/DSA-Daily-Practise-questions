import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find minimum and maximum
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Find missing numbers
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}