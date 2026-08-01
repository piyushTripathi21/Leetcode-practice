import java.util.Arrays;

class Solution {

    int[][] dp;

    private int maxDiff(int[] nums, int left, int right) {

        if (left == right)
            return nums[left];

        if (dp[left][right] != -1)
            return dp[left][right];

        int takeLeft = nums[left] - maxDiff(nums, left + 1, right);
        int takeRight = nums[right] - maxDiff(nums, left, right - 1);

        return dp[left][right] = Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxDiff(nums, 0, n - 1) >= 0;
    }
}