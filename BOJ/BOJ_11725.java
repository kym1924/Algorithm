import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_11725 {

	static int N;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[] result;
	static boolean[] visited;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			tree.get(child).add(parent);
			tree.get(parent).add(child);
		}
		
		dfs(1);
		print();
	}

	static void dfs(int now) {
		visited[now] = true;
		for (int i = 0; i < tree.get(now).size(); i++) {
			int nextCheck = tree.get(now).get(i);
			if (!visited[nextCheck]) {
				result[nextCheck] = now;
				dfs(nextCheck);
			}
		}
	}

	static void print() {
		for (int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
}