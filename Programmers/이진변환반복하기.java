class Solution {
	public int[] solution(String s) {
		int count = 0;
		int deleteCount = 0;

		while (!s.equals("1")) {
			int length = s.length();
			s = s.replace("0", "");
			deleteCount += length - s.length();
			s = Integer.toBinaryString(s.length());
			count++;
		}

		int[] answer = new int[2];
		answer[0] = count;
		answer[1] = deleteCount;
		return answer;
	}
}