import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {

	static int N, M;
	static int result = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] offsetX = { 0, -1, 0, 1 };
	static int[] offsetY = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 0, 0);
				otherBlock(i, j);
				visited[i][j] = false;
			}
		}
		System.out.print(result);
	}

	static void dfs(int x, int y, int depth, int sum) {
		if (depth == 4) {
			result = Math.max(result, sum);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int tempX = x + offsetX[k];
			int tempY = y + offsetY[k];
			if (tempX >= 0 && tempY >= 0 && tempX < N && tempY < M && !visited[tempX][tempY]) {
				visited[tempX][tempY] = true;
				dfs(tempX, tempY, depth + 1, sum + map[x][y]);
				visited[tempX][tempY] = false;
			}
		}
	}

	static void otherBlock(int x, int y) {
		if (x < N && y + 2 < M && x - 1 >= 0 && y >= 0) {
			result = Math.max(result, map[x][y] + map[x][y + 1] + map[x - 1][y + 1] + map[x][y + 2]);
		}
		if (x + 2 < N && y + 1 < M && x >= 0 && y >= 0) {
			result = Math.max(result, map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 2][y]);
		}
		if (x + 1 < N && y + 2 < M && x >= 0 && y >= 0) {
			result = Math.max(result, map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x][y + 2]);
		}
		if (x + 2 < N && y < M && x >= 0 && y - 1 >= 0) {
			result = Math.max(result, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y - 1]);
		}
	}
}
