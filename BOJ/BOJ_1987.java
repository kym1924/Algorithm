import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {

	static int R, C;
	static int answer = Integer.MIN_VALUE;
	static char[][] board;
	static boolean[] visited = new boolean[26];
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, 1);
		System.out.print(answer);
	}

	static void dfs(int x, int y, int count) {
		visited[board[x][y] - 65] = true;

		if (answer < count) {
			answer = count;
		}

		for (int i = 0; i < 4; i++) {
			int tempX = x + offsetX[i];
			int tempY = y + offsetY[i];
			if (tempX >= 0 && tempX < R && tempY >= 0 && tempY < C) {
				if (!visited[board[tempX][tempY] - 65]) {
					visited[board[tempX][tempY] - 65] = true;
					dfs(tempX, tempY, count + 1);
					visited[board[tempX][tempY] - 65] = false;
				}
			}
		}
	}
}
