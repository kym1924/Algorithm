import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int size = commands.length;
		int[] answer = new int[size];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.clear();
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				list.add(array[j]);
			}
			Collections.sort(list);
			answer[i] = list.get(commands[i][2] - 1);
		}

		return answer;
	}
}