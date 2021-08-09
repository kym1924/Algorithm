import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int[] result = new int[N];
		for (int i = 1; i < N; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				result[stack.peek()] = arr[i];
				stack.pop();
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			bw.append(result[i] + " ");
		}
		bw.flush();
		bw.close();
	}
}
