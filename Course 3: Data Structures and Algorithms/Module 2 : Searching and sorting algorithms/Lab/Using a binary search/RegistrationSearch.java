public class RegistrationSearch {

    Registration [] registrations;

    public RegistrationSearch() {
        Database db = new Database();
        registrations = db.getRegistrations();
    }

    public Registration search(String license){

        // TODO 1: Initialize the left index to zero
        int left = 0;

        /* TODO 2: Initialize the the right index to the
                    length of the array minus 1 */
        int right = registrations.length;

        /* TODO 3: Implement the while loop to run until
                   until the left index is greater than the
                   right index  */

        while (left <= right) {

            /* TODO 4: Initialize the local variable middle to the
                     index halfway between the right and left
                     indices. */
            int mid = left + (right-left)/2;

            /* TODO 5: Use the String.compareTo( ) method to
                       compare the Registration object's license
                       at the middle index to the search() method
                       parameter, license. */
            int comparitor = registrations[mid].license.compareTo(license);
            if(comparitor==0) {

            /* TODO 6: Create an IF/ELSE IF/ELSE statement to
                       evaluate compareTo() return value. */

            /* TODO 7: if there is a match, return that
                           Registration object */
                return registrations[mid];
            }

            /* TODO 8: If the Registration license is less, shift
                           the left index to the mid plus 1 */
            if(comparitor < 0) {
                left = mid + 1;
            }
            else {

            /* TODO 9: If the Registration license is greater, shift
                           the right index to the mid minus 1 */
                right = mid - 1;
            }

        }
        return null;

        /* TODO 10: If the loop completes without finding a match return
                   null */
    }

public void printAll( ){
    for(Registration reg : registrations){
        System.out.println(reg);
    }
}
public static void main(String[] args) {

    String license = "GIG-1870";
    RegistrationSearch regSearch = new RegistrationSearch();
    System.out.println();

        /* TODO 11: Call the search() method with a license number to
                    search for. */
    Registration reg = regSearch.search(license);

    // TODO 12: If the registration object is found print it
    if(reg != null){
        System.out.println("Registration found");
        System.out.println(reg);
    }
    else {

        /* TODO 13: If the registration object is not found, print
               an error */
        System.out.println("No registration found with license " + license);
    }


}

}
