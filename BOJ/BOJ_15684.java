import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15684 {

	static int N, H;
	static int[][] map;
	static boolean success = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[a][b + 1] = 2;
		}

		for (int i = 0; i <= 3; i++) {
			dfs(1, 0, i);
			if (success) {
				bw.write(String.valueOf(i));
				break;
			}
		}
		if (!success) {
			bw.write(String.valueOf(-1));
		}
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int count, int answer) {
		if (success || count> 3) {
			return;
		}

		if (answer == count) {
			if (ladder()) {
				success = true;
				return;
			}
		}
		for (int i = x; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					map[i][j + 1] = 2;
					dfs(i, count + 1, answer);
					map[i][j] = 0;
					map[i][j + 1] = 0;
				}
			}
		}
	}

	static boolean ladder() {
		for (int i = 1; i <= N; i++) {
			int y = i;
			for (int j = 1; j <= H; j++) {
				if (map[j][y] == 1) {
					y++;
				} else if (map[j][y] == 2) {
					y--;
				}
			}
			if (y != i) {
				return false;
			}
		}
		return true;
	}
}
