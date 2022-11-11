package ch07;

import java.util.Scanner;

class TreeNode {
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class Tree {
    private TreeNode root;

    Tree() {
        this.root = null;
    };

    TreeNode inOrderSuccessor(TreeNode current) {
        TreeNode temp = current.rightChild;
        if (current.rightChild != null)
            while (temp.leftChild != null)
                temp = temp.leftChild;
        return temp;
    }

    void preOrder() {
        preOrder(root);
    }

    void inOrder() {
        inOrder(root);
    }

    void postOrder() {
        postOrder(root);
    }

    void preOrder(TreeNode CurrentNode) {
        if (CurrentNode != null) {
            System.out.print(CurrentNode.data + " ");
            preOrder(CurrentNode.leftChild);
            preOrder(CurrentNode.rightChild);
        }
    }

    void inOrder(TreeNode CurrentNode) {
        if (CurrentNode != null) {
            inOrder(CurrentNode.leftChild);
            System.out.print(" " + CurrentNode.data);
            inOrder(CurrentNode.rightChild);
        }
    }

    void postOrder(TreeNode CurrentNode) {
        if (CurrentNode != null) {
            postOrder(CurrentNode.leftChild);
            postOrder(CurrentNode.rightChild);
            System.out.print(CurrentNode.data + " ");
        }
    }
    
    void insert(int x) { // binary search tree를 만드는 입력
        TreeNode newNode = new TreeNode(x);
        if (root == null) {
            root = newNode;
            System.out.printf("Insert : %d\n",x);
            return;
        }
        TreeNode current = root;
        TreeNode parent = null;
        while (true){
            parent = current;
            if (x == current.data){
                System.out.printf("Insert Duplicate data : %d\n",x);
                return;
            } else if (x < current.data){
                current = current.leftChild;
                if (current == null){
                    parent.leftChild = newNode;
                    System.out.printf("Insert : %d\n",x);
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null){
                    parent.rightChild = newNode;
                    System.out.printf("Insert : %d\n",x);
                    return;
                }
            }
        }
    }

    void delete(int x) { // binary search tree에서 x가 있으면 삭제하는 구현
    	TreeNode parent = root;
    	TreeNode current = root;
    	boolean isLeftChild = false;
    	// x를 찾는 과정
    	while(current.data != x) {
    		parent = current;
    		if (current.data > x) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
    		if (current == null) {
				System.out.printf("%d는 tree에 없습니다.\n",x);
				return;
    		}
    	}
    	// 1. 자식 노드가 없는 경우
    	if(current.leftChild == null && current.rightChild == null) {
    		if (current == root) {
				root = null;
			}
    		// 왼쪽 가지이면
    		if (isLeftChild) {
				parent.leftChild = null;
    		// 오른쪽 가지이면	
			} else {
				parent.rightChild = null;
			}
    	}
    	// 2. 자식이 하나인 경우
    	else if(current.rightChild == null) { // 왼쪽 자식을 갖는 경우
    		if (current == root) {
				root = current.leftChild;
			}
    		// 왼쪽 가지이면
    		if (isLeftChild) {
				parent.leftChild = current.leftChild;
    		// 오른쪽 가지이면	
			} else {
				parent.rightChild = current.leftChild;
			}
    	} else if(current.leftChild == null) { // 오른쪽 자식을 갖는 경우
    		if (current == root) {
				root = current.rightChild;
			}
    		// 왼쪽 가지이면
    		if (isLeftChild) {
				parent.leftChild = current.rightChild;
    		// 오른쪽 가지이면	
			} else {
				parent.rightChild = current.rightChild;
			}
    	}
    	// 3. 두 개의 자식을 갖는 경우
    	else if(current.leftChild != null && current.rightChild != null) {
    		// 오른쪽 서브트리의 최소값을 찾음
    		TreeNode successor = inOrderSuccessor(current);
    		if(current == root) {
    			root = successor;
    		} else if(isLeftChild) {
    			parent.leftChild = successor;
    		} else {
    			parent.rightChild = successor;
    		}
    		successor.leftChild = current.leftChild;
    	}
    }
}

public class BinarySearchTree {

    public static void main(String[] args) {
        Tree t = new Tree();
        Scanner sc = new Scanner(System.in);
        int select = 0;

        while (select != 6) {
            System.out.print("BinarySearchTree. Select 1:Insert, 2. Delete, 3:preorder, 4:inorder, 5. postorder, 6. Quit => ");
            select = sc.nextInt();
            switch (select) {
                case 1: // insert
                    System.out.print("The number of items = ");
                    int num = sc.nextInt();
                    int[] input = new int[num];
                    for (int i = 0; i < num; i++) {
                        input[i] = (int)(Math.random() * 30);
                        t.insert(input[i]);
                    }
                    System.out.println();

                    break;
                case 2: // Delete
                	System.out.print("The number to delete = ");
                	t.delete(sc.nextInt());
                    break;
                case 3:
                    t.preOrder();
                    System.out.println();
                    break;
                case 4:
                    t.inOrder();
                    System.out.println();
                    break;
                case 5:
                    t.postOrder();
                    System.out.println();
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