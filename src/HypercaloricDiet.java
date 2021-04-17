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

    public float getMinCaloriesPerDay() {
        return minCaloriesPerDay;
    }

    @Override
    public String toString() {
        return "Diet: " + getName() + "\r\n" + "Lasts for: " + getDaysDuration() + " days" +
        "\r\n" + "Purpose: " + getPurpose() + "\r\n" + "Allowed food: " + getAllowedFood().toString() + "\r\n" +
        "Vegan: " + isVegan() + "\r\n" + "Max weight: " + getMaxWeightKg() + "\r\n" + "Minimum calories per day: " + getMinCaloriesPerDay();
    }
}
