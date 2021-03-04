import java.util.regex.Pattern;

class Solution {
	public boolean solution(String s) {
		boolean answer = true;
		answer = (s.length() == 4 || s.length() == 6) && Pattern.matches("^[0-9]*$", s);
		return answer;
	}
}