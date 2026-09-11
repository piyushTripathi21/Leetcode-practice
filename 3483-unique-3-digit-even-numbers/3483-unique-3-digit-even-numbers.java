class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Store frequency of each digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        // Hundreds place: 1-9 (cannot be 0)
        for (int i = 1; i <= 9; i++) {

            if (freq[i] == 0) {
                continue;
            }

            freq[i]--;

            // Tens place: 0-9
            for (int j = 0; j <= 9; j++) {

                if (freq[j] == 0) {
                    continue;
                }

                freq[j]--;

                // Units place: only even digits
                for (int k = 0; k <= 8; k += 2) {

                    if (freq[k] > 0) {
                        count++;
                    }
                }

                freq[j]++;
            }

            freq[i]++;
        }

        return count;
    }
}