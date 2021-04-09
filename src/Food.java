<<<<<<< HEAD
import javax.naming.Name;
=======
import java.util.ArrayList;
>>>>>>> origin/main

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

    @Override
    public String toString() {
<<<<<<< HEAD
        return name + " is allowed.";
=======
        return  "name: " + name +
                ", calories per 100g: " + caloriesPer100g +
                ", is it vegan? " + isVegan +
                ", type: " + type + "\n";
>>>>>>> origin/main
    }
}
