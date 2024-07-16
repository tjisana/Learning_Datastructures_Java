import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListTJTest {

    @Test
    public void testInitialSizeIsTen() {
        //Arrange
        ArrayListTJ<Integer> arrayListTJ = new ArrayListTJ<>();
        int expected = 10;

        //Act
        int actual = arrayListTJ.getInitialSize();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testSizeReturnsSizeOneWhenOneElementIsAdded() {
        //Arrange
        ArrayListTJ<Integer> arrayListTJ = new ArrayListTJ<>();
        int expected = 1;

        //Act
        arrayListTJ.add(23);
        int actual = arrayListTJ.getSize();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testFirstElementRetrievedEqualsFirstElementAdded(){
        //Arrange
        ArrayListTJ<Integer> arrayListTJ = new ArrayListTJ<>();
        int expected = 23;
        int index = 0;

        //Act
        arrayListTJ.add(expected);
        int actual = arrayListTJ.get(index);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testFirstElementRetrievedEqualsFirstElementAdded_String(){
        //Arrange
        ArrayListTJ<String> arrayListTJ = new ArrayListTJ<>();
        String expected = "Hello";
        int index = 0;

        //Act
        arrayListTJ.add(expected);
        String  actual = arrayListTJ.get(index);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testInitializeWithArray(){
        //Arrange
        Integer[] initialArray = new Integer[] {10,20,30,40,50,60,71,80,90,91};
        ArrayListTJ<Integer> arrayListTJ = new ArrayListTJ<>(10, initialArray);

        //Act
        //Assert
        for(int i = 0; i < initialArray.length; i++){
            assertEquals(initialArray[i], arrayListTJ.get(i));
        }
    }

    @Test
    public void test_InitialSizeExceeded(){
        //Arrange
        Integer[] initialArray = new Integer[] {10,20,30,40,50,60,71,80,90,91};
        ArrayListTJ<Integer> arrayListTJ = new ArrayListTJ<>(10, initialArray);
        int newCapacity = 20;
        int newSize = 11;

        //Act
        arrayListTJ.add(10);

        //Assert
        assertEquals(newSize, arrayListTJ.getSize());
        assertEquals(newCapacity, arrayListTJ.getCurrentCapacity());
    }
}
