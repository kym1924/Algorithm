import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static class Location {
		int x;
		int y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[] solution(int m, int n, int[][] picture) {
		int[] offsetX = { 1, 0, -1, 0 };
		int[] offsetY = { 0, 1, 0, -1 };
		boolean[][] visited = new boolean[m][n];

		Queue<Location> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !visited[i][j]) {
					int pictureSize = 1;
					int check = picture[i][j];
					q.add(new Location(i, j));
					visited[i][j] = true;

					while (!q.isEmpty()) {
						Location now = q.poll();
						for (int k = 0; k < 4; k++) {
							for (int l = 0; l < 4; l++) {
								int tempX = now.x + offsetX[l];
								int tempY = now.y + offsetY[l];
								if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n) {
									if (picture[tempX][tempY] == check && !visited[tempX][tempY]) {
										visited[tempX][tempY] = true;
										pictureSize++;
										q.add(new Location(tempX, tempY));
									}
								}
							}
						}
					}

					list.add(pictureSize);
					if (max < pictureSize) {
						max = pictureSize;
					}
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = list.size();
		answer[1] = max;
		return answer;
	}
}