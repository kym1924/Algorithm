import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16397 {

	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	static class Push {
		int n;
		int count;

		Push(int n, int count) {
			this.n = n;
			this.count = count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());

		if (N > G) {
			System.out.print("ANG");
			return;
		} else {
			visited = new boolean[100000];
			bfs(N, T, G);
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.print("ANG");
		} else {
			System.out.print(answer);
		}
	}

	static void bfs(int N, int T, int G) {
		Queue<Push> q = new LinkedList<>();
		q.add(new Push(N, 0));
		visited[N] = true;

		while (!q.isEmpty()) {
			Push push = q.poll();
			int nowN = push.n;
			int nowCount = push.count;

			if (nowCount > T) {
				break;
			}

			if (nowN == G) {
				answer = Math.min(answer, nowCount);
				break;
			}

			if (nowN + 1 <= 99999 && !visited[nowN + 1]) {
				visited[nowN + 1] = true;
				q.add(new Push(nowN + 1, nowCount + 1));
			}

			if (nowN * 2 > 99999) {
				continue;
			} else {
				int pushB = pushB(nowN * 2);
				if (pushB <= 99999 && !visited[pushB]) {
					visited[pushB] = true;
					q.add(new Push(pushB, nowCount + 1));
				}
			}
		}
	}

	static int pushB(int N) {
		int length = (int) Math.log10(N);
		N -= Math.pow(10, length);
		return N;
	}
}