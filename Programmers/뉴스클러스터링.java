import java.util.ArrayList;
import java.util.List;

class Solution {
	public int solution(String str1, String str2) {
		List<String> str1List = toList(init(str1));
		List<String> str2List = toList(init(str2));
		List<String> interSection = interSection(str1List, str2List);
		List<String> union = union(str1List, str2List);
		double interSectionSize = interSection.size();
		double unionSize = union.size();
		if (unionSize == 0) {
			return 65536;
		}
		return (int) (interSectionSize / unionSize * 65536);
	}

	static String init(String str) {
		String temp = str.toUpperCase();
		return temp;
	}

	static List<String> toList(String str) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < str.length() - 1; i++) {
			String temp = str.substring(i, i + 2).replaceAll("[^A-Z]", "");
			if (temp.length() == 2) {
				list.add(temp);
			}
		}
		return list;
	}

	static List<String> interSection(List<String> str1List, List<String> str2List) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < str1List.size(); i++) {
			if (str2List.contains(str1List.get(i))) {
				list.add(str1List.get(i));
				str2List.remove(str1List.get(i));
			}
		}
		return list;
	}

	static List<String> union(List<String> str1List, List<String> str2List) {
		List<String> list = new ArrayList<>(str1List);
		list.addAll(str2List);
		return list;
	}
}