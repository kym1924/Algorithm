import java.util.Arrays;

class Solution {
	public long solution(long n) {
		String[] check = String.valueOf(n).split("");
		Arrays.sort(check);
		StringBuilder sb = new StringBuilder();
		for (String num : check) {
			sb.append(num);
		}
		return Long.parseLong(sb.reverse().toString());
	}
}