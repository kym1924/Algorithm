class Solution {
	public int solution(int n) {
		int answer = 0;
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			if (!isPrime[i])
				answer++;
			for (int j = i; j <= n; j += i) {
				if (!isPrime[j])
					isPrime[j] = true;
			}
		}
		return answer;
	}
}