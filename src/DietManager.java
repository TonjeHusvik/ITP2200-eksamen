import java.util.ArrayList;
import java.util.Random;

public class DietManager {

    public boolean areCompatible(Person p, Diet d) {
        // TODO Given a Person and a Diet, return true if they are compatible, false otherwise.
        if (p.getFavouriteFood().isVegan() && d.isVegan()) {
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
