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
            boolean leftBothNull = this.left == null && bt.left == null;
            boolean rightBothNull = this.right == null && bt.right == null;
//            boolean onlyOneNull =
            if (leftBothNull && rightBothNull){
                return this.value == bt.value;
            } else if (leftBothNull && this.right != null && bt.right != null) {
                boolean rightIsEqual = this.right.equals(bt.right);
                boolean valuesAreEqual = (this.value == bt.value);
                return rightIsEqual && valuesAreEqual;
            } else if (leftBothNull && ( this.right != null && bt.right == null )) {

            }

            if (leftBothNull){
                if (rightBothNull){
                    return this.value == bt.value;
                }
                else if (this.right != null && bt.right != null){
                    boolean rightIsEqual = this.right.equals(bt.right);
                    boolean valuesAreEqual = (this.value == bt.value);
                    return rightIsEqual && valuesAreEqual;
                }
                else{
                    return false;
                }
            }

            if (rightBothNull){
                if (leftBothNull){
                    return this.value == bt.value;
                }else if (this.left !=null && bt.left != null){
                    boolean leftIsEqual = this.left.equals(bt.left);
                    boolean valuesAreEqual = (this.value == bt.value);
                    return leftIsEqual && valuesAreEqual;
                }else{
                    return false;
                }
            }

            if (this.left == null && bt.left != null){
                return false;
            }
            if (this.right == null && bt.right != null){
                return false;
            }

            boolean valuesAreEqual = (this.value == bt.value);
            boolean leftIsEqual = this.left.equals(bt.left);
            boolean rightIsEqual = this.right.equals(bt.right);
            return valuesAreEqual && leftIsEqual && rightIsEqual;

        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(50, null, null);

    }

}

