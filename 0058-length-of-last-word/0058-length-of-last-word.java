class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();  // for removing extra space we use this fxn
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

        
