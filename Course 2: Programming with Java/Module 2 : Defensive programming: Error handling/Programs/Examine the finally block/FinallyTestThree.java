public class FinallyTestThree {
    public static void main(String[] args) {
        try {
            int[] array = {10, 20, 30, 40, 50};
            System.out.println(array[5]);
        } catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("In the finally block!");
        }

        System.out.println("More code");
    }
}
