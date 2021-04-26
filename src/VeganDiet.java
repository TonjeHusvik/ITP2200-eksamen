import java.util.ArrayList;

public class VeganDiet extends Diet{
    private final float minWeightKg;


    public VeganDiet(String name, int daysDuration, String purpose,
                     ArrayList<Food> allowedFood,
                     boolean isVegan, float minWeightKg) {
        super(name, daysDuration, purpose, allowedFood, isVegan);
        this.minWeightKg = minWeightKg;
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

    public boolean onlyVeganFoodInDietOrNot() throws IllegalArgumentException {
        for (Food f : getAllowedFood()) {
            if (!f.isVegan()) {
                isVegan = false;
                System.out.println("This is an illegal argument being thrown as expected, " +
                        "because this diet contains non-vegan food.");
                throw new IllegalArgumentException();
            }
        }
        System.out.println("This diet is vegan");
        return true;
    }
}
