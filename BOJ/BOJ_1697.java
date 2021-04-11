import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_1697 {

	static int N, K;
	static int answer = Integer.MAX_VALUE;
	static Queue<Move> q = new LinkedList<>();
	static boolean[] visited;

	static class Move {
		int location;
		int count;

		Move(int location, int count) {
			this.location = location;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		bfs();
		System.out.print(answer);
	}

	static void bfs() {
		q.add(new Move(N, 0));
		visited[N] = true;

		while (!q.isEmpty()) {
			Move now = q.poll();
			if (now.location == K) {
				answer = Math.min(answer, now.count);
			}
			if (now.location + 1 <= 100000 && !visited[now.location + 1]) {
				q.add(new Move(now.location + 1, now.count + 1));
				visited[now.location + 1] = true;
			}
			if (now.location - 1 >= 0 && !visited[now.location - 1]) {
				q.add(new Move(now.location - 1, now.count + 1));
				visited[now.location - 1] = true;
			}
			if (now.location * 2 <= 100000 && !visited[now.location * 2]) {
				q.add(new Move(now.location * 2, now.count + 1));
				visited[now.location * 2] = true;
			}
		}
	}
}