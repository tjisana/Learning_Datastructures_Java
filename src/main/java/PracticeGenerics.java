public class PracticeGenerics {
//    public static void sumResult(Number val1, Number val2) {
//        Number n = val1.doubleValue();
//    }

//    public static <T extends Number> double sumResult(T val1, T val2) {
//        return val1.doubleValue() + val2.doubleValue();
//    }
//
//    public static <T extends Number> double sumResult(Summable<T> val1, Summable<T> val2) {
//        return val1.getValue().doubleValue() + val2.getValue().doubleValue();
//    }

    public static <T extends A & B> void sumResult(T t) {
        System.out.println(t.getClass());
    }

    public static void main(String[] args) {
        A a = new A(){
            public void a(){
                System.out.println("A");
            }
        };

        C c = new C(){};

        sumResult(c);
    }

}
