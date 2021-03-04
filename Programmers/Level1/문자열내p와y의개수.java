class Solution {
	boolean solution(String s) {
		int count = 0;
        s = s.toUpperCase();
        
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if (now == 'P') count++;
			else if (now == 'Y') count--;
		}

		return count == 0;
	}
}