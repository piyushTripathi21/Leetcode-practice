class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];
        long[] dp = new long[k];
        long[] ndp = new long[k];

        for (int x : nums) {

           
            java.util.Arrays.fill(ndp, 0);

           
            ndp[x % k]++;

           
            for (int r = 0; r < k; r++) {
                if (dp[r] != 0) {
                    int newRemainder = (r * (x % k)) % k;
                    ndp[newRemainder] += dp[r];
                }
            }

            // Every subarray ending here
            for (int r = 0; r < k; r++) {
                ans[r] += ndp[r];
            }

            dp = ndp.clone();
        }

        return ans;
    }
}