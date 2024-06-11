public class Fibon {

    public static void main(String[] args) {
//        System.out.println("Fib 1: " +  fib(1));
//        System.out.println("Fib 2: " +  fib(2));
//        System.out.println("Fib 3: " +  fib(3));
//        System.out.println("Fib 4: " +  fib(4));
        System.out.println("Fib 5: " +  fib(5));
    }

    public static int fib(int i){
        System.out.println("Now calling fib with " + i);
        if (i<=2) return 1;
        return fib(i-1) + fib(i-2);
    }
}
