package ch07;

import java.util.Iterator;
import java.util.Scanner;

class TreeNode {
	public int data;
	public TreeNode leftChild;
	public TreeNode rightChild;

	public TreeNode(int data) {
		this.data = data;
		leftChild = rightChild = null;
	}
}

class Tree {
	private TreeNode root;
	private TreeNode[] tree;
	private int size;
	private int i;
	
	Tree(int size) {
		root = null;
		i = 0;
		tree = new TreeNode[size + 1];
	};

	TreeNode InorderSucc(TreeNode current) {
		TreeNode temp = current.rightChild;
		if (current.rightChild != null)
			while (temp.leftChild != null)
				temp = temp.leftChild;
		return temp;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.leftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.rightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.leftChild);
			preorder(CurrentNode.rightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.leftChild);
			postorder(CurrentNode.rightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	void insert(int x) { // binary search tree를 만드는 입력
		TreeNode parent;
		TreeNode temp = new TreeNode(x);
		if (root == null) {
			tree[++i] = temp;
			root = tree[i];
			parent = tree[i];
		} else {
			
		}
	}

	void delete(int x) { // binary search tree에서 x가 있으면 삭제하는 구현

	}
	
	void show() {
		for (int j = 1; j <= i; j++) {
			System.out.print(tree[j].data + " ");
		}
	}
}

public class BinaryTree {
	static int num = 10; 
	static Tree tree = new Tree(num + 1);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int select = 0;

		while (select != 6) {
			System.out.print("BinarySearchTree. Select 1:Insert, 2. Delete, 3:preorder, 4:postorder, 5. inorder, 6. Quit =>");
			select = sc.nextInt();
			switch (select) {
			case 1: // insert
				System.out.print("The number of items = ");
				int[] input = new int[num + 1]; // 배열 0번 인덱스 사용x
				for (int i = 1; i <= num; i++) {
					input[i] = (int)(Math.random() * 30);
					tree.insert(input[i]);
				}
				for (int i = 1; i <= num; i++) {
					System.out.print(input[i] + " ");
				}
				System.out.println();
				
				break;
			case 2: // Delete
				tree.show();
				System.out.println();
				break;
			case 3:
				tree.preorder();
				System.out.println();
				break;
			case 4:
				tree.postorder();
				break;
			case 5:
				tree.inorder();
				break;
			case 6:
				System.out.println("Quit");
				break;
			default:
				System.out.println("WRONG INPUT");
				System.out.println("Re-Enter");
				break;
			}
		}
	}
}
