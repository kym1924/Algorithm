import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1039 {

	static int N, K, length;
	static Queue<Exchange> q = new LinkedList<>();
	static int max = Integer.MIN_VALUE;
	static boolean[][] visited = new boolean[11][1000001];

	static class Exchange {
		int n;
		int count;

		Exchange(int n, int count) {
			this.n = n;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		length = (int) Math.log10(N) + 1;
		bfs(N);

		if (max != Integer.MIN_VALUE) {
			System.out.print(max);
		} else {
			System.out.print(-1);
		}
	}

	static void bfs(int N) {
		q.add(new Exchange(N, 0));
		while (!q.isEmpty()) {
			Exchange now = q.poll();
			int n = now.n;
			int count = now.count;
			if (count == K) {
				max = Math.max(max, n);
			} else {
				for (int i = 0; i < Math.log10(n); i++) {
					for (int j = i + 1; j <= Math.log10(n); j++) {
						int next = change(n, i, j);
						if (next != -1 && !visited[count + 1][next]) {
							visited[count + 1][next] = true;
							q.add(new Exchange(next, count + 1));
						}
					}
				}
			}
		}
	}

	static int change(int n, int i, int j) {
		StringBuilder sb = new StringBuilder(String.valueOf(n));
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		int next = Integer.parseInt(sb.toString());
		if ((int) Math.log10(next) + 1 == length) {
			return next;
		} else {
			return -1;
		}
	}
}
