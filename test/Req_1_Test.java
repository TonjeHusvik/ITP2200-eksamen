import org.junit.Test;
import static org.junit.Assert.*;

public class Req_1_Test {

    FoodContainerReq_1 foodContainerReq1 = new FoodContainerReq_1();

    /*** Requirement 1. a: If a diet contains any non-vegan food, it is considered not vegan (i.e., isVegan = false).***/

    // Test if the diet is vegan based on the the food object is vegan.
    // TESTING EVERYTHING IN THE ARRAYLIST IF ITS ALL VEGAN, allowed food is determining and not the isVegan parameter on the diet.
    // PASSED✔️
    @Test
    public void requirement1a_1() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet",
                foodContainerReq1.allowedInVegan(), false, 50);

        assertTrue(veganDiet1.foodInDietVeganAndDietVeganOrNot(veganDiet1));
    }

    // Test if the diet is vegan based on the the food object is vegan.
    // TESTING EVERYTHING IN THE ARRAYLIST IF ITS ALL VEGAN, but it is not because of the imposter food.
    // PASSED✔️
    @Test(expected = IllegalArgumentException.class)
    public void requirement1a_1Exception() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet",
                foodContainerReq1.allowedInVeganImposter(), true, 50);

        veganDiet1.foodInDietVeganAndDietVeganOrNot(veganDiet1);
    }

    // Test when the diet is non-vegan and when the food is vegan, allowed food is determinant
    // PASSED✔️
    @Test
    public void requirement1a_2() {
        Food tomahawk = new Food("Tomahawk", 160, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                foodContainerReq1.allowedInFlexitarianVeganImposter(), false, 50, tomahawk);

        assertTrue(flexitarianDiet1.foodInDietVeganAndDietVeganOrNot(flexitarianDiet1));
    }

    // Test when the diet is non-vegan and when the food is non-vegan, expecting the exception, allowed food is determinant
    // PASSED✔️
    @Test(expected = IllegalArgumentException.class)
    public void requirement1a_2Exception() {
        Food tomahawk = new Food("Tomahawk", 160, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                foodContainerReq1.allowedInFlexitarian(), false, 50, tomahawk);

        flexitarianDiet1.foodInDietVeganAndDietVeganOrNot(flexitarianDiet1);
    }

    // Test when the diet is vegan and when the food is vegan, allowed food is determinant
    // PASSED✔️
    @Test
    public void requirement1a_3() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet",
                foodContainerReq1.allowedInVegan(), true, 50);

        assertTrue(veganDiet1.foodInDietVeganAndDietVeganOrNot(veganDiet1));
    }

    // Test when the diet is vegan and when the food is non-vegan, expecting the exception, allowed food is determinant
    // PASSED✔️
    @Test(expected = IllegalArgumentException.class)
    public void requirement1a_3Exception() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet",
                foodContainerReq1.nonAllowedFoodVegan(), true, 50);

        veganDiet1.foodInDietVeganAndDietVeganOrNot(veganDiet1);
    }

    // Test when the diet is non-vegan and when the food is vegan, allowed food is determinant
    // PASSED✔️
    @Test
    public void requirement1a_4() {
        Food tofu = new Food("Tofu", 200, true, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                foodContainerReq1.allowedInVegan(), false, 50, tofu);

        assertTrue(flexitarianDiet1.foodInDietVeganAndDietVeganOrNot(flexitarianDiet1));
    }

    // Test when the diet is non-vegan and when the food is non-vegan, expecting the exception, allowed food is determinant
    // PASSED✔️
    @Test(expected = IllegalArgumentException.class)
    public void requirement1a_4Exception() {
        Food tofu = new Food("Tofu", 200, true, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet",
                foodContainerReq1.allowedInFlexitarian(), false, 50, tofu);

        flexitarianDiet1.foodInDietVeganAndDietVeganOrNot(flexitarianDiet1);
    }

    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 1. b: If a diet contains only vegan food, it is considered vegan, even if it is not a
     VeganDiet (e.g., it could be a LowCarbDiet). ***/

    // MAIN TASK: Test a diet that is not from the VeganDiet, but is fully vegan
    // PASSED✔️
    @Test
    public void requirement1b_1(){
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hyper caloric diet", 60, "health", foodContainerReq1.allowedInHyperCaloric(), true, 120, 600);
        assertTrue("The food in this diet is not vegan",hypercaloricDiet.foodInDietVeganOrNot());
    }

    // Test a diet where parts of it is vegan
    // PASSED✔️
    @Test
    public void requirement1b_2(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 60, "health", foodContainerReq1.allowedInLowCarb(), false, 40);
        assertFalse("The food in this diet is vegan", lowCarbDiet.foodInDietVeganOrNot());
    }

    // Test a diet where nothing is vegan
    // PASSED✔️
    @Test
    public void requirement1b_3(){
        Food flexFood1 = new Food("Beef", 250, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet = new FlexitarianDiet("Low carb diet", 60, "health",
                foodContainerReq1.allowedInFlexiDiet(), false, 400, flexFood1);
        assertFalse("Everything in this diet is vegan", flexitarianDiet.foodInDietVeganOrNot());
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
                foodContainerReq1.allowedInVegan(), true, 50);

        assertTrue("Diet contains one or more non-vegan foods", veganDiet.onlyVeganFoodInDietOrNot());
    }

    // Testing with one or more non-vegan foods
    // Message shows if test fails
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1c_1() {
        VeganDiet notVeganDiet = new VeganDiet("Not veganDiet", 30, "Vegan Diet",
                foodContainerReq1.nonAllowedFoodVegan(), true, 50);

        notVeganDiet.onlyVeganFoodInDietOrNot();
    }

    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 1.d: The preferred meat in a FlexitarianDiet MUST be non-vegan food of protein
     type. ***/

    // Test if preferred meat is non-vegan and FoodType is protein
    // PASSED✔️
    @Test
    public void requirement1d() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 350, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Flexitarian Diet", 23, "Stay fit",
                foodContainerReq1.allowedInFlexitarian(), false, 8000, tomahawkSteak);
        assertTrue(flexitarianDiet1.preferredMeatVeganAndFoodTypeProteinOrNot(flexitarianDiet1, tomahawkSteak));
    }

    // Test if preferred meat is vegan and FoodType is not protein
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1d_1() {
        Food bread = new Food("Bread", 350, true, FoodType.CARB);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Flexitarian Diet", 23, "Stay fit",
                foodContainerReq1.allowedInFlexitarian(), false, 8000, bread);

        flexitarianDiet1.preferredMeatVeganAndFoodTypeProteinOrNot(flexitarianDiet1, bread);
    }

    // Test if preferred meat is vegan and FoodType is protein
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1d_2() {
        Food tomahawkSteak = new Food("Lentils", 160, true, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Flexitarian Diet", 23, "Stay fit",
                foodContainerReq1.allowedInFlexitarian(), false, 8000, tomahawkSteak);

        flexitarianDiet1.preferredMeatVeganAndFoodTypeProteinOrNot(flexitarianDiet1, tomahawkSteak);
    }

    // Test if preferred meat is non-vegan and FoodType is not protein
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1d_3() {
        Food tomahawkSteak = new Food("Chicken soup", 160, false, FoodType.RECIPE);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Flexitarian Diet", 23, "Stay fit",
                foodContainerReq1.allowedInFlexitarian(), false, 8000, tomahawkSteak);

        flexitarianDiet1.preferredMeatVeganAndFoodTypeProteinOrNot(flexitarianDiet1, tomahawkSteak);
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
        LowCarbDiet lowCarbDiet1 = new LowCarbDiet("Lowcarb Diet", 30, "Loose weight", foodContainerReq1.allowedLowCarbFood(), false, 50);
        assertTrue(lowCarbDiet1.lessThanTwoCarbsOrNot());
    }

    // Testing the amount of FoodType Carb, with more than 2. Expecting an exception because it is more than 2.
    // PASSED✔
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_e_1(){
        LowCarbDiet lowCarbDiet1 = new LowCarbDiet("Lowcarb Diet", 30, "Loose weight", foodContainerReq1.allowedLowCarbFoodCarb(), false, 50);
        lowCarbDiet1.lessThanTwoCarbsOrNot();
    }
}