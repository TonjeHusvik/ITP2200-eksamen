import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Food[] foodArray = new Food[5];
        foodArray[0] = new Food("Salmon", 50, false, FoodType.Protein);
        foodArray[1] = new Food("Leek", 50, true, FoodType.Carb);
        foodArray[2] = new Food("Beef", 50, false, FoodType.Protein);
        foodArray[3] = new Food("Egg", 50, false, FoodType.Protein);
        foodArray[4] = new Food("Avocado", 50, true, FoodType.Fat);

        VeganDiet veganD = new VeganDiet(2345, "climate issues", foodArray, true, 60);
        System.out.println(veganD.writeAllowedFood());
        System.out.println(veganD.writeDuration());
        }

    }
