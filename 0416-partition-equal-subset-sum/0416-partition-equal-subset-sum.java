class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return subsetSum(nums, sum / 2, nums.length);
    }

    boolean subsetSum(int[] arr, int sum, int n) {

        boolean[][] t = new boolean[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }

        for (int j = 1; j <= sum; j++) {
            t[0][j] = false;
        }

        // DP
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]]
                           || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }
}