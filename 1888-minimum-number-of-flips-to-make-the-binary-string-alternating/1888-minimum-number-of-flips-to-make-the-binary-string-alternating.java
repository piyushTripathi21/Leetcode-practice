//Approach-1 (Sliding Window + modifying input s = s+s)
//T.C : O(2*n) ~= O(n)
//S.C : O(2*n) for s1 and s2 and s+=s
class Solution {
    public int minFlips(String s) {

        int n = s.length();
        s = s + s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(int i = 0; i < 2*n; i++) {
            s1.append(i % 2 == 1 ? '0' : '1');
            s2.append(i % 2 == 1 ? '1' : '0');
        }

        int i = 0, j = 0;
        int result1 = 0, result2 = 0;
        int result = Integer.MAX_VALUE;

        while(j < 2*n) {

            if(s.charAt(j) != s1.charAt(j)) result1++;
            if(s.charAt(j) != s2.charAt(j)) result2++;

            
            if(j - i + 1 > n) {
                if(s.charAt(i) != s1.charAt(i)) result1--;
                if(s.charAt(i) != s2.charAt(i)) result2--;
                i++;
            }

            // window size n
            if(j - i + 1 == n)
                result = Math.min(result, Math.min(result1, result2));

            j++;
        }

        return result;
    }
}


