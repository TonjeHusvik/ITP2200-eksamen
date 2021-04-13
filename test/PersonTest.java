import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PersonTest {
    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedInLowCarb = new ArrayList<>();
    ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();
    ArrayList<Food> allowedInVegan2 = new ArrayList<>();

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

        /*** Kan dette arrayet slås sammen med vegan-arreyt på toppen Joachim? JUlie ***/
        Food veganFoodA1 = new Food("Apple", 30, true, FoodType.Fat);
        Food veganFoodA2 = new Food("Orange", 50, true, FoodType.Fiber);
        Food veganFoodA3 = new Food("Seitan", 200, true, FoodType.Carb);
        allowedInVegan2.add(veganFoodA1);
        allowedInVegan2.add(veganFoodA2);
        allowedInVegan2.add(veganFoodA3);





    }

    // TODO 2a. If their favourite food is non-vegan, they cannot follow a vegan diet.
    @Test
    public void requirement2_a() {
        Person person1 = new Person(new Food("Meatloaf", 400, false, FoodType.Fat));
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);

        if (!person1.getFavouriteFood().isVegan() && veganDiet.isVegan()){
            assertTrue("This person cannot follow this diet", !person1.getFavouriteFood().isVegan() && veganDiet.isVegan());
        }else{
            throw new IllegalArgumentException("This person's favouriteFood is " + person1.getFavouriteFood().getName() + " and can follow this diet.");
        }
    }

    // TODO 2b. They cannot follow a diet if they are allergic to 50% or more of the food allowed by the diet.
    @Test
    public void requirement2_b(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 20, "weight loss", allowedInLowCarb, false, 80);

        Food[] person1Allergies = new Food[4];
        person1Allergies[0] = new Food("Apple", 35, true, FoodType.Fiber);
        person1Allergies[1] = new Food("Shellfish", 500, false, FoodType.Recipe);
        person1Allergies[2] = new Food("Pork", 35, true, FoodType.Fiber);
        person1Allergies[3] = new Food("Peanuts", 500, false, FoodType.Recipe);

        //Person person1 = new Person(new Food("Chicken wings", 500, false, FoodType.Protein), person1Allergies, lowCarbDiet, 50);

        int teller = 0;


        for (Food allowedFood:lowCarbDiet.getAllowedFood()) {
            for (Food allergies:person1Allergies) {
                if (allowedFood.getName().equals(allergies.getName())){
                    teller = teller+1; // counter matches
                    System.out.println(teller);

                    if (teller >= lowCarbDiet.getAllowedFood().size()/2){
                        assertTrue(allowedFood.getName().equals(allergies.getName()));

                    }
                }
            }
        }
    }

    // TODO 2c1. Cannot follow VeganDiet or LowCarbDiet if they weigh less than the limit in minWeightKg

    /*** Her tester jeg begge dietter fordi det er en egen attributt og ikke noe de har arvet fra diet,
     * derfor vil jeg være sikker på at koden fungerer uavhengig av diet***/
    @Test
    public void requirement2_c_1_1() {
        //Testing vegan diet
        Food[] pAllergies = new Food[1];
        pAllergies[0] = new Food("Apple", 35, true, FoodType.Fiber);
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", allowedInVegan2, true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.Protein), pAllergies,
             vd , 80);

        assertTrue(p.personRestriction2c_1(vd));
    }
    /* requirement2_c_1_1 Test - This test checks the personRestriction2c_1 in the person class. It passes because
    * the person object p, weighs more than the lower weight limit for the vegan diet*/

    @Test (expected = IllegalArgumentException.class)
    public void requirement2_c_1_2() {
        //Testing vegan diet
        Food[] pAllergies = new Food[1];
        pAllergies[0] = new Food("Apple", 35, true, FoodType.Fiber);
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", allowedInVegan2, true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.Protein), pAllergies,
                vd , 45);

        assertFalse(p.personRestriction2c_1(vd));
    }

    @Test
    public void requirement2_c_2_1() {
        //Testing lowcarb diet
        Food[] pAllergies = new Food[1];
        pAllergies[0] = new Food("Apple", 35, true, FoodType.Fiber);
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", allowedInVegan2, true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.Protein), pAllergies,
                vd , 80);

        assertTrue(p.personRestriction2c_1(vd));
    }
    /* requirement2_c_1_1 Test - This test checks the personRestriction2c_1 in the person class. It passes because
     * the person object p, weighs more than the lower weight limit for the vegan diet*/

    // FIXME must change to lowcarb - Julie

    @Test (expected = IllegalArgumentException.class)
    public void requirement2_c_2_2() {
        //Testing lowcarb diet
        Food[] pAllergies = new Food[1];
        pAllergies[0] = new Food("Apple", 35, true, FoodType.Fiber);
        VeganDiet vd = new VeganDiet("Vegan diet", 200, "Save the planet", allowedInVegan2, true, 50);

        Person p = new Person(new Food("Tofu", 76, true, FoodType.Protein), pAllergies,
                vd , 45);

        assertFalse(p.personRestriction2c_1(vd));
    }
    // FIXME must change to lowcarb - Julie

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

    //TODO 2d2. Can follow VeganDiet or LowCarbDiet of they weigh more than the min
    @Test
    public void requirement2_c_2() {
        LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 20, "weight loss", allowedInLowCarb, false, 80);
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,80);
        Person lowWeightPerson = new Person(lowCarbDiet, 82);

        Assertions.assertAll("Checks if person can follow low carb or vegan diet based on weight",
                () -> assertFalse("Person cannot follow this low carb diet", lowWeightPerson.getWeight() < lowCarbDiet.getMinWeightKg()),
                () -> assertFalse("Person cannot follow this vegan diet", lowWeightPerson.getWeight() < veganDiet.getMinWeightKg())
        );
    }

    // TODO 2d. Cannot follow HyperCaloricDiet if they weigh more than the limit in maxWeightKg
    @Test
    public void requirement2_d() {
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hypercaloric diet", 123, "weight gain",
                                                                    allowedInHyperCaloric, false, 100, 6000);
        Person highWeightPerson = new Person(hypercaloricDiet, 120);

        assertTrue("Person can follow this hypercaloric diet", highWeightPerson.getWeight() > hypercaloricDiet.getMaxWeightKg());
    }
}
