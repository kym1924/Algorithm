import java.util.ArrayList;

class Solution {
	public int solution(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder(s.substring(i, s.length()));
			sb.append(s.substring(0, i));
			answer += isValid(sb.toString());
		}
		return answer;
	}

	static int isValid(String str) {
		ArrayList<Character> list = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			if (now == '[') {
				list.add(now);
			} else if (now == ']') {
				if (list.size() == 0) {
					return 0;
				} else {
					if (list.get(list.size() - 1) == '[') {
						list.remove(list.size() - 1);
					} else {
						list.add(now);
					}
				}
			} else if (now == '(') {
				list.add(now);
			} else if (now == ')') {
				if (list.size() == 0) {
					return 0;
				} else {
					if (list.get(list.size() - 1) == '(') {
						list.remove(list.size() - 1);
					} else {
						list.add(now);
					}
				}
			} else if (now == '{') {
				list.add(now);
			} else if (now == '}') {
				if (list.size() == 0) {
					return 0;
				} else {
					if (list.get(list.size() - 1) == '{') {
						list.remove(list.size() - 1);
					} else {
						list.add(now);
					}
				}
			}
		}

		if (list.size() == 0) {
			return 1;
		} else {
			return 0;
		}
	}
}