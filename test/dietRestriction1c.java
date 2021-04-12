import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class dietRestriction1c {

    ArrayList <Food> allowedFoodVegan = new ArrayList<>();
    ArrayList <Food> nonAllowedFoodVegan = new ArrayList<>();
    VeganDiet veganDiet = new VeganDiet("VeganDiet", 30, "Vegan Diet",
            allowedFoodVegan, true, 50);
    VeganDiet notVeganDiet = new VeganDiet("Not veganDiet", 30, "Vegan Diet",
            nonAllowedFoodVegan, true, 50);

    @Before
    public void setUp() {
        Food veganFood1 = new Food("Cauliflower rice", 23, true, FoodType.Carb);
        Food veganFood2 = new Food("Salad", 20, true, FoodType.Fiber);
        Food veganFood3 = new Food("Tofu", 200, true, FoodType.Protein);
        allowedFoodVegan.add(veganFood1);
        allowedFoodVegan.add(veganFood2);
        allowedFoodVegan.add(veganFood3);

        Food veganFood4 = new Food("Ribeye", 130, false, FoodType.Protein);
        Food veganFood5 = new Food("Red snapper", 20, false, FoodType.Protein);
        Food veganFood6 = new Food("Broccoli", 20, true, FoodType.Fiber);
        nonAllowedFoodVegan.add(veganFood4);
        nonAllowedFoodVegan.add(veganFood5);
        nonAllowedFoodVegan.add(veganFood6);
    }

    //Testing with all vegan foods
    //Message shows if test fails
    @Test
    public void allIsVegan() {
        assertTrue("Diet contains one or more non-vegan foods", veganDiet.veganDietRestriction1c());
    }

    //Testing with one or more non-vegan foods
    //Message shows if test fails
    @Test
    public void notAllIsVegan() {
        assertFalse("Diet contains only vegan foods", notVeganDiet.veganDietRestriction1c());
    }

}
