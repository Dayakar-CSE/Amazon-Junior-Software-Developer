public class NoOfDaysInMonth {
    public static void main(String[] args){

        int[] daysInMonth;
        daysInMonth = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] monthNames = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        
        for(int i = 0 ; i < daysInMonth.length ; i++){
            System.out.println(monthNames[i] + ": " + daysInMonth[i] + " days");
        }


    }
}




/*
import java.util.Arrays;
public class Main {
public static void main(String[] arg){
 	// Step 1: Declare an array
        int[] daysInMonth = new int[12];
        // Step 2: Dynamically initialize the array
        daysInMonth[0] = 31; // January
        daysInMonth[1] = 28; // February
        daysInMonth[2] = 31; // March
        daysInMonth[3] = 30; // April
        daysInMonth[4] = 31; // May
        daysInMonth[5] = 30; // June
        daysInMonth[6] = 31; // July
        daysInMonth[7] = 31; // August
        daysInMonth[8] = 30; // September
        daysInMonth[9] = 31; // October
        daysInMonth[10] = 30; //November
        daysInMonth[11] = 31; //December
        // Step 3: Declare an array with the names of the months
        String[] monthNames = { "Jan", "Feb", "Mar", "Apr",
        "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        // Step 4: Print the number of days in each month
         for (int i = 0; i < daysInMonth.length; i++) {
         System.out.println(monthNames[i] + ": " + daysInMonth[i] + " days");
        }
}
}
*/
