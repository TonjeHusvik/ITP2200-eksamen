import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔

public class PersonTest {

    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedInLowCarb = new ArrayList<>();
    ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();
    ArrayList<Food> allergiesTooMany = new ArrayList<>();
    ArrayList<Food> allergiesOk = new ArrayList<>();
    ArrayList<Food> allowedInDiet = new ArrayList<>();


    @Before
    public void diets(){

        // VEGAN FOOD
        Food veganFood1 = new Food("Salad", 10, true, FoodType.Fiber);
        Food veganFood2 = new Food("Apple", 30, true, FoodType.Fat);
        Food veganFood3 = new Food("Orange", 50, true, FoodType.Fiber);
        Food veganFood4 = new Food("Seitan", 200, true, FoodType.Carb);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);

        // LOW CARB FOOD
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

        // HYPERCALORIC FOOD
        Food hyperCaloricFood1 = new Food("Bacon", 10, false, FoodType.Fat);
        Food hyperCaloricFood2 = new Food("Butter", 10, false, FoodType.Fat);
        Food hyperCaloricFood3 = new Food("Peanut butter", 10, false, FoodType.Fat);
        Food hyperCaloricFood4 = new Food("Lard", 10, false, FoodType.Fat);
        allowedInHyperCaloric.add(hyperCaloricFood1);
        allowedInHyperCaloric.add(hyperCaloricFood2);
        allowedInHyperCaloric.add(hyperCaloricFood3);
        allowedInHyperCaloric.add(hyperCaloricFood4);

        // FLEXITARIAN FOOD
        Food flexiFood1 = new Food("Salad", 10, true, FoodType.Fiber);
        Food flexiFood2 = new Food("Crab", 10, false, FoodType.Protein);
        Food flexiFood3 = new Food("Beef", 10, false, FoodType.Protein);
        Food flexiFood4 = new Food("Pomegranate", 10, true, FoodType.Fiber);
        Food flexiFood5 = new Food("Peanuts", 10, true, FoodType.Fat);
        Food flexiFood6 = new Food("Wheat", 10, true, FoodType.Fiber);
        allowedInDiet.add(flexiFood1);
        allowedInDiet.add(flexiFood2);
        allowedInDiet.add(flexiFood3);
        allowedInDiet.add(flexiFood4);
        allowedInDiet.add(flexiFood5);
        allowedInDiet.add(flexiFood6);

        // ALLERGY FOOD
        Food allergyFood1 = new Food("Spinach", 10, true, FoodType.Fiber);
        Food allergyFood2 = new Food("Asparagus", 10, false, FoodType.Fiber);
        Food allergyFood3 = new Food("Salmon", 10, false, FoodType.Protein);
        allergiesTooMany.add(allergyFood3);
        allergiesTooMany.add(flexiFood4);
        allergiesTooMany.add(flexiFood5);
        allergiesTooMany.add(flexiFood6);
        allergiesOk.add(allergyFood1);
        allergiesOk.add(allergyFood2);
        allergiesOk.add(allergyFood3);
        allergiesOk.add(flexiFood4);
    }


    /***Requirement 2.a: If their favorite food is non-vegan, they cannot follow a VeganDiet***/

    // MAIN TASK: If their favorite food is non-vegan, they cannot follow a VeganDiet
    // PASSED✔
    @Test (expected = IllegalArgumentException.class)
    public void requirement2_a() {
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);
        Person personNotVeganFavorite = new Person(new Food("Tuna", 400, false, FoodType.Protein),
                veganDiet);

        assertTrue(personNotVeganFavorite.personRestriction2a());
    }

    // If the persons favourite food is vegan, they can follow a vegan diet
    // PASSED✔
    @Test
    public void requirement2_a_1() {
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);
        Person personVeganFavorite = new Person(new Food("Smoked tofu", 400, true, FoodType.Protein),
                veganDiet);

        assertTrue(personVeganFavorite.personRestriction2a());
    }


    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/

    /***Requirement 2.b: They cannot follow a diet if they are allergic to 50% or more of the food
     allowed by the diet.***/
    //Testing with too many allergies
    //PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2_b() {
        Person tooManyAllergies = new Person(allergiesTooMany);
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Flexi", 324, "testing", allowedInDiet,
                false, 1000, (new Food("Tuna", 400, false, FoodType.Protein)));
        tooManyAllergies.personRestriction2b(tooManyAllergies, flexiDiet);
    }

    //Testing with less than 50% allergies
    //PASSED ✔️
    @Test
    public void requirement2_b_1() {
        Person okAmountOfAllergies = new Person(allergiesOk);
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Flexi", 324, "testing", allowedInDiet,
                false, 1000, (new Food("Tuna", 400, false, FoodType.Protein)));
        assertTrue(okAmountOfAllergies.personRestriction2b(okAmountOfAllergies, flexiDiet));
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/

    // TODO 2c1. Cannot follow VeganDiet or LowCarbDiet if they weigh less than the limit in minWeightKg
    /*** Requirement 3. c: If they weigh less than the limit set by the VeganDiet or the LowCarbDiet, they
     cannot be following these diets (for health reasons). ***/

    // PASSED ✔️
    @Test
    public void requirement2_c_1_1() {
        //Testing vegan diet
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food apple = new Food("Apple", 35, true, FoodType.Fiber);
        pAllergies.add(apple);
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", allowedInVegan, true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.Protein), pAllergies,
             vd , 80);

        assertTrue(p.personRestriction2c_1(vd));
    }
    /* requirement2_c_1_1 Test - This test checks the personRestriction2c_1 in the person class. It passes because
    * the person object p, weighs more than the lower weight limit for the vegan diet
    *
    * Her tester jeg begge dietter fordi det er en egen attributt og ikke noe de har arvet fra diet,
     * derfor vil jeg være sikker på at koden fungerer uavhengig av diet */

    //PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2_c_1_2() {
        //Testing vegan diet
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food apple = new Food("Apple", 35, true, FoodType.Fiber);
        pAllergies.add(apple);
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", allowedInVegan, true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.Protein), pAllergies,
                vd , 45);

        p.personRestriction2c_1(vd);
    }

    //PASSED ✔️
    @Test
    public void requirement2_c_2_1() {
        //Testing lowcarb diet
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food peanuts = new Food("Peanuts", 450, true, FoodType.Protein);
        pAllergies.add(peanuts);
        LowCarbDiet lcd = new LowCarbDiet("Lowcarb Diet", 200, "Burn fat", allowedInLowCarb, false, 50);

        Person p = new Person(new Food("Pizza", 550, false, FoodType.Recipe), pAllergies,
                lcd , 63);

        assertTrue(p.personRestriction2c_2(lcd));
    }
    /* requirement2_c_1_1 Test - This test checks the personRestriction2c_1 in the person class. It passes because
     * the person object p, weighs more than the lower weight limit for the lowcarb diet*/

    //PASSED ✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement2_c_2_2() {
        //Testing lowcarb diet
        ArrayList<Food> pAllergies = new ArrayList<>();
        Food peanuts = new Food("Peanuts", 450, true, FoodType.Protein);
        pAllergies.add(peanuts);
        LowCarbDiet lcd = new LowCarbDiet("Lowcarb Diet", 200, "Burn fat", allowedInLowCarb, false, 50);
        Person p = new Person(new Food("Pizza", 550, false, FoodType.Recipe), pAllergies, lcd , 43);

        p.personRestriction2c_2(lcd);
    }


    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/


    // TODO 2d. Cannot follow HyperCaloricDiet if they weigh more than the limit in maxWeightKg
    @Test
    public void requirement2_d() {
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hypercaloric diet", 123, "weight gain",
        allowedInHyperCaloric, false, 100, 6000);
        Person highWeightPerson = new Person(hypercaloricDiet, 120);

        assertTrue("Person can follow this hypercaloric diet", highWeightPerson.getWeight() > hypercaloricDiet.getMaxWeightKg());
    }
}
    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------------*/

/*//2d2. Can follow VeganDiet or LowCarbDiet of they weigh more than the min
    @Test
    public void requirement2_c_2() {
        LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 20, "weight loss", allowedInLowCarb, false, 80);
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,80);
        Person lowWeightPerson = new Person(lowCarbDiet, 82);

        Assertions.assertAll("Checks if person can follow low carb or vegan diet based on weight",
                () -> assertFalse("Person cannot follow this low carb diet", lowWeightPerson.getWeight() < lowCarbDiet.getMinWeightKg()),
                () -> assertFalse("Person cannot follow this vegan diet", lowWeightPerson.getWeight() < veganDiet.getMinWeightKg())
        );
    }*/


/* requirement2_c_1_1 Test - This test checks the personRestriction2c_1 in the person class. It passes because
 * we expect an illegalArgumentException thrown becauae the persn object weighs less than the lower weight limit for
 * the vegan diet.*/

    /*LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 20, "weight loss", allowedInLowCarb, false, 80);
    VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,80);
    Person lowWeightPerson = new Person(lowCarbDiet, 79);

        Assertions.assertAll("Checks if person can follow low carb or vegan diet based on weight",
                () -> assertFalse("Person can follow this low carb diet", lowWeightPerson.getWeight() > lowCarbDiet.getMinWeightKg()),
            () -> assertFalse("Person can follow this vegan diet", lowWeightPerson.getWeight() > veganDiet.getMinWeightKg())
            );*/
