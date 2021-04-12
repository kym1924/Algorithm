import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743 {

	static int N, M, K;
	static int max = 0;
	static int count = 0;
	static int[] offsetX = { 1, 0, -1, 0 };
	static int[] offsetY = { 0, 1, 0, -1 };
	static boolean[][] load = new boolean[101][101];
	static boolean[][] visited = new boolean[101][101];

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			load[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (load[i][j] && !visited[i][j]) {
					count = 0;
					dfs(i, j);
					if (max < count)
						max = count;
				}
			}
		}
		System.out.print(max);
	}

	public static void dfs(int i, int j) {
		count++;
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int tempi = i + offsetX[k];
			int tempj = j + offsetY[k];
			if (tempi >= 1 && tempi <= N && tempj >= 1 && tempj <= M) {
				if (load[tempi][tempj] && !visited[tempi][tempj])
					dfs(tempi, tempj);
			}
		}
	}
}
