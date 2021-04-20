import java.util.ArrayList;

public class Food {
    private String name;
    private float caloriesPer100g;
    private boolean isVegan;
    private FoodType type;

    public Food(String name, float caloriesPer100g, boolean isVegan, FoodType type) {
        this.name = name;
        this.caloriesPer100g = caloriesPer100g;
        this.isVegan = isVegan;
        this.type = type;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public FoodType getType() {
        return type;
    }

    public float getCaloriesPer100g() {
        return caloriesPer100g;
    }

    @Override
    public String toString() {
        return name;
    }

    //Method For Extra Requirement: a food can't have 0 or a negative amount of calories per 100g
    public boolean atLeastOneCalorie() {
        if (getCaloriesPer100g() <= 0) {
            System.out.println("A food must have at least 1 calorie per 100g. An exception is thrown as expected.");
            throw new IllegalArgumentException();
        }
        System.out.println("This food has at least the minimum required amount of calories per 100g.");
        return true;
    }
}
