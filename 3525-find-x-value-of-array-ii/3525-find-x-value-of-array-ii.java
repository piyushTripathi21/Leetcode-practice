class Solution {

    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            cnt = new int[k];
        }
    }

    int n;
    int k;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            
            update(1, 0, n - 1, index, value);

            
            Node res = query(1, 0, n - 1, start, n - 1);

            ans[q] = res.cnt[x];
        }

        return ans;
    }

   

    private void build(int node, int l, int r, int[] nums) {

        tree[node] = new Node(k);

        if (l == r) {

            int value = nums[l] % k;

            tree[node].prod = value;

        
            tree[node].cnt[value] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

 

    private Node merge(Node left, Node right) {

        Node res = new Node(k);

        
        res.prod = (int) ((long) left.prod * right.prod % k);

        for (int r = 0; r < k; r++) {
            res.cnt[r] += left.cnt[r];
        }

     
        for (int r = 0; r < k; r++) {

            int newRemainder = (int) ((long) left.prod * r % k);

            res.cnt[newRemainder] += right.cnt[r];
        }

        return res;
    }

   

    private void update(int node, int l, int r, int index, int value) {

        if (l == r) {

            value %= k;

            tree[node] = new Node(k);

            tree[node].prod = value;
            tree[node].cnt[value] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    

    private Node query(int node, int l, int r, int ql, int qr) {

       
        if (r < ql || l > qr) {
            return null;
        }

      
        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return merge(left, right);
    }
}