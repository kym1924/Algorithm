import java.util.ArrayList;

class Solution {

	static boolean[] visited;
	static ArrayList<ArrayList<Edge>> edge = new ArrayList<>();
	static ArrayList<Integer> list = new ArrayList<>();

	static class Edge {
		int next;
		int weight;

		Edge(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
	}

	public int solution(int N, int[][] road, int K) {
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			edge.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < road.length; i++) {
			edge.get(road[i][0]).add(new Edge(road[i][1], road[i][2]));
			edge.get(road[i][1]).add(new Edge(road[i][0], road[i][2]));
		}

		list.add(1);
		visited[1] = true;
		dfs(1, 0, K);

		return list.size();
	}

	public static void dfs(int now, int weight, int K) {
		for (int i = 0; i < edge.get(now).size(); i++) {
			int next = edge.get(now).get(i).next;
			int nextWeight = edge.get(now).get(i).weight;
			if (!visited[next]) {
				if (weight + nextWeight <= K) {
					if (!list.contains(next)) {
						list.add(next);
					}
					visited[next] = true;
					dfs(next, weight + nextWeight, K);
					visited[next] = false;
				}
			}
		}
	}
}