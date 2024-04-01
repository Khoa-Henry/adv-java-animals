package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class GatherUserInput {
    Scanner scanner = new Scanner(System.in);

    public GatherUserInput(ArrayList<Talkable> zoo) {
        String animalType = "";

        do {
            if (animalType.equals("dog")) {
                System.out.println("what is the dog's name? ");
                String name = scanner.nextLine();

                System.out.println("Is " + name + " friendly? (y or n)");
                String isFriendly = scanner.nextLine().toLowerCase();

                // Validate user input for isFriendly
                if (!isFriendly.equals("y") && !isFriendly.equals("n")) {
                    System.out.println("Invalid input for friendly! Please enter 'y' or 'n'.");
                    continue; // Restart loop
                }

                zoo.add(new Dog(isFriendly.equals("y"), name));
            } else if (animalType.equals("cat")) {
                System.out.println("what is the cat's name? ");
                String name = scanner.nextLine();

                // Validate user input for number of mouses killed
                int mousesKilled;
                try {
                    System.out.println("How many mouses has " + name + " killed? ");
                    mousesKilled = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for number of mouses killed! Please enter a valid integer.");
                    continue; // Restart loop
                }

                zoo.add(new Cat(mousesKilled, name));
            } else if (!animalType.equals("x")) {
                System.out.println("Invalid input! Try again.");
            }

            System.out.println("What type of animal do you want to create (Dog or Cat)? (x to be done) ");
            animalType = scanner.nextLine().toLowerCase();

        } while (!animalType.equals("x"));

        // default add teacher
        zoo.add(new Teacher(44, "Stacy Read"));
    }
}
