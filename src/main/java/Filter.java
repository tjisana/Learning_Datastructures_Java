@FunctionalInterface
public interface Filter<T> {
    public boolean apply(T t);
}
