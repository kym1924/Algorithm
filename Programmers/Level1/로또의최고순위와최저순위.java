import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {
		List<Integer> list = new ArrayList<Integer>(Arrays.stream(win_nums).boxed().collect(Collectors.toList()));

		int count = 0, zero = 0;
		for (int i = 0; i < 6; i++) {
			if (list.contains(lottos[i])) {
				count++;
			} else if (lottos[i] == 0) {
				zero++;
			}
		}
		int[] answer = { grade(count + zero), grade(count) };
		return answer;
	}

	static int grade(int count) {
		switch (count) {
		case 2:
			return 5;
		case 3:
			return 4;
		case 4:
			return 3;
		case 5:
			return 2;
		case 6:
			return 1;
		default:
			return 6;
		}
	}
}