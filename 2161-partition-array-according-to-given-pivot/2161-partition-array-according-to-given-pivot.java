class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        int pivotCount = 0;
        int lessCount = 0;

        for (int num : nums) {
            if (num < pivot) lessCount++;
            else if (num == pivot) pivotCount++;
        }

        int lessIdx = 0;
        int equalIdx = lessCount;
        int greaterIdx = lessCount + pivotCount;

        for (int num : nums) {
            if (num < pivot) {
                result[lessIdx++] = num;
            } else if (num == pivot) {
                result[equalIdx++] = num;
            } else {
                result[greaterIdx++] = num;
            }
        }

        return result;
    }
}