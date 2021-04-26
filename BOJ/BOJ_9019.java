import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {

	static class DSLR {
		int a;
		String DSLR;

		DSLR(int a, String DSLR) {
			this.a = a;
			this.DSLR = DSLR;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			Queue<DSLR> q = new LinkedList<>();
			boolean[] visited = new boolean[10000];
			visited[A] = true;
			q.add(new DSLR(A, ""));

			while (!q.isEmpty()) {
				DSLR now = q.poll();
				if (now.a == B) {
					bw.write(now.DSLR + "\n");
					break;
				}
				if (!visited[now.a * 2 % 10000]) {
					visited[now.a * 2 % 10000] = true;
					q.add(new DSLR(now.a * 2 % 10000, now.DSLR + "D"));
				}
				if (!visited[now.a == 0 ? 9999 : now.a - 1]) {
					visited[now.a == 0 ? 9999 : now.a - 1] = true;
					q.add(new DSLR(now.a == 0 ? 9999 : now.a - 1, now.DSLR + "S"));
				}
				if (!visited[now.a % 1000 * 10 + now.a / 1000]) {
					visited[now.a % 1000 * 10 + now.a / 1000] = true;
					q.add(new DSLR(now.a % 1000 * 10 + now.a / 1000, now.DSLR + "L"));
				}
				if (!visited[now.a % 10 * 1000 + now.a / 10]) {
					visited[now.a % 10 * 1000 + now.a / 10] = true;
					q.add(new DSLR(now.a % 10 * 1000 + now.a / 10, now.DSLR + "R"));
				}
			}
		}

		bw.flush();
		bw.close();
	}
}
