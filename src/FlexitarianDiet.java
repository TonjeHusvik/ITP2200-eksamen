import java.util.ArrayList;

public class FlexitarianDiet extends Diet{
    private float maxMeatGramsPerWeek;
    private Food preferredMeat;

    public FlexitarianDiet(String name, int daysDuration, String purpose,
                           ArrayList<Food> allowedFood, boolean isVegan,
                           float maxMeatGramsPerWeek, Food preferredMeat) {
        super(name, daysDuration, purpose, allowedFood, isVegan);
        this.maxMeatGramsPerWeek = maxMeatGramsPerWeek;
        this.preferredMeat = preferredMeat;
    }

    public Food getPreferredMeat() {
        return preferredMeat;
    }

}
