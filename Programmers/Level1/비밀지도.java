class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {

		String[] answer = new String[n];
		char[][] map = new char[n][n];
		StringBuilder sb = new StringBuilder();
		
		String format = "%0" + n + "d";
		for (int i = 0; i < arr1.length; i++) {
			String row = String.format(format, Long.parseLong(Integer.toBinaryString(arr1[i]).toString()));
			String row2 = String.format(format, Long.parseLong(Integer.toBinaryString(arr2[i]).toString()));
			for (int j = 0; j < n; j++) {
				if (row.charAt(j) == '1' || row2.charAt(j) == '1') {
					map[i][j] = '#';
				} else {
					map[i][j] = ' ';
				}
			}
		}

		for (int i = 0; i < n; i++) {
			sb.setLength(0);
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			answer[i] = sb.toString();
		}

		return answer;
	}
}