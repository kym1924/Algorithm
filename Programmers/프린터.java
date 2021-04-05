import java.util.ArrayList;

class Solution {
	static class Document {
		int location;
		int priorities;

		Document(int location, int priorities) {
			this.location = location;
			this.priorities = priorities;
		}
	}

	public int solution(int[] priorities, int location) {
		ArrayList<Document> list = new ArrayList<>();
		for (int i = 0; i < priorities.length; i++) {
			list.add(new Document(i, priorities[i]));
		}

		int answer = 0;
		while (list.size() != 0) {
			Document now = list.get(0);
			list.remove(0);
			boolean check = true;
			for (int i = 0; i < list.size(); i++) {
				int temp = list.get(i).priorities;
				if (now.priorities < temp) {
					list.add(now);
					check = false;
					break;
				}
			}
			if (check) {
				answer++;
				if (now.location == location) {
					return answer;
				}
			}
		}
		return answer;
	}
}