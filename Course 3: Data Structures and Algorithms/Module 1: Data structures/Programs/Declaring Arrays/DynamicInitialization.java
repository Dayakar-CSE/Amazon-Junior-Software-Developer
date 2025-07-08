public class DynamicInitialization {
    public static void main(String[] arg) {
/ Initialize an array for 30 seats
        int[] seats = new int[30];
// Assign values: 1 for balcony, 2 for premium seats , 3 for standard seats
        for (int i = 0; i < seats.length; i++) {
// First 5 seats are balcony
            if (i < 5) {
                seats[i] = 1;
            } else if (i < 15) {
                seats[i] = 2; // Next 10 seats are premium seats
            } else {
                seats[i] = 3; // Remaining seats are standard seats
            }
        }
    }
}
