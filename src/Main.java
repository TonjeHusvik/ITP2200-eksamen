import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // start the diets, persons  and foods containers here
        System.out.println("Hello dear dietary-person, for which diet do you seek? Please choose from the menu below our options.");
        startMenu();
        Container.loadPersons();
        Container.loadDiets();
        Container.loadFoods();
    }

    public static Scanner scanner = new Scanner(System.in);



    private static void startMenu() {
        while(true) {
            System.out.println("MENU:\n 1. Make a diet for yourself.\n 3. Show diets. \n 3. Show persons. \n 4. Show foods. \n 5. Show the menu again.");
            int selectedItem = scanner.nextInt();
            scanner.nextLine();

            switch (selectedItem) {
                /*case 1: dietMaker();
                    break;*/
                case 2: showDiets();
                    break;
                case 3: showPersons();
                    break;
                case 4: showFoods();
                    break;
                case 5: startMenu();
                    break;
                default:
                    System.out.println("Input is not recognized, please choose an input from 1-5.");
                    break;
            }
        }

    }

    private static void showDiets() {
        System.out.println("DIET");
    }

    private static void showPersons() {
        System.out.println("PERSON");
    }

    private static void showFoods() {
        Container.loadFoods();
    }
}
