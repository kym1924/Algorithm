import java.util.Arrays;

class Solution {
	public String solution(String s) {
		char[] charArr = new char[s.length()];
		charArr = s.toCharArray();
		Arrays.sort(charArr);
		StringBuilder sb = new StringBuilder(new String(charArr));
		return sb.reverse().toString();
	}
}