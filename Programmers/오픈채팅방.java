import java.util.HashMap;

class Solution {
	public String[] solution(String[] record) {
		HashMap<String, String> user = new HashMap<>();
		int enterOrLeave = 0;
		for (int i = 0; i < record.length; i++) {
			String[] now = record[i].split(" ");
			if (now[0].equals("Enter")) {
				user.put(now[1], now[2]);
				enterOrLeave++;
			} else if (now[0].equals("Leave")) {
				enterOrLeave++;
			} else if (now[0].equals("Change")) {
				user.put(now[1], now[2]);
			}
		}

		String[] answer = new String[enterOrLeave];
		int index = 0;
		for (int i = 0; i < record.length; i++) {
			String[] now = record[i].split(" ");
			if (now[0].equals("Enter")) {
				answer[index++] = user.get(now[1]) + "님이 들어왔습니다.";
			} else if (now[0].equals("Leave")) {
				answer[index++] = user.get(now[1]) + "님이 나갔습니다.";
			}
		}
		return answer;
	}
}