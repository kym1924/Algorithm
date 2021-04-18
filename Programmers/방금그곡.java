class Solution {
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int checkTime = 0;

		for (int i = 0; i < musicinfos.length; i++) {
			String[] temp = musicinfos[i].split(",");
			String start = temp[0];
			String end = temp[1];
			String title = temp[2];
			String music = replace(temp[3]);

			int timediff = timeCal(start, end);

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < timediff; j++) {
				sb.append(music.charAt(j % music.length()));
			}

			if (sb.toString().contains(replace(m))) {
				if (checkTime < timediff) {
					checkTime = timediff;
					answer = title;
				}
			}
		}
		return answer;
	}

	static String replace(String music) {
		return music.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
	}

	static int timeCal(String start, String end) {
		int startHour = Integer.parseInt(start.split(":")[0]);
		int startMinute = Integer.parseInt(start.split(":")[1]);
		int endHour = Integer.parseInt(end.split(":")[0]);
		int endMinute = Integer.parseInt(end.split(":")[1]);
		return (endHour - startHour) * 60 + (endMinute - startMinute);
	}
}