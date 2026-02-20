import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {

        int count = 0;          // Used to balance 1's and 0's
        int start = 0;          // Starting index of current special substring
        int n = s.length();     

        List<String> blocks = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '1') {
                count++;        // '1' increases balance
            } else {
                count--;        // '0' decreases balance
            }

            // If count becomes 0 → we found a valid special substring
            if (count == 0) {

                // Extract inner substring (excluding first and last)
                String subProblem = s.substring(start + 1, i);

                // Recursively solve inner substring
                String block = "1" + makeLargestSpecial(subProblem) + "0";

                blocks.add(block);

                start = i + 1;  // Move start to next position
            }
        }

        // Sort in descending order to make lexicographically largest
        Collections.sort(blocks, Collections.reverseOrder());

        // Join all blocks
        StringBuilder ans = new StringBuilder();
        for (String str : blocks) {
            ans.append(str);
        }

        return ans.toString();
    }
}