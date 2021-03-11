import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1092 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> crane = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());

		if (crane.get(0) < box.get(0)) {
			System.out.print(-1);
			return;
		}

		int time = 0;
		while (box.size() != 0) {
			int boxIndex = 0;
			for (int i = 0; i < N; i++) {
				if (boxIndex == box.size()) {
					break;
				}
				if (crane.get(i) >= box.get(boxIndex)) {
					box.remove(boxIndex);
				} else {
					i--;
					boxIndex++;
				}
			}
			time++;
		}
		System.out.print(time);
	}
}
