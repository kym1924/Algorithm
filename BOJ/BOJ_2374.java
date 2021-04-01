import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2374 {

	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine());
			if (list.size() == 0) {
				list.add(now);
			} else if (list.get(list.size() - 1) != now) {
				list.add(now);
			}
		}

		int max = Collections.max(list);
		int maxIndex = list.indexOf(max);
		cal(list.subList(0, maxIndex), max);
		cal(list.subList(maxIndex + 1, list.size()), max);
		System.out.print(answer);
	}

	static void cal(List<Integer> list, int max) {
		if (list.size() != 0) {
			int nowMax = Collections.max(list);
			answer += max - nowMax;
			cal(list.subList(0, list.indexOf(nowMax)), nowMax);
			cal(list.subList(list.indexOf(nowMax) + 1, list.size()), nowMax);
		}
	}
}