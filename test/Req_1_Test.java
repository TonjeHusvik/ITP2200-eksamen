import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔

public class Req_1_Test {

    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedInVeganImposter = new ArrayList<>();
    ArrayList<Food> allowedInFlexitarianVeganImposter = new ArrayList<>();
    ArrayList<Food> allowedInFlexitarian = new ArrayList<>();
    ArrayList<Food> nonAllowedFoodVegan = new ArrayList<>();
    //______________________________________________________________________________________________
    ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();
    ArrayList<Food> allowedInFlexiDiet = new ArrayList<>();
    ArrayList<Food> allowedInLowCarb = new ArrayList<>();
    //______________________________________________________________________________________________
    ArrayList <Food> allowedLowCarbFood = new ArrayList<>();
    ArrayList <Food> allowedLowCarbFoodCarb = new ArrayList<>();

    @Before
    public void addFood() {

        // FLEXITARIAN FOOD
        Food flexitarianFood1 = new Food("Tomahawk Steak", 160, false, FoodType.PROTEIN);
        Food flexitarianFood2 = new Food("Tofu", 76, true, FoodType.PROTEIN);
        Food flexitarianFood3 = new Food("Green peas", 81, true, FoodType.PROTEIN);
        allowedInFlexitarian.add(flexitarianFood1);
        allowedInFlexitarian.add(flexitarianFood2);
        allowedInFlexitarian.add(flexitarianFood3);

        // VEGAN FOOD
        Food veganFood1 = new Food("Rice", 130, true, FoodType.CARB);
        Food veganFood2 = new Food("Salad", 20, true, FoodType.RECIPE);
        Food veganFood3 = new Food("Tofu", 200, true, FoodType.PROTEIN);
        Food veganFood4 = new Food("Beans", 130, true, FoodType.CARB);
        Food veganFood5 = new Food("Broccoli", 20, true, FoodType.FIBER);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);
        allowedInVegan.add(veganFood5);

        // VEGAN IMPOSTER FOOD
        Food veganFoodImposter = new Food("Broccoli", 20, false, FoodType.FIBER);
        allowedInVeganImposter.add(veganFoodImposter);

        // FLEXITARIAN VEGAN IMPOSTER FOOD
        Food flexitarianFoodImposter = new Food("Beef", 20, true, FoodType.PROTEIN);
        allowedInFlexitarianVeganImposter.add(flexitarianFoodImposter);

        // NON VEGAN FOOD
        Food nonVeganFood1 = new Food("Ribeye", 130, false, FoodType.PROTEIN);
        Food nonVeganFood2 = new Food("Red snapper", 20, false, FoodType.PROTEIN);
        Food nonVeganFood3 = new Food("Broccoli", 20, false, FoodType.FIBER);
        nonAllowedFoodVegan.add(nonVeganFood1);
        nonAllowedFoodVegan.add(nonVeganFood2);
        nonAllowedFoodVegan.add(nonVeganFood3);
        //______________________________________________________________________________________________
        Food hyperCaloric1 = new Food("Broccoli", 20, true, FoodType.FIBER);
        Food hyperCaloric2 = new Food("Avocado", 160, true, FoodType.FAT);
        allowedInHyperCaloric.add(hyperCaloric1);
        allowedInHyperCaloric.add(hyperCaloric2);

        Food flexFood1 = new Food("Beef", 250, false, FoodType.PROTEIN);
        Food flexFood2 = new Food("Fish", 206, false, FoodType.PROTEIN);
        allowedInFlexiDiet.add(flexFood1);
        allowedInFlexiDiet.add(flexFood2);

        Food lowCarb1 = new Food("Beef", 250, false, FoodType.PROTEIN);
        Food lowCarb2 = new Food("Nuts", 607, true, FoodType.FAT);
        allowedInLowCarb.add(lowCarb1);
        allowedInLowCarb.add(lowCarb2);
        //______________________________________________________________________________________________

        // LOWCARB FOOD
        Food lowCarbFood1 = new Food("Cauliflower rice", 23, true, FoodType.PROTEIN);
        Food lowCarbFood2 = new Food("Salad", 20, true, FoodType.FIBER);
        Food lowCarbFood3 = new Food("Tofu", 200, true, FoodType.PROTEIN);
        Food lowCarbFood4 = new Food("Fish", 130, false, FoodType.PROTEIN);
        Food lowCarbFood5 = new Food("Broccoli", 20, true, FoodType.FIBER);
        Food lowCarbFood6 = new Food("Seitan", 200, true, FoodType.CARB);
        Food lowCarbFood7 = new Food("Bread", 400, true, FoodType.CARB);
        allowedLowCarbFood.add(lowCarbFood1);
        allowedLowCarbFood.add(lowCarbFood2);
        allowedLowCarbFood.add(lowCarbFood3);
        allowedLowCarbFood.add(lowCarbFood4);
        allowedLowCarbFood.add(lowCarbFood5);
        allowedLowCarbFood.add(lowCarbFood6);
        allowedLowCarbFood.add(lowCarbFood7);

        // TOO MANY CARBS
        Food allowCarbFoodCarb1 = new Food("Pasta", 245, true, FoodType.CARB);
        Food allowCarbFoodCarb2 = new Food("Chocolate", 550, true, FoodType.CARB);
        Food allowCarbFoodCarb3 = new Food("Sweet potato", 150, true, FoodType.CARB);
        allowedLowCarbFoodCarb.add(allowCarbFoodCarb1);
        allowedLowCarbFoodCarb.add(allowCarbFoodCarb2);
        allowedLowCarbFoodCarb.add(allowCarbFoodCarb3);
    }

    /*** Requirement 1. a: If a diet contains any non-vegan food, it is considered not vegan (i.e., isVegan = false).***/

    // Test if the diet is vegan on behalf of the food is vegan.
    // TESTING EVERYTHING IN THE ARRAYLIST IF ITS ALL VEGAN, allowed food is determining and not the isVegan parameter on the diet.
    // PASSED✔️
    @Test
    public void requirement1a_1() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet",
                allowedInVegan, false, 50);

        assertTrue(veganDiet1.dietRestriction1a(veganDiet1));
    }

    // Test if the diet is vegan on behalf of the food is vegan.
    // TESTING EVERYTHING IN THE ARRAYLIST IF ITS ALL VEGAN, but it is not because of the imposter food.
    // PASSED✔️
    @Test(expected = IllegalArgumentException.class)
    public void requirement1a_1Exception() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet",
                allowedInVeganImposter, true, 50);

        assertTrue(veganDiet1.dietRestriction1a(veganDiet1));
    }

    // Test when the diet is non-vegan and when the food is vegan, allowed food is determinant
    // PASSED✔️
    @Test
    public void requirement1a_2() {
        Food tomahawk = new Food("Tomahawk", 160, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                allowedInFlexitarianVeganImposter, false, 50, tomahawk);

        assertTrue(flexitarianDiet1.dietRestriction1a(flexitarianDiet1));
    }

    // Test when the diet is non-vegan and when the food is non-vegan, expecting the exception, allowed food is determinant
    // PASSED✔️
    @Test(expected = IllegalArgumentException.class)
    public void requirement1a_2Exception() {
        Food tomahawk = new Food("Tomahawk", 160, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                allowedInFlexitarian, false, 50, tomahawk);

        flexitarianDiet1.dietRestriction1a(flexitarianDiet1);
    }

    // Test when the diet is vegan and when the food is vegan, allowed food is determinant
    // PASSED✔️
    @Test
    public void requirement1a_3() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet",
                allowedInVegan, true, 50);

        assertTrue(veganDiet1.dietRestriction1a(veganDiet1));
    }

    // Test when the diet is vegan and when the food is non-vegan, expecting the exception, allowed food is determinant
    // PASSED✔️
    @Test(expected = IllegalArgumentException.class)
    public void requirement1a_3Exception() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet",
                nonAllowedFoodVegan, true, 50);

        assertFalse(veganDiet1.dietRestriction1a(veganDiet1));
    }

    // Test when the diet is non-vegan and when the food is vegan, allowed food is determinant
    // PASSED✔️
    @Test
    public void requirement1a_4() {
        Food tofu = new Food("Tofu", 200, true, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                allowedInVegan, false, 50, tofu);

        assertTrue(flexitarianDiet1.dietRestriction1a(flexitarianDiet1));
    }

    // Test when the diet is non-vegan and when the food is non-vegan, expecting the exception, allowed food is determinant
    // PASSED✔️
    @Test(expected = IllegalArgumentException.class)
    public void requirement1a_4Exception() {
        Food tofu = new Food("Tofu", 200, true, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                allowedInFlexitarian, false, 50, tofu);

        flexitarianDiet1.dietRestriction1a(flexitarianDiet1);
    }

    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 1. b: If a diet contains only vegan food, it is considered vegan, even if it is not a
     VeganDiet (e.g., it could be a LowCarbDiet). ***/

    //TODO If a diet contains only vegan food, it is considered vegan, even if it is not a VeganDiet
    // (e.g., it could be a LowCarbDiet).

    // MAIN TASK: Test a diet that is not from the VeganDiet, but is fully vegan
    // PASSED✔️
    @Test
    public void requirement1b_1(){
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hyper caloric diet", 60, "health", allowedInHyperCaloric, true, 120, 600);
        assertTrue("The food in this diet is not vegan",hypercaloricDiet.dietRestriction1b());
    }

    // Test a diet where parts of it is vegan
    // PASSED✔️
    @Test
    public void requirement1b_2(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 60, "health", allowedInLowCarb, false, 40);
        assertTrue("The food in this diet is vegan", lowCarbDiet.dietRestriction1b());
    }

    // Test a diet where nothing is vegan
    // PASSED✔️
    @Test
    public void requirement1b_3(){
        Food flexFood1 = new Food("Beef", 250, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet = new FlexitarianDiet("Low carb diet", 60, "health",
                allowedInFlexiDiet, false, 400, flexFood1);
        assertFalse("Everything in this diet is vegan", flexitarianDiet.dietRestriction1b());
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

    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 1.d: The preferred meat in a FlexitarianDiet MUST be non-vegan food of protein
     type. ***/
    // Test if preferred meat is vegan and FoodType is not protein
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1d_1() {
        Food tomahawkSteak = new Food("Bread", 350, true, FoodType.CARB);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Flexitarian Diet", 23, "Stay fit",
                allowedInFlexitarian, false, 8000, tomahawkSteak);

        flexitarianDiet1.flexDietRestriction1d(flexitarianDiet1, tomahawkSteak);
    }

    // Test if preferred meat is vegan and FoodType is protein
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1d_2() {
        Food tomahawkSteak = new Food("Lentils", 160, true, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Flexitarian Diet", 23, "Stay fit",
                allowedInFlexitarian, false, 8000, tomahawkSteak);

        flexitarianDiet1.flexDietRestriction1d(flexitarianDiet1, tomahawkSteak);
    }

    // Test if preferred meat is non-vegan and FoodType is not protein
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1d_3() {
        Food tomahawkSteak = new Food("Chicken soup", 160, false, FoodType.RECIPE);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Flexitarian Diet", 23, "Stay fit",
                allowedInFlexitarian, false, 8000, tomahawkSteak);

        flexitarianDiet1.flexDietRestriction1d(flexitarianDiet1, tomahawkSteak);
    }

    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 1.e: The maximum carb-type foods that can be included in a LowCarbDiet is two. ***/

    // MAIN TASK:
    // The maximum carb-type foods that can be included in a LowCarbDiet is two
    // PASSED✔️
    @Test
    public void requirement1_e(){
        LowCarbDiet lowCarbDiet1 = new LowCarbDiet("Lowcarb Diet", 30, "Loose weight", allowedLowCarbFood, false, 50);
        assertTrue(lowCarbDiet1.lowCarbRestriction1e());
    }

    // Testing the amount of FoodType Carb, with more than 2. Expecting an exception because it is more than 2.
    // PASSED✔
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_e_1(){
        LowCarbDiet lowCarbDiet1 = new LowCarbDiet("Lowcarb Diet", 30, "Loose weight", allowedLowCarbFoodCarb, false, 50);
        lowCarbDiet1.lowCarbRestriction1e();
    }
}