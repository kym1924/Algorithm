class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] arr3 = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr2.length; k++) {
					int temp = arr1[i][k] * arr2[k][j];
					arr3[i][j] += temp;
				}
			}
		}
		return arr3;
	}
}