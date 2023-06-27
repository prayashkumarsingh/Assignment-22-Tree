package in.ineuron.question;

import java.util.Stack;
import java.util.HashMap;

public class Question3 {
	public static void printTopToBottomPath(Node curr, HashMap<Node, Node> parent) {
		Stack<Node> stk = new Stack<>();
		while (curr != null) {
			stk.push(curr);
			curr = parent.get(curr);
		}
		while (!stk.isEmpty()) {
			curr = stk.pop();
			System.out.print(curr.data + " ");
		}
		System.out.println();
	}
	public static void printRootToLeaf(Node root) {
		if (root == null)
			return;
		Stack<Node> nodeStack = new Stack<>();
		nodeStack.push(root);

		HashMap<Node, Node> parent = new HashMap<>();
		parent.put(root, null);
		while (!nodeStack.isEmpty()) {
			Node current = nodeStack.pop();
			if (current.left == null && current.right == null)
				printTopToBottomPath(current, parent);
			if (current.right != null) {
				parent.put(current.right, current);
				nodeStack.push(current.right);
			}
			if (current.left != null) {
				parent.put(current.left, current);
				nodeStack.push(current.left);
			}
		}
	}

	public static void main(String args[]) {
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(5);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.right.left = new Node(4);
		printRootToLeaf(root);
	}
}

class Node {
	int data;
	Node left, right;

	Node(int data) {
		left = right = null;
		this.data = data;
	}
}
