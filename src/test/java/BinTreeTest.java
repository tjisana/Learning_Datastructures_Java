import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinTreeTest {
    @Test
    public void test_BinaryTreeConstructorCreatesANodeWithCorrectValue(){
        //Arrange
        int expectedValue = 10;
        Node root = new Node(expectedValue);
        BinTree binTree = new BinTree(root);

        //Act
        int actualValue = binTree.getValue();

        //Assert
        assertEquals(expectedValue, actualValue);
    }
}
