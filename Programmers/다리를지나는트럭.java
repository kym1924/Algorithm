import java.util.Queue;
import java.util.LinkedList;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> q = new LinkedList<>();

		int answer = 0, weightSum = 0;
		for (int i = 0; i < truck_weights.length; i++) {
			int truck = truck_weights[i];
			while (true) {
				if (q.isEmpty()) {
					q.add(truck);
					weightSum += truck;
					answer++;
					break;
				}
				if (q.size() == bridge_length) {
					weightSum -= q.poll();
				} else if (weightSum + truck <= weight) {
					q.add(truck);
					weightSum += truck;
					answer++;
					break;
				} else {
					q.add(0);
					answer++;
				}
			}
		}
		return answer + bridge_length;
	}
}