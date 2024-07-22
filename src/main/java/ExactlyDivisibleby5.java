import java.util.function.Predicate;

public class ExactlyDivisibleby5 implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        return false;
    }

//    @Override
//    public Predicate<Integer> and(Predicate<? super Integer> other) {
//        return Predicate.super.and(other);
//    }
//
//    @Override
//    public Predicate<Integer> negate() {
//        return Predicate.super.negate();
//    }
//
//    @Override
//    public Predicate<Integer> or(Predicate<? super Integer> other) {
//        return Predicate.super.or(other);
//    }
}
