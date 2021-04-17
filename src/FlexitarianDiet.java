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

    public boolean flexDietRestriction1d(FlexitarianDiet d, Food f) {
        if (!d.getPreferredMeat().isVegan() && f.getType() == FoodType.Protein) {
            System.out.println("The preferred meat in FlexitarianDiet is not vegan and is of FoodType Protein, ENJOY! =)");
            return true;
        } else {
            throw new IllegalArgumentException("ERROR! The preferred meat in a FlexitarianDiet MUST be non-vegan of protein type.");
        }
    }

}
