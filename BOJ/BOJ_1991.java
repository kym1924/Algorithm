import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_1991 {

	static int N;
	static ArrayList<ArrayList<Character>> treeList = new ArrayList<>();
	static Node[] tree;

	static class Node {
		char val;
		Node left;
		Node right;

		Node(char val) {
			this.val = val;
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		tree = new Node[N];

		for (int i = 0; i < N; i++) {
			treeList.add(new ArrayList<Character>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			treeList.get(parent - 'A').add(left);
			treeList.get(parent - 'A').add(right);
		}

		makeNode();
		makeTree();
		preOrder(tree[0]);
		System.out.println();
		inOrder(tree[0]);
		System.out.println();
		postOrder(tree[0]);
		System.out.println();
	}

	static void makeNode() {
		for (int i = 0; i < N; i++) {
			char ch = (char) ('A' + i);
			tree[i] = new Node(ch);
		}
	}

	static void makeTree() {
		for (int i = 0; i < N; i++) {
			if (treeList.get(i).get(0) != '.') {
				tree[i].left = tree[treeList.get(i).get(0) - 'A'];
			}
			if (treeList.get(i).get(1) != '.') {
				tree[i].right = tree[treeList.get(i).get(1) - 'A'];
			}
		}
	}

	static void preOrder(Node root) {
		System.out.print(root.val);
		if (root.left != null)
			preOrder(root.left);
		if (root.right != null)
			preOrder(root.right);
	}

	static void inOrder(Node root) {
		if (root.left != null)
			inOrder(root.left);
		System.out.print(root.val);
		if (root.right != null)
			inOrder(root.right);
	}

	static void postOrder(Node root) {
		if (root.left != null)
			postOrder(root.left);
		if (root.right != null)
			postOrder(root.right);
		System.out.print(root.val);
	}
}
