var minOperations = function(nums, x) {
    let total = nums.reduce((sum, num) => sum + num, 0);
    let target = total - x;

    // If target is negative, impossible
    if (target < 0) {
        return -1;
    }

    // If target is 0, remove all elements
    if (target === 0) {
        return nums.length;
    }

    let left = 0;
    let windowSum = 0;
    let maxLength = -1;

    for (let right = 0; right < nums.length; right++) {
        windowSum += nums[right];

        // Shrink window if sum becomes too large
        while (windowSum > target) {
            windowSum -= nums[left];
            left++;
        }

        // Found a subarray with sum = target
        if (windowSum === target) {
            maxLength = Math.max(maxLength, right - left + 1);
        }
    }

    return maxLength === -1 ? -1 : nums.length - maxLength;
};