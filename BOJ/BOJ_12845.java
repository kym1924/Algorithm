import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_12845 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		int gold = 0;
		int max = Collections.max(list);
		while (list.size() > 1) {
			int maxIndex = list.indexOf(max);
			if (maxIndex - 1 >= 0) {
				int prev = list.get(maxIndex - 1);
				list.remove(list.get(maxIndex - 1));
				gold += (max + prev);
			}
			if (maxIndex + 1 <= list.size() - 1) {
				int next = list.get(maxIndex + 1);
				list.remove(list.get(maxIndex + 1));
				gold += (max + next);
			}
		}
		System.out.print(gold);
	}
}