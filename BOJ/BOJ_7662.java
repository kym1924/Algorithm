import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			int k = Integer.parseInt(st.nextToken());

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				String operation = st.nextToken();
				if (operation.equals("I")) {
					int num = Integer.parseInt(st.nextToken());
					treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
				} else if (operation.equals("D")) {
					if (treeMap.isEmpty()) {
						continue;
					} else {
						int minOrMax = Integer.parseInt(st.nextToken());
						if (minOrMax == 1) {
							int max = treeMap.lastKey();
							if (treeMap.get(max) == 1) {
								treeMap.remove(max);
							} else {
								treeMap.replace(max, treeMap.get(max) - 1);
							}
						} else if (minOrMax == -1) {
							int min = treeMap.firstKey();
							if (treeMap.get(min) == 1) {
								treeMap.remove(min);
							} else {
								treeMap.replace(min, treeMap.get(min) - 1);
							}
						}
					}
				}
			}

			if (treeMap.isEmpty()) {
				bw.write("EMPTY\n");
			} else {
				bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
