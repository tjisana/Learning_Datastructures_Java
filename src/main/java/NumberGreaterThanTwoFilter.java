public class NumberGreaterThanTwoFilter implements Filter<Integer> {
    public boolean apply(Integer i) {
        return i > 2;
    }
}
