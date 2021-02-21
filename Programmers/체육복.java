class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if (reserve[i] == lost[j]) {
					answer++;
					reserve[i] = -1;
					lost[j] = -1;
					break;
				}
			}
		}

		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
					reserve[j] = -1;
					answer++;
					break;
				}
			}
		}
		return answer;
	}
}