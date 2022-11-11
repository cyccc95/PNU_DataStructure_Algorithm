package ch07;

import java.util.Scanner;

class Student {
	  static final int NO   = 1;        // 번호를 읽어 들일까요?
	  static final int NAME = 2;        // 이름을 읽어 들일까요?

	  public Integer no;                      // 회원번호(키값)
	  public String  name;                    // 이름

	  //--- 문자열 표현을 반환 ---//
	  public String toString() {
	      return "(" + this.no + ") " + this.name + " ";
	  }
	  public Student(Integer snum, String sname) {
	  	this.no = snum; this.name = sname;
	  }
	  public Student(Student s) {
	  	this.no = s.no; this.name = s.name;
	  }
	  public Student() {
	  	this.no = null; this.name = null;
	  }

}

class TreeNode2 {
	public Student data;
	public TreeNode2 leftChild;
	public TreeNode2 rightChild;

	public TreeNode2(Student data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
}

class Tree2 {
	private TreeNode2 root;

	Tree2() {
		this.root = null;
	}
	TreeNode2 inOrderSuccessor(TreeNode2 current) {
		TreeNode2 temp = current.rightChild;
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

	void preOrder(TreeNode2 CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data.toString());
			preOrder(CurrentNode.leftChild);
			preOrder(CurrentNode.rightChild);
		}
	}

	void inOrder(TreeNode2 CurrentNode) {
		if (CurrentNode != null) {
			inOrder(CurrentNode.leftChild);
			System.out.print(CurrentNode.data.toString());
			inOrder(CurrentNode.rightChild);
		}
	}

	void postOrder(TreeNode2 CurrentNode) {
		if (CurrentNode != null) {
			postOrder(CurrentNode.leftChild);
			postOrder(CurrentNode.rightChild);
			System.out.print(CurrentNode.data.toString());
		}
	}

	void insert(Student input) {// binary search tree를 만드는 입력
		TreeNode2 newNode = new TreeNode2(input);
		if(root == null) {
			root = newNode;
			System.out.printf("Insert : (%d) %s\n",input.no, input.name);
			return;
		}
		TreeNode2 current = root;
		TreeNode2 parent = null;
		while(true) {
			parent = current;
			if(input.no == current.data.no) {
				if(input.name.compareTo(current.data.name) == 0) {
					System.out.printf("Insert Dulicate Student : (%d) %s\n",input.no,input.name);
					return;					
				} else if(input.name.compareTo(current.data.name) < 0){
					current = current.leftChild;
	                if (current == null){
	                    parent.leftChild = newNode;
	                    System.out.printf("Insert : (%d) %s\n",input.no,input.name);
	                    return;
	                }
				} else {
					current = current.rightChild;
	                if (current == null){
	                    parent.rightChild = newNode;
	                    System.out.printf("Insert : (%d) %s\n",input.no,input.name);
	                    return;
	                }	
				}
			} else if(input.no < current.data.no) {
				current = current.leftChild;
                if (current == null){
                    parent.leftChild = newNode;
                    System.out.printf("Insert : (%d) %s\n",input.no,input.name);
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null){
                    parent.rightChild = newNode;
                    System.out.printf("Insert : (%d) %s\n",input.no,input.name);
                    return;
                }
            }
		}
	}

	void delete(Student x) {// binary search tree에서 x가 있으면 삭제하는 구현
		TreeNode2 parent = root;
    	TreeNode2 current = root;
    	boolean isLeftChild = false;
    	// x를 찾는 과정
    	while(current.data.no != x.no || current.data.name.compareTo(x.name) != 0) {
    		parent = current;
    		if (current.data.no > x.no) {
				isLeftChild = true;
				current = current.leftChild;
			} else if (current.data.no < x.no){
				isLeftChild = false;
				current = current.rightChild;
			} else if(current.data.no == x.no && current.data.name.compareTo(x.name) > 0) {
				isLeftChild = true;
				current = current.leftChild;
			} else if (current.data.no == x.no && current.data.name.compareTo(x.name) < 0){
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {
				System.out.printf("(%d) %s는 tree에 없습니다.\n",x.no,x.name);
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
    		TreeNode2 successor = inOrderSuccessor(current);
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

public class BinarySearchTreeObject {
	public static void main(String[] args) {
		Tree2 t = new Tree2();
		Scanner sc = new Scanner(System.in);
		int select = 0;
		
		while (select != 6) {
			System.out.print("BinarySearchTree. Select 1:Insert, 2. Delete, 3:preorder, 4:inorder, 5. postorder, 6. Quit => ");
			select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.print("The number of students = ");
				int num = sc.nextInt();
				Student[] input = new Student[num];
				for (int i = 0; i < num; i++) {
					Student st = new Student();
					System.out.print("The number to insert : ");
					st.no = sc.nextInt();
					System.out.print("The name to insert : ");
					st.name = sc.next();
					input[i] = st;
					t.insert(input[i]);
				}
				System.out.println();
				break;
			case 2:	// Delete
				Student st = new Student();
				System.out.print("The number to delete = ");
				st.no = sc.nextInt();
				System.out.print("The name to delete = ");
				st.name = sc.next();
				t.delete(st);
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
				System.out.println("WRONG INPUT  ");
				System.out.println("Re-Enter");
				break;
			}
		}
	}
}
