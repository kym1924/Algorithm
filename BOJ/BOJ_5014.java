import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {

	static int F, S, G, U, D;
	static int answer = Integer.MAX_VALUE;
	static Queue<UpDown> q = new LinkedList<>();
	static boolean[] visited;

	static class UpDown {
		int now;
		int count;

		UpDown(int now, int count) {
			this.now = now;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new boolean[F + 1];
		bfs();
	}

	static void bfs() {
		q.add(new UpDown(S, 0));
		visited[S] = true;

		while (!q.isEmpty()) {
			UpDown now = q.poll();
			if (now.now == G) {
				answer = Math.min(answer, now.count);
			}
			if (now.now + U <= 1000000 && !visited[now.now + U]) {
				visited[now.now + U] = true;
				q.add(new UpDown(now.now + U, now.count + 1));
			}
			if (now.now - D >= 0 && !visited[now.now - D]) {
				visited[now.now - D] = true;
				q.add(new UpDown(now.now - D, now.count + 1));
			}
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.print("use the stairs");
		} else {
			System.out.print(answer);
		}
	}
}
