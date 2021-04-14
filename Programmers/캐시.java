import java.util.ArrayList;

class Solution {
	public int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return cities.length * 5;
		}

		int answer = 0;
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < cities.length; i++) {
			String now = cities[i].toUpperCase();
			if (list.contains(now)) {
				answer += 1;
				list.remove(list.indexOf(now));
				list.add(now);
			} else {
				answer += 5;
				list.add(now);
			}
			if (list.size() > cacheSize) {
				list.remove(0);
			}
		}
		return answer;
	}
}