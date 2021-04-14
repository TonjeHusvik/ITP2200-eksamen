import java.util.ArrayList;
import java.util.Random;

public class DietManager{

    // FIXME ikke done, rune
    // FIXME
    public boolean areCompatible(Person p, VeganDiet veganDiet, LowCarbDiet lowCarbDiet, HypercaloricDiet hypercaloricDiet) throws IllegalArgumentException {


        p.personRestriction2a();
        p.personRestriction2b(p, veganDiet);
        p.personRestriction2c_1(veganDiet);
        p.personRestriction2c_2(lowCarbDiet);
        p.personRestriction2d(hypercaloricDiet);

        return true;
/*            while () {
            throw new IllegalArgumentException("The diet and the person is NOT compatible because of ");
        }*/
    }

/*
    (p.getFavouriteFood().isVegan() && d.isVegan()) && (p.getWeight() > d.getMinWeightKg())
*/


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
