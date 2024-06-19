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
        if (o instanceof BinaryTree){

        }
        if (this == o){
             return true;
        } else if (!(o instanceof BinaryTree)) {
            return false;
        }
        else{
            if (this.left == null){
                return this.value == ((BinaryTree) o).value;
            }
            return this.left.equals(((BinaryTree) o).left) && this.value == ((BinaryTree) o).value;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(50, null, null);

    }

}

