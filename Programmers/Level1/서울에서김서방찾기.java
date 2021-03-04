import java.util.Arrays;

class Solution {
	public String solution(String[] seoul) {
		StringBuilder sb = new StringBuilder("김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다");
		return sb.toString();
	}
}