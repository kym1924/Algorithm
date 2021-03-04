class Solution {
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if ('A' <= now && now <= 'Z') {
				now += n;
				if (now > 'Z') {
					now -= 26;
				}
			}
			if ('a' <= now && now <= 'z') {
				now += n;
				if (now > 'z') {
					now -= 26;
				}
			}
			sb.append(now);
		}
		return sb.toString();
	}
}