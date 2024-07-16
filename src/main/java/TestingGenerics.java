import java.util.ArrayList;
import java.util.List;

public class TestingGenerics {


    public static void main(String[] args) {
        String[] strs = new String[10];
        List<String> listG = new ArrayList<String>(10);
//        test(strs);
//        test(listG);
        List<Object> listObjects = new ArrayList<>(1000);
        listObjects.add("hello");
//        testG(listObjects);

//        Object o = getItem(listObjects, 0);
//        System.out.println(o);

        Object o = getItem(listObjects, 1);
        System.out.println(o);
    }

    public static void test(Object[] objs){
        objs[0] = 10;
    }

    public static void testG(List<Object> objs){
        objs.add(5);
        System.out.println(objs.get(1000));
    }

    public static Object getItem(List<Object> objs, int index){
        return objs.get(index);
    }

}
