class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) {
                capitalCount++;
            }
        }
        if (capitalCount == word.length() || capitalCount == 0) {
            return true;
        }
        if (capitalCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        return false;
    }
}
