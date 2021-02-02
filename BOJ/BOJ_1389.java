import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389_김영민 {

	static int N;
	static int M;
	static int[] connect;
	static int[][] relationShip;
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] result = new int[N + 1];

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		connect = new int[N + 1];
		relationShip = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			relationShip[from][to] = 1;
			relationShip[to][from] = 1;
		}

		for (int i = 1; i < N + 1; i++) {
			result[i] = bfs(i);
			for (int j = 1; j <= N; j++) {
				connect[j] = 0;
				visited[j] = false;
			}
		}

		result(result);
	}

	static int bfs(int now) {
		int sum = 0;

		q.add(now);
		visited[now] = true;

		while (!q.isEmpty()) {
			int check = q.poll();
			for (int i = 1; i < N + 1; i++) {
				if (relationShip[check][i] == 1 && !visited[i]) {
					visited[i] = true;
					connect[i] += connect[check] + 1;
					q.add(i);
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			sum += connect[i];
		}

		return sum;
	}

	static void result(int[] result) {
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 1; i < N + 1; i++) {
			if (result[i] < min) {
				min = result[i];
				answer = i;
			}
		}
		System.out.print(answer);
	}
}
