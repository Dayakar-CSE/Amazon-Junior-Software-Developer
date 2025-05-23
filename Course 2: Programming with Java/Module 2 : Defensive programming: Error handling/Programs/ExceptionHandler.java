public class ExceptionHandler {
    public static void main(String[] args) {

        try {
            int[] a = {1, 2, 3, 4, 5};
            System.out.println(a[5]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("You are trying to access an element that's out of the index boundary");
        }

        System.out.println("Some more code");
    }
}
