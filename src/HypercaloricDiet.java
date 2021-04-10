import java.util.ArrayList;

public class HypercaloricDiet extends Diet{
    private float maxWeightKg;
    private float minCaloriesPerDay;

    public HypercaloricDiet(String name, int daysDuration, String purpose,
                            ArrayList<Food> allowedFood, boolean isVegan,
                            float maxWeightKg, float minCaloriesPerDay) {
        super(name, daysDuration, purpose, allowedFood, isVegan);
        this.maxWeightKg = maxWeightKg;
        this.minCaloriesPerDay = minCaloriesPerDay;
    }

    public float getMaxWeightKg() {
        return maxWeightKg;
    }

    public void setMaxWeightKg(float maxWeightKg) {
        this.maxWeightKg = maxWeightKg;
    }

    public float getMinCaloriesPerDay() {
        return minCaloriesPerDay;
    }

    public void setMinCaloriesPerDay(float minCaloriesPerDay) {
        this.minCaloriesPerDay = minCaloriesPerDay;
    }
}
