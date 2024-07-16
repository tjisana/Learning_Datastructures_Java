import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private final int value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int value, BinaryTree left, BinaryTree right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue(){
        return value;
    }

    public void setLeft(int value, BinaryTree left, BinaryTree right){
        this.left = new BinaryTree(value, left, right);
    }

    public void setRight(int value, BinaryTree left, BinaryTree right){
        this.right = new BinaryTree(value, left, right);
    }


    public String toString() {
        return "BT(" + this.value + ")";
    }


    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        else if (!(o instanceof BinaryTree)) {
            return false;
        }
        else{
            BinaryTree bt = (BinaryTree) o;
            return check(this, bt);
        }
    }

    private boolean check(BinaryTree binaryTreeLeft, BinaryTree binaryTreeRight){
        if (binaryTreeLeft == null && binaryTreeRight == null && binaryTreeLeft.value == binaryTreeRight.value){
            return true;
        }
        if (binaryTreeLeft != null && binaryTreeRight != null){
            boolean valuesEqual = binaryTreeLeft.getValue() == binaryTreeRight.getValue();
            boolean bothLeftEqual = check(binaryTreeLeft.left, binaryTreeRight.left);
            boolean bothRightEqual = check(binaryTreeLeft.right, binaryTreeRight.right);
            return valuesEqual && bothLeftEqual && bothRightEqual;
        }
        return false;
    }

    public String breadthFirstPrint(){
        StringBuilder output = new StringBuilder();

        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(this);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            BinaryTree tempBT = queue.poll();
            System.out.print(tempBT.value + " ");
            output.append(tempBT.value).append(" ");

            // Enqueue left child
            if (tempBT.left != null) {
                queue.add(tempBT.left);
            }

            // Enqueue right child
            if (tempBT.right != null) {
                queue.add(tempBT.right);
            }
        }

        return output.toString();
    }

    public String postorderTraversalPrint(){
        StringBuilder output = new StringBuilder();
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            BinaryTree tempBT = stack.pop();
            output.append(tempBT.value).append(" ");

            if (tempBT.left != null) stack.push(tempBT.left);
            if (tempBT.right != null) stack.push(tempBT.right);
        }
        return output.toString();
    }
}

