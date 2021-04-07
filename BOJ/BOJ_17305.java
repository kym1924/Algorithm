import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_17305 {

	static int N, W;
	static long answer = 0;
	static List<Integer> threeList = new ArrayList<>();
	static List<Integer> fiveList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		if (W < 3) {
			System.out.print(0);
			return;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("3")) {
				threeList.add(Integer.parseInt(st.nextToken()));
			} else {
				fiveList.add(Integer.parseInt(st.nextToken()));
			}
		}

		Collections.sort(threeList, Collections.reverseOrder());
		Collections.sort(fiveList, Collections.reverseOrder());

		long[] three = new long[threeList.size() + 1];
		for (int i = 1; i < three.length; i++) {
			three[i] = three[i - 1] + threeList.get(i - 1);
		}
		
		long[] five = new long[fiveList.size() + 1];
		for (int i = 1; i < five.length; i++) {
			five[i] = five[i - 1] + fiveList.get(i - 1);
		}

		int maxFive = Math.min(W / 5, fiveList.size());

		for (int i = 0; i <= maxFive; i++) {
			long temp = five[i];

			int threeIndex = (W - (i * 5)) / 3;
			threeIndex = Math.min(threeIndex, threeList.size());

			temp += three[threeIndex];

			answer = Math.max(answer, temp);
		}
		System.out.print(answer);
	}
}