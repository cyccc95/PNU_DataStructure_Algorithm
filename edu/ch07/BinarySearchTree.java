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