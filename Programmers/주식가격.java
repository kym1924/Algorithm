import java.util.ArrayList;

class Solution {
	public int[] solution(int[] prices) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < prices.length; i++) {
			list.add(prices[i]);
		}

		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			int now = list.get(i);
			int count = 0;
			for (int j = i + 1; j < prices.length; j++) {
				count++;
				if (now > list.get(j)) {
					break;
				}
			}
			answer[i] = count;
		}
		return answer;
	}
}