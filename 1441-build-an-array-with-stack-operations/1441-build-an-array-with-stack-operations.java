class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();

        int index = 0;

        for(int num = 1; num <= n; num++) {
            operations.add("Push");

            if ( index < target.length && num == target[index]) {
                index++;
            }else{
                operations.add("Pop");
            }

            if( index == target.length) {
                break;
            }
        }

        return operations;

    }
}