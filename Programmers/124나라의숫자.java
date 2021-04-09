class Solution {
	public String solution(int n) {
		String[] numbers = { "4", "1", "2" };

		StringBuilder sb = new StringBuilder("");
		while (n > 0) {
			sb.append(numbers[n % 3]);
			n -= 1;
			n /= 3;
		}
		return sb.reverse().toString();
	}
}