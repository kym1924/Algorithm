import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16197 {

	static int N, M;
	static int answer = Integer.MAX_VALUE;
	static char[][] board = new char[21][21];
	static int[] offsetX = { -1, 0, 1, 0 };
	static int[] offsetY = { 0, 1, 0, -1 };
	static Coin[] coins = new Coin[2];

	static class Coin {
		int x;
		int y;

		Coin(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int coinCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'o') {
					coins[coinCount++] = new Coin(i, j);
				}
			}
		}

		dfs(coins[0].x, coins[0].y, coins[1].x, coins[1].y, 0);

		if (answer == Integer.MAX_VALUE || answer > 10) {
			System.out.print(-1);
		} else {
			System.out.print(answer);
		}
	}

	static void dfs(int firstX, int firstY, int secondX, int secondY, int count) {

		if (count > 10) {
			return;
		}

		int tempFirstX, tempFirstY, tempSecondX, tempSecondY;
		boolean firstCheck, secondCheck;
		for (int i = 0; i < 4; i++) {
			tempFirstX = firstX + offsetX[i];
			tempFirstY = firstY + offsetY[i];
			tempSecondX = secondX + offsetX[i];
			tempSecondY = secondY + offsetY[i];
			firstCheck = isInBoard(tempFirstX, tempFirstY);
			secondCheck = isInBoard(tempSecondX, tempSecondY);
			if (firstCheck && secondCheck) {
				boolean firstWallCheck = isWall(tempFirstX, tempFirstY);
				boolean secondWallCheck = isWall(tempSecondX, tempSecondY);
				if (!firstWallCheck && !secondWallCheck) {
					dfs(tempFirstX, tempFirstY, tempSecondX, tempSecondY, count + 1);
				} else if (!firstWallCheck && secondWallCheck) {
					dfs(tempFirstX, tempFirstY, secondX, secondY, count + 1);
				} else if (firstWallCheck && !secondWallCheck) {
					dfs(firstX, firstY, tempSecondX, tempSecondY, count + 1);
				} else if (firstWallCheck && secondWallCheck) {
					continue;
				}
			} else if (!firstCheck && secondCheck) {
				answer = Math.min(answer, count + 1);
				return;
			} else if (firstCheck && !secondCheck) {
				answer = Math.min(answer, count + 1);
				return;
			}
		}
	}

	static boolean isWall(int x, int y) {
		return (board[x][y] == '#') ? true : false;
	}

	static boolean isInBoard(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			return true;
		}
		return false;
	}
}