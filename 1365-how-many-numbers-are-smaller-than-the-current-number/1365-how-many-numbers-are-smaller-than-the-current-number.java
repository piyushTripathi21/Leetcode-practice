import java.util.*;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int n = nums.length;
        int[] sorted = nums.clone();
        int[] result = new int[n];
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], i);
            }
        }
        for (int i = 0; i < n; i++) {
            result[i] = map.get(nums[i]);
        }

        return result;
    }
}
