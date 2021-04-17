import java.util.ArrayList;

public class VeganDiet extends Diet{
    private float minWeightKg;


    public VeganDiet(String name, int daysDuration, String purpose,
                     ArrayList<Food> allowedFood,
                     boolean isVegan, float minWeightKg) {
        super(name, daysDuration, purpose, allowedFood, isVegan);
        this.minWeightKg = minWeightKg;
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

}
