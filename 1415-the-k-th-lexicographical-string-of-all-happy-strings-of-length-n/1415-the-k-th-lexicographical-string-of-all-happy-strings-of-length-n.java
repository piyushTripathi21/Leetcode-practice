class Solution {

    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        char[] chars = {'a', 'b', 'c'};
        
        backtrack("", n, chars, list);
        
        if (k > list.size()) return "";
        return list.get(k - 1);
    }

    private void backtrack(String curr, int n, char[] chars, List<String> list) {
        if (curr.length() == n) {
            list.add(curr);
            return;
        }

        for (char c : chars) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == c)
                continue;

            backtrack(curr + c, n, chars, list);
        }
    }
}
