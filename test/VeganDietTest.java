import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class VeganDietTest {

    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedInFlexitarian = new ArrayList<>();
    ArrayList<Food> person1Allergies = new ArrayList<>();


    @Before
    public void addVeganFoods() {
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

        Food walnuts = new Food("Walnuts", 654, true, FoodType.Fat);
        Food kiwi = new Food("Kiwi", 61, true, FoodType.Fiber);
        person1Allergies.add(walnuts);
        person1Allergies.add(kiwi);
    }


        // MAIN TASK: IF A DIET CONTAINS ANY NON-VEGAN FOOD, IT IS CONSIDERED NOT VEGAN.
        // Test if the diet is vegan and if the food is vegan.
        // PASSED✔️
        @Test // diet.isVegan = true & food.isVegan = true
        public void requirement1_a1 () {
            Food veganFood5 = new Food("Tofu", 160, true, FoodType.Protein);
            VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet", allowedInVegan, true, 50);

            assertTrue(veganDiet1.dietRestriction1a());
            assertTrue(veganFood5.isVegan());
        }

        // Test if the diet is non-vegan and if the food is non-vegan.
        // PASSED✔️
        @Test // diet.isVegan = false & food.isVegan = false //
        public void requirement1_a2 () {
            Food tomahawk = new Food("Tomahawk", 160, false, FoodType.Protein);
            FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet", allowedInFlexitarian, false, 50, tomahawk);

            assertFalse(tomahawk.isVegan());
            assertFalse(flexitarianDiet1.dietRestriction1a());

        }

        // Test if the diet is vegan and if the food is non-vegan.
        // PASSED✔️
        @Test // diet.isVegan = true & food.isVegan = false
        public void requirement1_a3 () {
            Food tomahawk = new Food("Steak", 160, false, FoodType.Protein);
            VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet", allowedInVegan, true, 50);

            assertTrue(veganDiet1.dietRestriction1aTest(veganDiet1));
            assertFalse(tomahawk.isVegan());
        }

        // Test if the diet is non-vegan and if the food is vegan.
        // PASSED✔️
        @Test // diet.isVegan = false & food.isVegan = true
        public void requirement1_a4 () {
            Food tofu = new Food("Tofu", 200, true, FoodType.Protein);
            FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet", allowedInFlexitarian, false, 50, tofu);

            assertFalse(flexitarianDiet1.dietRestriction1aTest(flexitarianDiet1));
            assertTrue(tofu.isVegan());
        }


    }

    /*
    // IKKE FERDIG IKKE FERDIG IKKE FERDIG IKKE FERDIG IKKE FERDIG IKKE FERDIG
    // TODO If a diet contains any non-vegan food, it is considered not vegan (i.e., isVegan = false)
    @Test
    public void requirement1_a() {
        ArrayList<Food> allowedInVeganWithOneImposterFood = new ArrayList<>();
        Food veganFood1 = new Food("Rice", 130, true, FoodType.Carb);
        Food veganImposter = new Food("Chicken fillet", 165, false, FoodType.Protein);
        allowedInVeganWithOneImposterFood.add(veganFood1);
        allowedInVeganWithOneImposterFood.add(veganImposter);

        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet",
                allowedInVeganWithOneImposterFood, true, 50);


        veganDiet1.dietRestriction1a(veganDiet1);

    }


    @Test
    public void testVegan2() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 40, "Test", allowedInVegan, true, 1);

        if (veganDiet1.getAllowedFood() == veganDiet1.isVegan())
            assertTrue(veganDiet1.isVegan());
        System.out.println(veganDiet1.isVegan());
    }
*/
