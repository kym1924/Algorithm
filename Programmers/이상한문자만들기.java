class Solution {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		String[] temp = s.split("");
		int index = 0;

		for (int i = 0; i < temp.length; i++) {
			if (temp[i].equals(" ")) {
				sb.append(temp[i]);
				index = 0;
			} else {
				if (index % 2 == 0) {
					sb.append(temp[i].toUpperCase());
					index++;
				} else {
					sb.append(temp[i].toLowerCase());
					index++;
				}
			}
		}

		return sb.toString();
	}
}