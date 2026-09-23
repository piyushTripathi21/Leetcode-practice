class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        long total = 0;

        for (int num : nums) {
            total += num;
        }

        long target = total - x;

        // If target < 0, impossible
        if (target < 0) {
            return -1;
        }

        // If target == 0, we need to remove every element
        if (target == 0) {
            return n;
        }

        int left = 0;
        long sum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Shrink window if sum becomes too large
            while (left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }

            // Found a subarray with sum = target
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        if (maxLen == -1) {
            return -1;
        }

        return n - maxLen;
    }
}