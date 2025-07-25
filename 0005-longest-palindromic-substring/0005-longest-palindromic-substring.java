class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String result = "";
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > maxLength) {
                    result = sub;
                    maxLength = sub.length();
                }
            }
        }

        return result;
    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}


