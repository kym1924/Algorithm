class Solution {
	public int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			answer += count(i);
		}
		return answer;
	}

	static int count(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}
		if (count % 2 == 0) {
			return n;
		} else {
			return -n;
		}
	}
}