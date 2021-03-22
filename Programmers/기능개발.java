import java.util.ArrayList;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] remain = new int[progresses.length];

		for (int i = 0; i < progresses.length; i++) {
			remain[i] = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0) {
				remain[i]++;
			}
		}

		ArrayList<Integer> result = new ArrayList<>();

		int count = 1;
		for (int i = 0; i < progresses.length; i++) {
			if (i < progresses.length - 1) {
				if (remain[i] >= remain[i + 1]) {
					remain[i + 1] = remain[i];
					count++;
				} else {
					result.add(count);
					count = 1;
				}
			} else {
				result.add(count);
			}
		}

		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}
}