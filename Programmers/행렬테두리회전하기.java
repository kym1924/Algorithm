class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[][] arr = new int[rows][columns];
		int count = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = count++;
			}
		}

		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int rowStart = queries[i][0] - 1;
			int colStart = queries[i][1] - 1;
			int rowEnd = queries[i][2] - 1;
			int colEnd = queries[i][3] - 1;
			int temp = arr[rowStart][colStart];
			int min = temp;

			for (int j = rowStart; j < rowEnd; j++) {
				arr[j][colStart] = arr[j + 1][colStart];
				min = Math.min(min, arr[j + 1][colStart]);
			}

			for (int j = colStart; j < colEnd; j++) {
				arr[rowEnd][j] = arr[rowEnd][j + 1];
				min = Math.min(min, arr[rowEnd][j + 1]);
			}

			for (int j = rowEnd; j > rowStart; j--) {
				arr[j][colEnd] = arr[j - 1][colEnd];
				min = Math.min(min, arr[j - 1][colEnd]);
			}

			for (int j = colEnd; j > colStart; j--) {
				arr[rowStart][j] = arr[rowStart][j - 1];
				min = Math.min(min, arr[rowStart][j - 1]);
			}

			arr[rowStart][colStart + 1] = temp;
			answer[i] = min;
		}
		return answer;
	}
}