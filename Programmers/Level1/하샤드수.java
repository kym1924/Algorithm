class Solution {
	public boolean solution(int x) {
		String strX = Integer.toString(x);
		int sum = 0;

		for (int i = 0; i < strX.length(); i++) {
			sum += Character.getNumericValue(strX.charAt(i));
		}

		return x % sum == 0;
	}
}