import java.util.ArrayList;

class Solution {
	public int[] solution(int[] answers) {
		int[] answer = {};

		int[] oneAnswer = { 1, 2, 3, 4, 5 };
		int[] twoAnswer = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] threeAnswer = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int oneCount = 0, twoCount = 0, threeCount = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == oneAnswer[i % 5])
				oneCount++;
			if (answers[i] == twoAnswer[i % 8])
				twoCount++;
			if (answers[i] == threeAnswer[i % 10])
				threeCount++;
		}

		int max = Math.max(oneCount, Math.max(twoCount, threeCount));

		ArrayList<Integer> list = new ArrayList<Integer>();

		if (max == oneCount) {
			list.add(1);
		}
		if (max == twoCount) {
			list.add(2);
		}
		if (max == threeCount) {
			list.add(3);
		}

		answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}