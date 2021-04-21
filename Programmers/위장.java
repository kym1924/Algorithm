import java.util.HashMap;

class Solution {
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			String category = clothes[i][1];
			map.put(category, map.getOrDefault(category, 0) + 1);
		}
		int answer = 1;
		for (String key : map.keySet()) {
			answer *= (map.get(key) + 1);
		}
		answer -= 1;
		return answer;
	}
}