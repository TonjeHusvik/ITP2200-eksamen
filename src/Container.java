import java.util.ArrayList;
import java.util.Arrays;

public class Container {


    public static ArrayList<Person> persons = new ArrayList<>();
    public static ArrayList<Diet> diets = new ArrayList<>();
    public static ArrayList<Food> foods = new ArrayList<>();

    public static void loadPersons() {
        System.out.println("Loading persons...");


    }

    public static void loadDiets() {
        System.out.println("Loading diets...");
    }

    public static void loadFoods() {
        System.out.println("Loading foods...");
        foods.add(new Food("Carrot", 41, true, FoodType.Recipe));
        foods.add(new Food("Beef", 250, false, FoodType.Protein));
        foods.add(new Food("Rice", 130, true, FoodType.Carb));
        foods.add(new Food("Cocoa Butter", 884, true, FoodType.Fat));

        System.out.println(foods);
    }
}
