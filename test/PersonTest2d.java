import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PersonTest2d {
    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedInLowCarb = new ArrayList<>();
    ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();

    @Before
    public void diets(){
        Food veganFood1 = new Food("Salad", 10, true, FoodType.Fiber);
        allowedInVegan.add(veganFood1);

        Food lowCarbFood1 = new Food("Bacon", 10, false, FoodType.Fat);
        Food lowCarbFood2 = new Food("Pork", 10, false, FoodType.Fat);
        Food lowCarbFood3 = new Food("Peanuts", 10, false, FoodType.Fat);
        Food lowCarbFood4 = new Food("Shellfish", 10, false, FoodType.Fat);
        Food lowCarbFood5 = new Food("Potatoes", 10, false, FoodType.Fat);
        allowedInLowCarb.add(lowCarbFood1);
        allowedInLowCarb.add(lowCarbFood2);
        allowedInLowCarb.add(lowCarbFood3);
        allowedInLowCarb.add(lowCarbFood4);
        allowedInLowCarb.add(lowCarbFood5);

        Food hyperCaloricFood1 = new Food("Bacon", 10, false, FoodType.Fat);
        Food hyperCaloricFood2 = new Food("Butter", 10, false, FoodType.Fat);
        Food hyperCaloricFood3 = new Food("Peanut butter", 10, false, FoodType.Fat);
        Food hyperCaloricFood4 = new Food("Lard", 10, false, FoodType.Fat);
        allowedInHyperCaloric.add(hyperCaloricFood1);
        allowedInHyperCaloric.add(hyperCaloricFood2);
        allowedInHyperCaloric.add(hyperCaloricFood3);
        allowedInHyperCaloric.add(hyperCaloricFood4);
    }
    /* ALT OVER VAR HER FRA FØR */


    /*** Requirement 2. b: Cannot follow HyperCaloricDiet if they weigh more than the limit in maxWeightKg ***/
    //Test if person weight more than the limit set by the diet.
    //PASSED
    @Test
    public void requirement2_d_0() {
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hypercaloric diet", 123, "weight gain",
                allowedInHyperCaloric, false, 100, 6000);
        Person highWeightPerson = new Person(hypercaloricDiet, 120);

        assertFalse(highWeightPerson.personRestriction2d(hypercaloricDiet));
    }

    //Test if person weight less than the limit set by the diet.
    //PASSED

    @Test
    public void requirement2_d_1() {
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hypercaloric diet", 123, "weight gain",
                allowedInHyperCaloric, false, 100, 6000);
        Person highWeightPerson = new Person(hypercaloricDiet, 90);

        assertTrue(highWeightPerson.personRestriction2d(hypercaloricDiet));
    }
}

