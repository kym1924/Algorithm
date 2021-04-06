import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1167 {

	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
	static boolean[] visited;
	static int answer = Integer.MIN_VALUE;
	static int second = -1;

	static class Edge {
		int to;
		int weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0]);
			for (int j = 1; j < temp.length - 1; j += 2) {
				int to = Integer.parseInt(temp[j]);
				int weight = Integer.parseInt(temp[j + 1]);
				list.get(from).add(new Edge(to, weight));
			}
		}

		dfs(1, 0);
		for (int i = 0; i <= N; i++) {
			visited[i] = false;
		}
		answer = Integer.MIN_VALUE;
		dfs(second, 0);
		System.out.print(answer);
	}

	static void dfs(int now, int weight) {
		visited[now] = true;
		boolean check = false;
		for (int i = 0; i < list.get(now).size(); i++) {
			Edge next = list.get(now).get(i);
			if (!visited[next.to]) {
				visited[next.to] = true;
				dfs(next.to, next.weight + weight);
				check = true;
			}
		}
		if (!check) {
			if (weight > answer) {
				answer = weight;
				second = now;
			}
		}
	}
}