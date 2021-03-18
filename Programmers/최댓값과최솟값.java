import java.util.Arrays;

class Solution {
	public String solution(String s) {
		String[] temp = s.split(" ");
		int[] intArr = new int[temp.length];

		for (int i = 0; i < temp.length; i++) {
			intArr[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(intArr);
		StringBuilder sb = new StringBuilder();
		sb.append(intArr[0] + " " + intArr[intArr.length - 1]);
		return sb.toString();
	}
}