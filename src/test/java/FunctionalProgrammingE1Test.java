import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalProgrammingE1Test {

    public ArrayList<Integer> data;
    public ArrayList<String> strData;

    @BeforeEach
    public void setup(){
        data = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        strData = new ArrayList<>(Arrays.asList("The","quick","brown","fox","jumps","over","the","lazy","dog"));
    }

    @Test
    public void test_noFilterReturnsUnChangedList() {
        //Arrange
        ArrayList<Integer> expected = data;
        ArrayList<Filter<Integer>> filters = new ArrayList<>();
        FunctionalProgrammingE1<Integer> fp = new FunctionalProgrammingE1<>();
        fp.arrayList = expected;

        //Act
        ArrayList<Integer> actual = fp.filter();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_FilterReturnsNumbersLessThanEight_WhenPassedFilterForNumbersLessThanEight() {
        //Arrange
        ArrayList<Integer> initialData = data;
        ArrayList<Filter<Integer>> filters = new ArrayList<>();
        Filter<Integer> numlessthan8 = new NumberLessThanEightFilter();

        FunctionalProgrammingE1<Integer> fp = new FunctionalProgrammingE1<>();
        fp.arrayList = initialData;

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

        //Act
        ArrayList<Integer> actual = fp.filter(numlessthan8);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_FilterReturnsNumbersLessThanEightAndGreaterThanTwo_WhenPassedAppropriateFiltersForNumbersLessThanEightAndGreaterThanTwo() {
        //Arrange
        ArrayList<Integer> initialData = new ArrayList<>();
        ArrayList<Filter<Integer>> filters = new ArrayList<>();

        Filter<Integer> numlessthan8 = new NumberLessThanEightFilter();
        Filter<Integer> numGT2 = new NumberGreaterThanTwoFilter();

        FunctionalProgrammingE1<Integer> fp = new FunctionalProgrammingE1<Integer>();
        fp.arrayList = data;
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

        //Act
        ArrayList<Integer> actual = fp.filter(numlessthan8, numGT2);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_FilterReturnsNumbersLessThanEightAndGreaterThanTwo_WhenPassedAppropriateFiltersForNumbersLessThanEightAndGreaterThanTwo_UsingLambdas() {
        //Arrange
        ArrayList<Filter<Integer>> filters = new ArrayList<>();

//        Filter<Integer> numlessthan8 = new NumberLessThanEightFilter();
//        Filter<Integer> numGT2 = new NumberGreaterThanTwoFilter();
//        filters.add((i) -> i>2);

        FunctionalProgrammingE1<Integer> fp = new FunctionalProgrammingE1<Integer>();
        fp.arrayList = data;
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

        //Act
        ArrayList<Integer> actual = fp.filter((i) -> i<8 && i>2);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_FilterReturnsAllWordContaining_TheLetter_O(){
        //Arrange
        List<String> expected = Arrays.asList("brown", "fox", "over", "dog");
        FunctionalProgrammingE1<String> functionalProgrammingE1 = new FunctionalProgrammingE1<>();
        functionalProgrammingE1.arrayList = strData;

        //Act
        List<String> actual  = functionalProgrammingE1.filter((i) -> i.contains("o"));

        //Assert
        assertEquals(expected, actual);
    }
}
