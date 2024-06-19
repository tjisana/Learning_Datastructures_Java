public class BinTree {
    Node root;

    public BinTree(){}
    public BinTree(Node root){
        this.root = root;
    }

    public Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.leftChild = addRecursive(current.leftChild, value);
        } else if (value > current.value) {
            current.rightChild = addRecursive(current.rightChild, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }


    public int getValue(){
        return this.root.value;
    }

    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        binTree.addRecursive(null, 50);
        binTree.addRecursive(binTree.root, 25);
        binTree.addRecursive(binTree.root, 15);
    }
}

class Node {
    int value;
    Node leftChild;
    Node rightChild;

    Node(int value){
        this.value = value;
    }

    Node(int value, Node leftChild, Node rightChild){
        this(value);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String toString(){
        return "Node(" + this.value + ")";
    }
}