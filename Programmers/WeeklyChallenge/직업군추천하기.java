class Solution {
	public String solution(String[] table, String[] languages, int[] preference) {
		int max = Integer.MIN_VALUE;
		String answer = "";

		for (int i = 0; i < table.length; i++) {
			int sum = 0;
			for (int j = 0; j < languages.length; j++) {
				String[] temp = table[i].split(" ");
				for (int k = 1; k < temp.length; k++) {
					if (temp[k].equals(languages[j])) {
						sum = sum + ((5 - k + 1) * preference[j]);
						break;
					}
				}
			}
			String compare = table[i].split(" ")[0];
			if (max < sum || (max == sum && answer.compareTo(compare) > 0)) {
				answer = compare;
				max = Math.max(max, sum);
			}
		}
		return answer;
	}
}