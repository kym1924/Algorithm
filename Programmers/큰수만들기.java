class Solution {
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, index = 0; i < number.length() - k; i++) {
			int max = 0;
			for (int j = index; j <= i + k; j++) {
				int check = Character.getNumericValue(number.charAt(j));
				if (max < check) {
					max = check;
					index = j + 1;
				}
				if (max == 9) {
					break;
				}
			}
			sb.append(max);
		}
		return sb.toString();
	}
}