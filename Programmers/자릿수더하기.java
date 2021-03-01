class Solution {
	public int solution(int n) {
		int answer = 0;
		String check = String.valueOf(n);
		for (int i = 0; i < check.length(); i++) {
			answer += Character.getNumericValue(check.charAt(i));
		}

		return answer;
	}
}