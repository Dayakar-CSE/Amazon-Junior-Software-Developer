public class Main {
    public static void main(String[] args) {
        String[] superheroes = {"Batman", "Superman", "Wonder Woman", "Spider-Man", "Iron Man"};
        int[] introductionYears = {1939, 1938, 1941, 1962, 1963};

        System.out.println("Superhero Names:");
        System.out.println(superheroes[0]);
        System.out.println(superheroes[1]);
        System.out.println(superheroes[2]);
        System.out.println(superheroes[3]);
        System.out.println(superheroes[4]);

        System.out.println("Introduction Years:");
        for(int i = 0 ;i<5;i++){
            System.out.println(introductionYears[i]);
        }

        // Print the original name of the third superhero
        System.out.println("Original superhero name at position 3: " + superheroes[2]);

        // Modify the third superhero name
        superheroes[2] = "Thor";

        // Print the modified name of the third superhero
        System.out.println("Modified superhero name at position 3: " + superheroes[2]);

        // Print the original year of introduction of the third superhero
        System.out.println("Original introduction year for superhero at position 3: " + introductionYears[2]);

        // Modify the year of introduction of the third superhero
        introductionYears[2] = 2011;

        // Print the modified year of introduction of the third superhero
        System.out.println("Modified introduction year for superhero at position 3: " + introductionYears[2]);

        // Print the length of the array containing superhero names
        System.out.println("Total superheros names in String array: " + superheroes.length);

        // Print the length of the array containing superhero year of introduction
        System.out.println("Total superheros introduction year in int array: " + introductionYears.length);
    }
}
