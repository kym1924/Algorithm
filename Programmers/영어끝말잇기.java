import java.util.ArrayList;

class Solution {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		ArrayList<String> list = new ArrayList<>();

		list.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			if (list.contains(words[i]) || words[i].length() == 1
					|| words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
				answer[0] = (i % n + 1);
				answer[1] = (i / n + 1);
				break;
			} else {
				list.add(words[i]);
			}
		}

		return answer;
	}
}