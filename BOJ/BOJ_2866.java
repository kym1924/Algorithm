import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		ArrayList<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < C; i++) {
			sb.setLength(0);
			for (int j = 0; j < R; j++) {
				sb.append(arr[j][i]);
			}
			list.add(sb.toString());
		}

		int count = 0, start = 0, end = R;
		ArrayList<String> tempList = new ArrayList<>();
		while (start <= end) {
			tempList.clear();
			int mid = (start + end) / 2;
			for (int i = 0; i < list.size(); i++) {
				String temp = list.get(i);
				temp = temp.substring(mid, temp.length());
				if (!tempList.contains(temp)) {
					tempList.add(temp);
				} else {
					break;
				}
			}
			if (tempList.size() != list.size()) {
				end = mid - 1;
			} else {
				start = mid + 1;
				count = mid;
			}
		}
		System.out.print(count);
	}
}