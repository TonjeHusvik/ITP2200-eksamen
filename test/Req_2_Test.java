import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;

public class Req_2_Test {

    FoodContainerReq_2 foodContainerReq2 = new FoodContainerReq_2();

    /*** Requirement 2.a: If their favorite food is non-vegan, they cannot follow a VeganDiet ***/

    // MAIN TASK: If their favorite food is non-vegan, they cannot follow a VeganDiet
    // PASSED✔
    @Test(expected = IllegalArgumentException.class)
    public void requirement2a() {
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", foodContainerReq2.allowedInVegan(), true,20);
        Person personNotVeganFavorite = new Person(new Food("Tuna", 400, false, FoodType.PROTEIN),
                veganDiet);

        personNotVeganFavorite.favoriteFoodVeganAndDietVeganOrNot();
    }

    // If the persons favourite food is vegan, they can follow a vegan diet
    // PASSED✔
    @Test
    public void requirement2a_1() {
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", foodContainerReq2.allowedInVegan(), true,20);
        Person personVeganFavorite = new Person(new Food("Smoked tofu", 140, true, FoodType.PROTEIN),
                veganDiet);

        assertTrue(personVeganFavorite.favoriteFoodVeganAndDietVeganOrNot());
    }

    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 2.b: They cannot follow a diet if they are allergic to 50% or more of the food
     allowed by the diet. ***/

    //Testing with too many allergies
    //PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2b() {
        Person tooManyAllergies = new Person(foodContainerReq2.allowedInDietAndAllergiesTooMany().get(1));
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Flexi", 324, "Training",
                foodContainerReq2.allowedInDietAndAllergiesTooMany().get(0),
                false, 1000, (new Food("Tuna", 129, false, FoodType.PROTEIN)));
        tooManyAllergies.personAllergiesAndLowCarb(tooManyAllergies, flexiDiet);
    }

    //Testing with less than 50% allergies
    //PASSED ✔️
    @Test
    public void requirement2b_1() {
        Person okAmountOfAllergies = new Person(foodContainerReq2.allergiesOk());
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Flexi", 324, "Training",
                foodContainerReq2.allowedInDietAndAllergiesTooMany().get(0),
                false, 1000, (new Food("Tuna", 129, false, FoodType.PROTEIN)));
        assertTrue(okAmountOfAllergies.checkAllergiesAgainstDietFoods(okAmountOfAllergies, flexiDiet));
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 2. c: If they weigh less than the limit set by the VeganDiet or the LowCarbDiet, they
     cannot be following these diets (for health reasons). ***/

    // Testing vegan diet
    // PASSED ✔️
    @Test
    public void requirement2c_veganDiet_1() {
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food apple = new Food("Apple", 35, true, FoodType.FIBER);
        pAllergies.add(apple);
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", foodContainerReq2.allowedInVegan(), true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.PROTEIN), pAllergies,
                vd , 80);

        assertTrue(p.weightLessThanVeganDietMinimumOrNot(vd));
    }

    // Testing vegan diet
    // PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2c_veganDiet_2() {
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food apple = new Food("Apple", 35, true, FoodType.FIBER);
        pAllergies.add(apple);
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", foodContainerReq2.allowedInVegan(), true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.PROTEIN), pAllergies,
                vd , 45);

        p.weightLessThanVeganDietMinimumOrNot(vd);
    }

    // Testing lowcarb diet
    // PASSED ✔️
    @Test
    public void requirement2c_lowCarbDiet_1() {
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food peanuts = new Food("Peanuts", 450, true, FoodType.PROTEIN);
        pAllergies.add(peanuts);
        LowCarbDiet lcd = new LowCarbDiet("Lowcarb Diet", 200, "Burn fat", foodContainerReq2.allowedInLowCarb(), false, 50);

        Person p = new Person(new Food("Pizza", 550, false, FoodType.RECIPE), pAllergies,
                lcd , 63);

        assertTrue(p.weightLessThanLowCarbDietMinimumOrNot(lcd));
    }

    // Testing lowcarb diet
    // PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2c_lowCarbDiet_2() {
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food peanuts = new Food("Peanuts", 450, true, FoodType.PROTEIN);
        pAllergies.add(peanuts);
        LowCarbDiet lcd = new LowCarbDiet("Lowcarb Diet", 200, "Burn fat", foodContainerReq2.allowedInLowCarb(), false, 50);
        Person p = new Person(new Food("Pizza", 550, false, FoodType.RECIPE), pAllergies, lcd , 43);

        p.weightLessThanLowCarbDietMinimumOrNot(lcd);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 2. d: If they weigh more than the limit set by the HypercaloricDiet, they cannot be
     following this diet (for health reasons). ***/

    // Test if person weight less than the limit set by the diet.
    // PASSED ✔️
    @Test
    public void requirement2d() {
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hypercaloric diet", 123, "weight gain",
                foodContainerReq2.allowedInHyperCaloric(), false, 100, 6000);
        Person highWeightPerson = new Person(hypercaloricDiet, 90);

        assertTrue(highWeightPerson.weightMoreThanMaximumOrNot(hypercaloricDiet));
    }

    // Test if person weight more than the limit set by the diet.
    // PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2d_1() {
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hypercaloric diet", 123, "weight gain",
                foodContainerReq2.allowedInHyperCaloric(), false, 100, 6000);
        Person highWeightPerson = new Person(hypercaloricDiet, 120);

        highWeightPerson.weightMoreThanMaximumOrNot(hypercaloricDiet);
    }
}