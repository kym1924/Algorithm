import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		ArrayList<Integer> tempList = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0)
				tempList.add(arr[i]);
		}

		if (tempList.size() == 0) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = new int[tempList.size()];
			for (int i = 0; i < tempList.size(); i++) {
				answer[i] = tempList.get(i);
			}
		}

		Arrays.sort(answer);

		return answer;
	}
}