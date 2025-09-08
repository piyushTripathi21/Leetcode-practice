import java.util.Stack;

class Solution {
    public void reverseString(char[] s) {
        Stack<Character> S = new Stack<>();   
        int idx = 0;

        while(idx < s.length){                
            S.push(s[idx]);                  
            idx++;
        }
        idx = 0;
        while(!S.isEmpty()){
            s[idx] = S.pop();                 
            idx++;
        }
    }
}
