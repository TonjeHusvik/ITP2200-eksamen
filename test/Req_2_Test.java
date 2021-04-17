import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;

// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔

public class Req_2_Test {

    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedInLowCarb = new ArrayList<>();
    ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();
    ArrayList<Food> allergiesTooMany = new ArrayList<>();
    ArrayList<Food> allergiesOk = new ArrayList<>();
    ArrayList<Food> allowedInDiet = new ArrayList<>();

    @Before
    public void diets(){

        // VEGAN FOOD
        Food veganFood1 = new Food("Salad", 10, true, FoodType.FIBER);
        Food veganFood2 = new Food("Apple", 30, true, FoodType.FAT);
        Food veganFood3 = new Food("Orange", 50, true, FoodType.FIBER);
        Food veganFood4 = new Food("Seitan", 200, true, FoodType.CARB);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);

        // LOW CARB FOOD
        Food lowCarbFood1 = new Food("Bacon", 541, false, FoodType.FAT);
        Food lowCarbFood2 = new Food("Pork", 242, false, FoodType.FAT);
        Food lowCarbFood3 = new Food("Peanuts", 567, false, FoodType.FAT);
        Food lowCarbFood4 = new Food("Shellfish", 99, false, FoodType.PROTEIN);
        Food lowCarbFood5 = new Food("Potatoes", 307, false, FoodType.CARB);
        allowedInLowCarb.add(lowCarbFood1);
        allowedInLowCarb.add(lowCarbFood2);
        allowedInLowCarb.add(lowCarbFood3);
        allowedInLowCarb.add(lowCarbFood4);
        allowedInLowCarb.add(lowCarbFood5);

        // HYPERCALORIC FOOD
        Food hyperCaloricFood1 = new Food("Bacon", 541, false, FoodType.FAT);
        Food hyperCaloricFood2 = new Food("Butter", 716, false, FoodType.FAT);
        Food hyperCaloricFood3 = new Food("Peanut butter", 588, false, FoodType.FAT);
        Food hyperCaloricFood4 = new Food("Lard", 898, false, FoodType.FAT);
        allowedInHyperCaloric.add(hyperCaloricFood1);
        allowedInHyperCaloric.add(hyperCaloricFood2);
        allowedInHyperCaloric.add(hyperCaloricFood3);
        allowedInHyperCaloric.add(hyperCaloricFood4);

        // FLEXITARIAN FOOD
        Food flexiFood1 = new Food("Salad", 10, true, FoodType.FIBER);
        Food flexiFood2 = new Food("Crab", 82, false, FoodType.PROTEIN);
        Food flexiFood3 = new Food("Beef", 250, false, FoodType.PROTEIN);
        Food flexiFood4 = new Food("Pomegranate", 234, true, FoodType.FIBER);
        Food flexiFood5 = new Food("Peanuts", 567, true, FoodType.FAT);
        Food flexiFood6 = new Food("Wheat", 315, true, FoodType.CARB);
        allowedInDiet.add(flexiFood1);
        allowedInDiet.add(flexiFood2);
        allowedInDiet.add(flexiFood3);
        allowedInDiet.add(flexiFood4);
        allowedInDiet.add(flexiFood5);
        allowedInDiet.add(flexiFood6);

        // ALLERGY FOOD
        Food allergyFood1 = new Food("Spinach", 23, true, FoodType.FIBER);
        Food allergyFood2 = new Food("Asparagus", 20, false, FoodType.FIBER);
        Food allergyFood3 = new Food("Salmon", 208, false, FoodType.PROTEIN);
        allergiesTooMany.add(allergyFood3);
        allergiesTooMany.add(flexiFood4);
        allergiesTooMany.add(flexiFood5);
        allergiesTooMany.add(flexiFood6);
        allergiesOk.add(allergyFood1);
        allergiesOk.add(allergyFood2);
        allergiesOk.add(allergyFood3);
        allergiesOk.add(flexiFood4);
    }


    /*** Requirement 2.a: If their favorite food is non-vegan, they cannot follow a VeganDiet ***/

    // MAIN TASK: If their favorite food is non-vegan, they cannot follow a VeganDiet
    // PASSED✔
    @Test(expected = IllegalArgumentException.class)
    public void requirement2a() {
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);
        Person personNotVeganFavorite = new Person(new Food("Tuna", 400, false, FoodType.PROTEIN),
                veganDiet);

        personNotVeganFavorite.personRestriction2a();
    }

    // If the persons favourite food is vegan, they can follow a vegan diet
    // PASSED✔
    @Test
    public void requirement2a_1() {
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);
        Person personVeganFavorite = new Person(new Food("Smoked tofu", 140, true, FoodType.PROTEIN),
                veganDiet);

        assertTrue(personVeganFavorite.personRestriction2a());
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
        Person tooManyAllergies = new Person(allergiesTooMany);
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Flexi", 324, "testing", allowedInDiet,
                false, 1000, (new Food("Tuna", 129, false, FoodType.PROTEIN)));
        tooManyAllergies.personRestriction2b(tooManyAllergies, flexiDiet);
    }

    //Testing with less than 50% allergies
    //PASSED ✔️
    @Test
    public void requirement2b_1() {
        Person okAmountOfAllergies = new Person(allergiesOk);
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Flexi", 324, "testing", allowedInDiet,
                false, 1000, (new Food("Tuna", 129, false, FoodType.PROTEIN)));
        assertTrue(okAmountOfAllergies.personRestriction2b(okAmountOfAllergies, flexiDiet));
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
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", allowedInVegan, true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.PROTEIN), pAllergies,
                vd , 80);

        assertTrue(p.personRestriction2c_1(vd));
    }

    // Testing vegan diet
    // PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2c_veganDiet_2() {
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food apple = new Food("Apple", 35, true, FoodType.FIBER);
        pAllergies.add(apple);
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", allowedInVegan, true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.PROTEIN), pAllergies,
                vd , 45);

        p.personRestriction2c_1(vd);
    }

    // Testing lowcarb diet
    // PASSED ✔️
    @Test
    public void requirement2c_lowCarbDiet_1() {
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food peanuts = new Food("Peanuts", 450, true, FoodType.PROTEIN);
        pAllergies.add(peanuts);
        LowCarbDiet lcd = new LowCarbDiet("Lowcarb Diet", 200, "Burn fat", allowedInLowCarb, false, 50);

        Person p = new Person(new Food("Pizza", 550, false, FoodType.RECIPE), pAllergies,
                lcd , 63);

        assertTrue(p.personRestriction2c_2(lcd));
    }

    // Testing lowcarb diet
    // PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2c_lowCarbDiet_2() {
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food peanuts = new Food("Peanuts", 450, true, FoodType.PROTEIN);
        pAllergies.add(peanuts);
        LowCarbDiet lcd = new LowCarbDiet("Lowcarb Diet", 200, "Burn fat", allowedInLowCarb, false, 50);
        Person p = new Person(new Food("Pizza", 550, false, FoodType.RECIPE), pAllergies, lcd , 43);

        p.personRestriction2c_2(lcd);
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
                allowedInHyperCaloric, false, 100, 6000);
        Person highWeightPerson = new Person(hypercaloricDiet, 90);

        assertTrue(highWeightPerson.personRestriction2_d(hypercaloricDiet));
    }

    // Test if person weight more than the limit set by the diet.
    // PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2d_1() {
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hypercaloric diet", 123, "weight gain",
                allowedInHyperCaloric, false, 100, 6000);
        Person highWeightPerson = new Person(hypercaloricDiet, 120);

        highWeightPerson.personRestriction2_d(hypercaloricDiet);
    }
}