public class FinallyTestFour {

    private static String containsAnE(String word) {
        try {
            return word.contains("E") ? "Contain an E" : "No E found!";
        } catch(NullPointerException e) {
            System.out.println("A NullPointerException occurred!");
            return "Return from catch";
        } finally {
            System.out.println("In the finally block!");
        }
    }

    public static void main(String[] args) {
	   //containsAnE("Hello");
        containsAnE(null);
        System.out.println("More code");
    }
}
