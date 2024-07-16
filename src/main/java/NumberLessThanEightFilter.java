public class NumberLessThanEightFilter implements Filter<Integer> {
    public boolean apply(Integer i) {
        return i < 8;
    }
}
