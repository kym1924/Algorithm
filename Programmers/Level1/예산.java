import java.util.Arrays;

class Solution {
	public int solution(int[] d, int budget) {
		int check = 0;
		int i = 0;
		Arrays.sort(d);
		for (i = 0; i < d.length; i++) {
			check += d[i];
			if (check > budget) {
				break;
			}
		}
		return i;
	}
}