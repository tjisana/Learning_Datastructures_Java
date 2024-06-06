

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class LinkedListTest {

    @Test
    public void test_insertAtEnd(){
        //Arrange
        LinkedListTK linkedListTK = new LinkedListTK();
        List<Integer> expectedList = Arrays.asList(5,2,7,1);

        //Act
        linkedListTK.insert(5);
        linkedListTK.insert(2);
        linkedListTK.insert(7);
        linkedListTK.insert(1);


        //Assert
        List<Integer> actualList = linkedListTK.convertToList();
        assertEquals(expectedList, actualList);

    }

    @Test
    public void test_insertMiddle(){
        //Arrange
        LinkedListTK linkedListTK = new LinkedListTK();
        List<Integer> expectedList = Arrays.asList(5,2,7,1);

        //Act
        linkedListTK.insert(5);
        linkedListTK.insert(7);
        linkedListTK.insert(1);
        linkedListTK.insert(2, 1);

        //Assert
        List<Integer> actualList = linkedListTK.convertToList();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void test_get_returnsEmptyOptionalWhenPassedIndexOutOfBounds(){
        //Arrange
        LinkedListTK linkedListTK = new LinkedListTK();
        Optional<Integer> expectedValue = Optional.empty();
        int index = 7;

        //Act
        linkedListTK.insert(5);
        linkedListTK.insert(2);
        linkedListTK.insert(7);
        linkedListTK.insert(1);

        //Assert
        Optional<Integer> returnOpt = linkedListTK.get(index);
        assertEquals(expectedValue, returnOpt);
    }

    @Test
    public void test_get_returnsFirstElementWhenPassedZero(){
        //Arrange
        LinkedListTK linkedListTK = new LinkedListTK();
        int expectedValue = 5;
        int index = 0;

        //Act
        linkedListTK.insert(5);
        linkedListTK.insert(2);
        linkedListTK.insert(7);
        linkedListTK.insert(1);

        //Assert
        Optional<Integer> returnOpt = linkedListTK.get(index);
        if (returnOpt.isPresent()){
            int returnActual = returnOpt.get();
            assertEquals(expectedValue, returnActual);
        }
        else{
            fail();
        }
    }

    @Test
    public void test_get_returnsSecondElementWhenPassedOne(){
        //Arrange
        LinkedListTK linkedListTK = new LinkedListTK();
        int expectedValue = 2;
        int index = 1;

        //Act
        linkedListTK.insert(5);
        linkedListTK.insert(2);
        linkedListTK.insert(7);
        linkedListTK.insert(1);

        //Assert
        Optional<Integer> returnOpt = linkedListTK.get(index);
        if (returnOpt.isPresent()){
            int returnActual = returnOpt.get();
            assertEquals(expectedValue, returnActual);
        }
        else{
            fail("Received unexpected empty Optional");
        }
    }

    @Test
    public void test_get_returnsThirdElementWhenPassedTwo(){
        //Arrange
        LinkedListTK linkedListTK = new LinkedListTK();
        int expectedValue = 7;
        int index = 2;

        //Act
        linkedListTK.insert(5);
        linkedListTK.insert(2);
        linkedListTK.insert(7);
        linkedListTK.insert(1);

        //Assert
        Optional<Integer> returnOpt = linkedListTK.get(index);
        if (returnOpt.isPresent()){
            int returnActual = returnOpt.get();
            assertEquals(expectedValue, returnActual);
        }
        else{
            fail("Received unexpected empty Optional");
        }
    }

}
