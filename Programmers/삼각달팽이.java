class Solution {
	public int[] solution(int n) {
		int max = n * (n + 1) / 2;
		int[][] arr = new int[n][n];

		int num = 1, r = -1, c = 0, direction = n;
		while (num <= max) {
			for (int i = 0; i < direction; i++) {
				arr[++r][c] = num++;
			}
			direction--;
			for (int i = 0; i < direction; i++) {
				arr[r][++c] = num++;
			}
			direction--;
			for (int i = 0; i < direction; i++) {
				arr[--r][--c] = num++;
			}
			direction--;
		}

		int[] answer = new int[max];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[index++] = arr[i][j];
			}
		}
		return answer;
	}
}