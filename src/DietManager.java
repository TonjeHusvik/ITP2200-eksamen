import java.util.ArrayList;
import java.util.Random;

public class DietManager{

    public boolean areCompatibleVegan(Person p, VeganDiet v) {
        if (v.dietRestriction1a() && p.personRestriction2a() && p.personRestriction2b(p, v)
                && p.personRestriction2c_1(v)) {
            return true;
        } else throw new IllegalArgumentException("ERROR! The Person and the Diet is not compatible.");
    }

    public boolean areCompatibleLowCarb(Person p, LowCarbDiet l) {
        if (l.lowCarbRestriction1e() && l.dietRestriction1b() && p.personRestriction2b(p, l)
                && p.personRestriction2c_2(l)) {
            return true;
        }
        return false;
    }

    public boolean areCompatibleFlexitarian(Person p, FlexitarianDiet f, Food food) {
        if (p.personRestriction2b(p, f) && f.flexDietRestriction1d(f, food)) {
            return true;
        }
        return false;
    }

    public boolean areCompatibleHypercaloric(Person p, HypercaloricDiet f) {
        if (p.personRestriction2b(p, f) && p.personRestriction2_d(f)) {
            return true;
        }
        return false;
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
