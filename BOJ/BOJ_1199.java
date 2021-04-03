import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1199 {

	static int N;
	static int[][] edge;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		edge = new int[N + 1][N + 1];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			int degree = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				edge[i][j] = Integer.parseInt(st.nextToken());
				degree += edge[i][j];
			}
			if (degree % 2 != 0) {
				System.out.print(-1);
				return;
			}
		}
		dfs(1);
		bw.flush();
		bw.close();
	}

	static void dfs(int now) throws Exception {
		for (int i = 1; i <= N; i++) {
			while (edge[now][i] > 0) {
				edge[now][i]--;
				edge[i][now]--;
				dfs(i);
			}
		}
		bw.write(now + " ");
	}
}