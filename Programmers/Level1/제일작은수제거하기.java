import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public int[] solution(int[] arr) {
		if (arr.length <= 1) {
			int[] answer = { -1 };
			return answer;
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		Collections.sort(list);
		list.remove(0);

		int[] answer = new int[list.size()];
		int length = 0;
		for (int i = 0; i < arr.length; i++) {
			if (list.contains(arr[i])) {
				answer[length++] = arr[i];
			}
		}
		return answer;
	}
}