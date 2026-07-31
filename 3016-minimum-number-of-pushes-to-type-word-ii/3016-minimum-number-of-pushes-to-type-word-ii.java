import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {

        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int result = 0;
        int index = 0;


        for (int i = 25; i >= 0; i--) {
            int presses = (index / 8) + 1;
            result += presses * freq[i];
            index++;
        }

        return result;
    }
}