class Solution {
	static int answer = 0;

	public int solution(int[] numbers, int target) {
		dfs(numbers, numbers[0], target, 1);
		dfs(numbers, -numbers[0], target, 1);
		return answer;
	}

	static void dfs(int[] numbers, int sum, int target, int index) {
		if (index == numbers.length) {
			if (sum == target) {
				answer++;
			}
			return;
		}
		dfs(numbers, sum + numbers[index], target, index + 1);
		dfs(numbers, sum - numbers[index], target, index + 1);
	}
}