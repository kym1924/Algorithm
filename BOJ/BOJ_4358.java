import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ_4358 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new TreeMap<>();

		double count = 0;
		String tree;
		while ((tree = br.readLine()) != null) {
			count++;
			map.put(tree, map.getOrDefault(tree, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			double percent = (map.get(key)) / count * 100.0;
			sb.append(key + " " + String.format("%.4f", percent) + "\n");
		}
		System.out.print(sb.toString());
	}
}
