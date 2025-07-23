class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            letters[ch - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            letters[ch - 'a']--; 

            if (letters[ch - 'a'] < 0) {
                return false; 
            }
        }

        return true;
    }
}
