import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}

		int answer = 0;
		while (pq.size() >= 2 && pq.peek() < K) {
			int a = pq.poll();
			int b = pq.poll();
			pq.add(a + (b * 2));
			answer++;
		}

		if (pq.poll() >= K) {
			return answer;
		}
		return -1;
	}
}