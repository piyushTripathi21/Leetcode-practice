class Solution {
    public int romanToInt(String s) {

        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {

            int curr = value(s.charAt(i));

            if (i < n - 1 && curr < value(s.charAt(i + 1))) {
                result -= curr;   
            } else {
                result += curr;   
            }
        }

        return result;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
