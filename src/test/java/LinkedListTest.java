

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class LinkedListTest {

    private List<Integer> expectedList;
    private LinkedListTK linkedListTK;

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(5, 0),
                Arguments.of(2, 1),
                Arguments.of(7, 2),
                Arguments.of(1, 3)
        );
    }

    @BeforeEach
    public void init(){
        expectedList = Arrays.asList(5,2,7,1);
        linkedListTK = new LinkedListTK();
    }

    @Test
    public void test_insertAtEnd(){
        //Arrange

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

    @ParameterizedTest(name = " Index {1} Returns {0} ")
    @MethodSource("data")
    public void test_get_returnsCorrectElementWhenPassedIndex(int expectedValue, int index){
        //Arrange


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
            fail("Did not return first element");
        }
    }

    @Test
    public void test_SingleElementLinkedListIsReversed(){
        //Arrange
        expectedList = Arrays.asList(1);

        //Act
        linkedListTK.insert(1);
        linkedListTK.reverse_iteration();

        //Assert
        assertEquals(expectedList, linkedListTK.convertToList());
    }

    @Test
    public void test_SingleElementLinkedListIsReversed_recursive(){
        //Arrange
        expectedList = Arrays.asList(1);

        //Act
        linkedListTK.insert(1);
        linkedListTK.reverse_recurive();

        //Assert
        assertEquals(expectedList, linkedListTK.convertToList());
    }

    @Test
    public void test_NullLinkedListIsReversed_recursive(){
        //Arrange
        linkedListTK = new LinkedListTK();

        //Act
        linkedListTK.reverse_recurive();

        //Assert
//        assertEquals(expectedList, linkedListTK.convertToList());
    }

    @Test
    public void test_TwoElementLinkedListIsReversed(){
        //Arrange
        expectedList = Arrays.asList(1, 7);

        //Act
        linkedListTK.insert(7);
        linkedListTK.insert(1);
        linkedListTK.reverse_iteration();

        //Assert
        assertEquals(expectedList, linkedListTK.convertToList());
    }

    @Test
    public void test_TwoElementLinkedListIsReversed_recursive(){
        //Arrange
        expectedList = Arrays.asList(1, 7);

        //Act
        linkedListTK.insert(7);
        linkedListTK.insert(1);
        linkedListTK.reverse_recurive();

        //Assert
        assertEquals(expectedList, linkedListTK.convertToList());
    }

    @Test
    public void test_FiveElementLinkedListIsReversed(){
        //Arrange
        expectedList = Arrays.asList(5, 4, 3, 2, 1);

        //Act
        linkedListTK.insert(1);
        linkedListTK.insert(2);
        linkedListTK.insert(3);
        linkedListTK.insert(4);
        linkedListTK.insert(5);
        linkedListTK.reverse_iteration();

        //Assert
        assertEquals(expectedList, linkedListTK.convertToList());
    }

    @Test
    public void test_FiveElementLinkedListIsReversed_recursive(){
        //Arrange
        expectedList = Arrays.asList(5, 4, 3, 2, 1);

        //Act
        linkedListTK.insert(1);
        linkedListTK.insert(2);
        linkedListTK.insert(3);
        linkedListTK.insert(4);
        linkedListTK.insert(5);
        linkedListTK.reverse_iteration();

        //Assert
        assertEquals(expectedList, linkedListTK.convertToList());
    }

}
