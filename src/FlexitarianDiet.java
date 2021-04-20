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

    public FlexitarianDiet(String name, int daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan, float maxMeatGramsPerWeek) {
        super(name, daysDuration, purpose, allowedFood, isVegan);
        this.maxMeatGramsPerWeek = maxMeatGramsPerWeek;
    }

    public Food getPreferredMeat() {
        return preferredMeat;
    }

    public float getMaxMeatGramsPerWeek() {
        return maxMeatGramsPerWeek;
    }

    public boolean preferredMeatVeganAndFoodTypeProteinOrNot(FlexitarianDiet d, Food f) {
        if (!d.getPreferredMeat().isVegan() && f.getType() == FoodType.PROTEIN) {
            System.out.println("The preferred meat in FlexitarianDiet is not vegan and is of FoodType Protein, ENJOY! =)");
            return true;
        } else {
            throw new IllegalArgumentException("ERROR! The preferred meat in a FlexitarianDiet MUST be non-vegan of protein type.");
        }
    }

    //Method For Extra Requirement: maxMeatGramsPerWeek can't exceed 500g
    public boolean maxMeatGramsPerWeek(FlexitarianDiet d) {
        if (d.getMaxMeatGramsPerWeek() > 500) {
            System.out.println("A flexitarian diet can't contain more than 500 grams of meat per week. An " +
                    "exception is thrown as expected.");
            throw new IllegalArgumentException();
        }
        System.out.println("This amount of meat per week is fine.");
        return true;
    }

}
