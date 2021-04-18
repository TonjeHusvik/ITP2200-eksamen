import java.util.ArrayList;
import java.util.Random;

public class DietManager{

    public boolean areCompatibleVegan(Person p, VeganDiet v) {
        if (v.foodInDietVeganAndDietVeganOrNot(v) && p.favoriteFoodVeganAndDietVeganOrNot() && p.personAllergicToHalfOrMoreFoodsInDiet(p, v)
                && p.weightLessThanVeganDietMinimumOrNot(v)) {
            return true;
        } else throw new IllegalArgumentException("ERROR! The Person and the Diet is not compatible.");
    }

    public boolean areCompatibleLowCarb(Person p, LowCarbDiet l) {
        if (l.lessThanTwoCarbsOrNot() && l.foodInDietVeganOrNot() && p.checkAllergiesAgainstDietFoods(p, l)
                && p.weightLessThanLowCarbDietMinimumOrNot(l)) {
            return true;
        } else throw new IllegalArgumentException("ERROR! The Person and the Diet is not compatible.");
    }

    public boolean areCompatibleFlexitarian(Person p, FlexitarianDiet f, Food food) {
        if (p.personAllergicToHalfOrMoreFoodsInDiet(p, f) && f.preferredMeatVeganAndFoodTypeProteinOrNot(f, food)) {
            return true;
        } else throw new IllegalArgumentException("ERROR! The Person and the Diet is not compatible.");
    }

    public boolean areCompatibleHypercaloric(Person p, HypercaloricDiet f) {
        if (p.personAllergicToHalfOrMoreFoodsInDiet(p, f) && p.weightMoreThanMaximumOrNot(f)) {
            return true;
        } else throw new IllegalArgumentException("ERROR! The Person and the Diet is not compatible.");
    }


    public HypercaloricDiet randomDiet(Person p, ArrayList<Food> f) {
        int daysDuration = new Random().nextInt(100 + 1) + 1;
        f.removeAll(p.getAllergies());
        float maxWeightKg = new Random().nextFloat() * (p.getWeight() + 20) + p.getWeight();
        int minCaloriesPerDay = new Random().nextInt(2000 + 1) + 2000;
        HypercaloricDiet hyperDiet = new HypercaloricDiet("Hypercaloric", daysDuration, "Random diet",
                f, true, maxWeightKg, minCaloriesPerDay);
        for (Food food : f) {
            if (!food.isVegan()) {
                hyperDiet.setVegan(false);
            }
        }
        return hyperDiet;
    }
}
