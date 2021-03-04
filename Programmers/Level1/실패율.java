import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class Solution {
	public int[] solution(int N, int[] stages) {
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();

		Arrays.sort(stages);

		int users = stages.length;
		for (int i = 1; i <= N; i++) {
			int thisStage = 0;
			for (int j = 0; j < stages.length; j++) {
				if (stages[j] == i) {
					thisStage++;
				} else if (stages[j] > i) {
					break;
				}
			}
			if (Double.isNaN((double) thisStage / users)) {
				map.put(i, 0.0);
			} else {
				map.put(i, (double) thisStage / users);
			}
			users -= thisStage;
		}

		List<Integer> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2).compareTo(map.get(o1));
			}
		});

		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = keySetList.get(i);
		}
		return answer;
	}
}