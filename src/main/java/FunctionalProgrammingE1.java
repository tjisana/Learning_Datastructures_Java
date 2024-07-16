import java.util.ArrayList;
import java.util.List;

public class FunctionalProgrammingE1<T> {
    ArrayList<T> arrayList;

    @SafeVarargs
    final ArrayList<T> filter(Filter<T>... filters) {
        if (filters.length == 0){
            return arrayList;
        }

        ArrayList<T> filteredList = new ArrayList<>();

        for (T element : arrayList){
            int count = 0;
            for (Filter<T> filter : filters) {
                if (filter.apply(element)) count++;
            }
            if (count == filters.length) {
                filteredList.add(element);
            }
        }


        return filteredList;
    }

    public static void main(String[] args) {

    }
}
