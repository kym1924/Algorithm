class Solution {
	public int solution(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int check = 0;
			for (int j = i;; j++) {
				check += j;
				if (check == n) {
					count++;
				} else if (check > n) {
					break;
				}
			}
		}
		return count;
	}
}