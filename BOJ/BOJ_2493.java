import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

	static class Tower {
		int index;
		int height;

		Tower(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Stack<Tower> stack = new Stack<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek().height < height) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				bw.write("0 ");
			} else {
				bw.write(String.valueOf(stack.peek().index) + " ");
			}
			stack.add(new Tower(i, height));
		}
		bw.flush();
		bw.close();
	}
}
