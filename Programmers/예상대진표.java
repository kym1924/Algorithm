class Solution {
	public int solution(int n, int a, int b) {
		int answer = 0;
		while (a != b) {
			answer++;
			a = win(a);
			b = win(b);
		}
		return answer;
	}

	static int win(int number) {
		if (number % 2 == 0) {
			return number /= 2;
		} else {
			return (number /= 2) + 1;
		}
	}
}