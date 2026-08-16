class Solution {
    public boolean stoneGameIX(int[] stones) {
        
        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        int cnt0 = count[0];
        int cnt1 = count[1];
        int cnt2 = count[2];

        
        if (cnt0 % 2 == 0) {
            return cnt1 > 0 && cnt2 > 0;
        }

       
        return Math.abs(cnt1 - cnt2) > 2;
    }
}