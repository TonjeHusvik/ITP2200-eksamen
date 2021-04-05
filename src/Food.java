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

    public void foodContainer(){
        ArrayList<Food> allFoods = new ArrayList<>();
        allFoods.add(new Food("Carrot", 41, true, FoodType.Recipe));
        allFoods.add(new Food("Beef", 250, false, FoodType.Protein));
        allFoods.add(new Food("Rice", 130, true, FoodType.Carb));
        allFoods.add(new Food("Cocoa Butter", 884, true, FoodType.Fat));
    }


    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setCaloriesPer100g(float caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }
}
