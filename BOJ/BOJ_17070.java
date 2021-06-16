import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {

	static int N;
	static int[][] map;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);
		System.out.print(count);
	}

	static void dfs(int x, int y, int direction) {
		if (x == N - 1 && y == N - 1) {
			count++;
		}
		if (direction == 0) {
			if (y + 1 < N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
			if (x + 1 < N && y + 1 < N) {
				if (map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
					dfs(x + 1, y + 1, 2);
				}
			}
		} else if (direction == 1) {
			if (x + 1 < N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
			if (x + 1 < N && y + 1 < N) {
				if (map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
					dfs(x + 1, y + 1, 2);
				}
			}
		} else if (direction == 2) {
			if (y + 1 < N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
			if (x + 1 < N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
			if (x + 1 < N && y + 1 < N) {
				if (map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
					dfs(x + 1, y + 1, 2);
				}
			}
		}
	}
}