class Solution {
	public String solution(String new_id) {
		new_id = new_id.toLowerCase();
		new_id = new_id.replaceAll("[^0-9a-z_.-]", "");
		new_id = new_id.replaceAll("[.]{2,}", ".");

		StringBuilder sb = new StringBuilder(new_id);
		if (sb.toString().startsWith(".")) {
			sb.deleteCharAt(0);
		}
		if (sb.toString().endsWith(".")) {
			sb.deleteCharAt(sb.toString().length() - 1);
		}

		if (sb.toString().length() == 0) {
			sb.append('a');
		}

		if (sb.toString().length() >= 16) {
			for (int i = sb.toString().length() - 1; i >= 15; i--) {
				sb.deleteCharAt(i);
			}
			if (sb.toString().endsWith(".")) {
				sb.deleteCharAt(sb.toString().length() - 1);
			}
		}

		if (sb.toString().length() <= 2) {
			while (sb.toString().length() < 3) {
				sb.append(sb.charAt(sb.toString().length() - 1));
			}
		}
		return sb.toString();
	}
}