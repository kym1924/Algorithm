import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
	public int[] solution(String s) {
		HashMap<Integer, Integer> map = new HashMap<>();
		String[] temp = s.substring(1, s.length() - 2).split("},");

		for (int i = 0; i < temp.length; i++) {
			String[] now = temp[i].replace("{", "").split(",");
			for (int j = 0; j < now.length; j++) {
				int index = Integer.parseInt(now[j]);
				map.put(index, map.getOrDefault(index, 0) + 1);
			}
		}

		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}