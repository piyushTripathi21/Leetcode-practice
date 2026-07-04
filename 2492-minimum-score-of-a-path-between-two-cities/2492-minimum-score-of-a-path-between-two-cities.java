
class Solution {
    private void dfs(Map<Integer, List<int[]>> adj, int node, boolean[] visited, int[] result) {
        visited[node] = true;

        for (int[] edge : adj.getOrDefault(node, new ArrayList<>())) {
            int next = edge[0];
            int dist = edge[1];

            result[0] = Math.min(result[0], dist);

            if (!visited[next]) {
                dfs(adj, next, visited, result);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, d});
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, d});
        }

        boolean[] visited = new boolean[n + 1];
        int[] result = {Integer.MAX_VALUE};

        dfs(adj, 1, visited, result);

        return result[0];
    }
}