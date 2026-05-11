import java.util.*;

class Solution {
    public int[] separateDigits(int[] nums) {
        
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {

       
            String str = Integer.toString(num);

          
            for (char ch : str.toCharArray()) {
                list.add(ch - '0');
            }
        }

        
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}