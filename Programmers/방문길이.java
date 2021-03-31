class Solution {
	static int answer = 0;
	static boolean[][][][] visited = new boolean[11][11][11][11];

	public int solution(String dirs) {
		int row = 5, col = 5;

		for (int i = 0; i < dirs.length(); i++) {
			char now = dirs.charAt(i);
			if (now == 'U' && row > 0) {
				if (!visited[row][col][row - 1][col]) {
					visitedCheck(row, col, row - 1, col);
				}
				row--;
			} else if (now == 'L' && col > 0) {
				if (!visited[row][col][row][col - 1]) {
					visitedCheck(row, col, row, col - 1);
				}
				col--;
			} else if (now == 'R' && col < 10) {
				if (!visited[row][col][row][col + 1]) {
					visitedCheck(row, col, row, col + 1);
				}
				col++;
			} else if (now == 'D' && row < 10) {
				if (!visited[row][col][row + 1][col]) {
					visitedCheck(row, col, row + 1, col);
				}
				row++;
			}
		}
		return answer;
	}

	static void visitedCheck(int prevRow, int prevCol, int row, int col) {
		visited[prevRow][prevCol][row][col] = true;
		visited[row][col][prevRow][prevCol] = true;
		answer++;
	}
}