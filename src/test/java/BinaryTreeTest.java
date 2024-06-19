import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BinaryTreeTest {

    @Test
    public void test_BinaryTreeConstructorCreatesANodeWithCorrectValue(){
        //Arrange
        int expectedValue = 10;
        BinaryTree binaryTree = new BinaryTree(expectedValue, null, null);

        //Act
        int actualValue = binaryTree.getValue();

        //Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void test_twoBinaryTreesWithSameValueAreEqual(){
        //Arrange
        int value = 11;
        BinaryTree binaryTree = new BinaryTree(value, null, null);
        BinaryTree binaryTree1 = new BinaryTree(value, null, null);

        //Act

        //Assert
        assertEquals(binaryTree, binaryTree1);
    }

    @Test
    public void test_twoBinaryTreesWithDifferentValueAreNotEqual(){
        //Arrange
        int value = 11;
        int value1 = 12;
        BinaryTree binaryTree = new BinaryTree(value, null, null);
        BinaryTree binaryTree1 = new BinaryTree(value1, null, null);

        //Act

        //Assert
        assertNotEquals(binaryTree, binaryTree1);
    }

    @Test
    public void test_twoBinaryTreesWithSameValueAndLeftChildValueAreEqual(){
        //Arrange
        int value = 10;
        int leftValue = 11;

        BinaryTree binaryTree = new BinaryTree(value, null, null);
        binaryTree.setLeft(leftValue, null, null);
        BinaryTree binaryTree1 = new BinaryTree(value, null, null);
        binaryTree1.setLeft(leftValue, null, null);

        //Act

        //Assert
        assertEquals(binaryTree, binaryTree1);
    }

    @Test
    public void test_twoBinaryTreesWithSameValueAndDifferentLeftChildValueAreNotEqual(){
        //Arrange
        int value = 10;
        int leftValue = 11;
        int leftValue1 = 21;

        BinaryTree binaryTree = new BinaryTree(value, null, null);
        binaryTree.setLeft(leftValue, null, null);
        BinaryTree binaryTree1 = new BinaryTree(value, null, null);
        binaryTree1.setLeft(leftValue1, null, null);

        //Act

        //Assert
        assertNotEquals(binaryTree, binaryTree1);
    }
}
