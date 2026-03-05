class Solution {
    public int minOperations(String s) {

        int prev = 0;
        int count = 0;
        int n = s.length();

        for(int i =0; i <s.length(); i++){
            int bit = s.charAt(i) - '0';
            if(bit == prev){
                bit = 1 - prev;
                count++;
            }
            prev = bit;
        }
        return Math.min(n-count, count);
    }
}