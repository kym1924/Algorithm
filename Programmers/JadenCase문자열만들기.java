class Solution {
	public String solution(String s) {
		String[] temp = s.split("");
		StringBuilder sb = new StringBuilder();
		boolean blank = true;
		for (int i = 0; i < s.length(); i++) {
			if (temp[i].equals(" ")) {
				sb.append(temp[i]);
				blank = true;
			} else {
				if (!blank) {
					sb.append(temp[i].toLowerCase());
				} else {
					sb.append(temp[i].toUpperCase());
				}
				blank = false;
			}
		}
		return sb.toString();
	}
}