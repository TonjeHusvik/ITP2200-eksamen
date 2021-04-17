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
    ArrayList<Food> allowedInVeganImposter = new ArrayList<>();
    ArrayList<Food> allowedInFlexitarianVeganImposter = new ArrayList<>();
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

        // VEGAN IMPOSTER FOOD
        Food veganFoodImposter = new Food("Broccoli", 20, false, FoodType.Fiber);
        allowedInVeganImposter.add(veganFoodImposter);

        // FLEXITARIAN VEGAN IMPOSTER FOOD
        Food flexitarianFoodImposter = new Food("Beef", 20, true, FoodType.Protein);
        allowedInFlexitarianVeganImposter.add(flexitarianFoodImposter);

        // NON VEGAN FOOD
        Food nonVeganFood1 = new Food("Ribeye", 130, false, FoodType.Protein);
        Food nonVeganFood2 = new Food("Red snapper", 20, false, FoodType.Protein);
        Food nonVeganFood3 = new Food("Broccoli", 20, false, FoodType.Fiber);
        nonAllowedFoodVegan.add(nonVeganFood1);
        nonAllowedFoodVegan.add(nonVeganFood2);
        nonAllowedFoodVegan.add(nonVeganFood3);
    }

    /*** Requirement 1. a: If a diet contains any non-vegan food, it is considered not vegan (i.e., isVegan = false).***/

    // Test if the diet is vegan on behalf of the food is vegan.
    // TESTING EVERYTHING IN THE ARRAYLIST IF ITS ALL VEGAN, allowed food is determining and not the isVegan parameter on the diet.
    // PASSED✔️
    @Test
    public void requirement1a_1 () {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet",
                allowedInVegan, false, 50);

        assertTrue(veganDiet1.dietRestriction1a(veganDiet1));
    }

    // Test if the diet is vegan on behalf of the food is vegan.
    // TESTING EVERYTHING IN THE ARRAYLIST IF ITS ALL VEGAN, but it is not because of the imposter food.
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1a_1Exception () {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet",
                allowedInVeganImposter, true, 50);

        assertTrue(veganDiet1.dietRestriction1a(veganDiet1));
    }

    // Test when the diet is non-vegan and when the food is vegan, allowed food is determinant
    // PASSED✔️
    @Test
    public void requirement1a_2 () {
        Food tomahawk = new Food("Tomahawk", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                allowedInFlexitarianVeganImposter, false, 50, tomahawk);

        assertTrue(flexitarianDiet1.dietRestriction1a(flexitarianDiet1));
    }

    // Test when the diet is non-vegan and when the food is non-vegan, expecting the exception, allowed food is determinant
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1a_2Exception () {
        Food tomahawk = new Food("Tomahawk", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                allowedInFlexitarian, false, 50, tomahawk);

        flexitarianDiet1.dietRestriction1a(flexitarianDiet1);
    }

    // Test when the diet is vegan and when the food is vegan, allowed food is determinant
    // PASSED✔️
    @Test
    public void requirement1a_3 () {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet",
                allowedInVegan, true, 50);

        assertTrue(veganDiet1.dietRestriction1a(veganDiet1));
    }

    // Test when the diet is vegan and when the food is non-vegan, expecting the exception, allowed food is determinant
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1a_3Exception () {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet",
                nonAllowedFoodVegan, true, 50);

        assertFalse(veganDiet1.dietRestriction1a(veganDiet1));
    }

    // Test when the diet is non-vegan and when the food is vegan, allowed food is determinant
    // PASSED✔️
    @Test
    public void requirement1a_4 () {
        Food tofu = new Food("Tofu", 200, true, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                allowedInVegan, false, 50, tofu);

        assertTrue(flexitarianDiet1.dietRestriction1a(flexitarianDiet1));
    }

    // Test when the diet is non-vegan and when the food is non-vegan, expecting the exception, allowed food is determinant
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1a_4Exception () {
        Food tofu = new Food("Tofu", 200, true, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                allowedInFlexitarian, false, 50, tofu);

        flexitarianDiet1.dietRestriction1a(flexitarianDiet1);
    }

    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 1. c: A VeganDiet cannot contain non-vegan food ***/

    // Testing with all vegan foods
    // Message shows if test fails
    // PASSED✔️
    @Test
    public void requirement1c() {
        VeganDiet veganDiet = new VeganDiet("VeganDiet", 30, "Vegan Diet",
                allowedInVegan, true, 50);

        assertTrue("Diet contains one or more non-vegan foods", veganDiet.veganDietRestriction1c());
    }

    // Testing with one or more non-vegan foods
    // Message shows if test fails
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1c_1() {
        VeganDiet notVeganDiet = new VeganDiet("Not veganDiet", 30, "Vegan Diet",
                nonAllowedFoodVegan, true, 50);

        notVeganDiet.veganDietRestriction1c();
    }
}

