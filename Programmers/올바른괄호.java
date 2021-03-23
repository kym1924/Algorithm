import java.util.ArrayList;

class Solution {
	boolean solution(String s) {
		ArrayList<Integer> leftIndex = new ArrayList<>();
		ArrayList<Integer> rightIndex = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftIndex.add(i);
			} else if (s.charAt(i) == ')') {
				rightIndex.add(i);
			}
		}

		if (leftIndex.size() != rightIndex.size()) {
			return false;
		}

		for (int i = 0; i < leftIndex.size(); i++) {
			if (leftIndex.get(i) > rightIndex.get(i)) {
				return false;
			}
		}
		return true;
	}
}