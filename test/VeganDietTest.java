import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔

public class VeganDietTest {

    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedInFlexitarian = new ArrayList<>();
    ArrayList<Food> nonAllowedFoodVegan = new ArrayList<>();

    @Before
    public void addFood() {

        // FLEXITARIAN FOOD
        Food flexitarianFood1 = new Food("Tomahawk Steak", 160, false, FoodType.Protein);
        Food flexitarianFood2 = new Food("Tofu", 76, true, FoodType.Protein);
        Food flexitarianFood3 = new Food("Green peas", 81, true, FoodType.Protein);
        allowedInFlexitarian.add(flexitarianFood1);
        allowedInFlexitarian.add(flexitarianFood2);
        allowedInFlexitarian.add(flexitarianFood3);

        // VEGAN FOOD
        Food veganFood1 = new Food("Rice", 130, true, FoodType.Carb);
        Food veganFood2 = new Food("Salad", 20, true, FoodType.Recipe);
        Food veganFood3 = new Food("Tofu", 200, true, FoodType.Protein);
        Food veganFood4 = new Food("Beans", 130, true, FoodType.Carb);
        Food veganFood5 = new Food("Broccoli", 20, true, FoodType.Fiber);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);
        allowedInVegan.add(veganFood5);

        // NON VEGAN FOOD
        Food nonVeganFood1 = new Food("Ribeye", 130, false, FoodType.Protein);
        Food nonVeganFood2 = new Food("Red snapper", 20, false, FoodType.Protein);
        Food nonVeganFood3 = new Food("Broccoli", 20, true, FoodType.Fiber);
        nonAllowedFoodVegan.add(nonVeganFood1);
        nonAllowedFoodVegan.add(nonVeganFood2);
        nonAllowedFoodVegan.add(nonVeganFood3);
    }

    /*** Requirement 1. a: If a diet contains any non-vegan food, it is considered not vegan (i.e., isVegan = false).***/

    // Test if the diet is vegan and if the food is vegan.
    // PASSED✔️
    @Test
    public void requirement1a_1 () {
        Food veganFood5 = new Food("Tofu", 160, true, FoodType.Protein);
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet", allowedInVegan, true, 50);

        assertTrue(veganDiet1.dietRestriction1a());
        assertTrue(veganFood5.isVegan());
    }

    // Test if the diet is non-vegan and if the food is non-vegan.
    // PASSED✔️
    @Test
    public void requirement1a_2 () {
        Food tomahawk = new Food("Tomahawk", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet", allowedInFlexitarian, false, 50, tomahawk);

        assertFalse(flexitarianDiet1.dietRestriction1a());
        assertFalse(tomahawk.isVegan());
    }

    // Test if the diet is vegan and if the food is non-vegan.
    // PASSED✔️
    @Test
    public void requirement1a_3 () {
        Food tomahawk = new Food("Steak", 160, false, FoodType.Protein);
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet", allowedInVegan, true, 50);

        assertTrue(veganDiet1.dietRestriction1a1(veganDiet1));
        assertFalse(tomahawk.isVegan());
    }

    // Test if the diet is non-vegan and if the food is vegan.
    // PASSED✔️
    @Test
    public void requirement1a_4 () {
        Food tofu = new Food("Tofu", 200, true, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet", allowedInFlexitarian, false, 50, tofu);

        assertFalse(flexitarianDiet1.dietRestriction1a());
        assertTrue(tofu.isVegan());
    }

    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 1. c: A VeganDiet cannot contain non-vegan food ***/

    // Testing with all vegan foods
    // Message shows if test fails
    // PASSED✔️
    @Test
    public void requirement1_c() {
        VeganDiet veganDiet = new VeganDiet("VeganDiet", 30, "Vegan Diet",
                allowedInVegan, true, 50);

        assertTrue("Diet contains one or more non-vegan foods", veganDiet.veganDietRestriction1c());
    }

    // Testing with one or more non-vegan foods
    // Message shows if test fails
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_c1() {
        VeganDiet notVeganDiet = new VeganDiet("Not veganDiet", 30, "Vegan Diet",
                nonAllowedFoodVegan, true, 50);

        assertTrue("Diet contains only vegan foods", notVeganDiet.veganDietRestriction1c());
    }
}

