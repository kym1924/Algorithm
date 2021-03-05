import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1082 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] temp = br.readLine().split(" ");
		int[] cost = new int[N];

		int minCost = Integer.MAX_VALUE;
		int maxValue = 0;
		for (int i = 0; i < N; i++) {
			int tempCost = Integer.parseInt(temp[i]);
			cost[i] = tempCost;
			if (tempCost <= minCost) {
				minCost = tempCost;
				maxValue = i;
			}
		}

		int money = Integer.parseInt(br.readLine());
		int length = money / minCost;
		money -= length * minCost;

		ArrayList<Integer> buy = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			buy.add(maxValue);
		}

		int first = 0;
		for (int i = 0; i < length; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (money + minCost >= cost[j]) {
					buy.set(i, j);
					money = money + minCost - cost[j];
					break;
				}
			}

			if (buy.get(first) == 0) {
				first++;
				money += minCost;
			}
		}

		if (first == length) {
			System.out.print(0);
		} else {
			for (int i = first; i < buy.size(); i++) {
				System.out.print(buy.get(i));
			}
		}
	}
}
