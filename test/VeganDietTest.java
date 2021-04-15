import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class VeganDietTest {

    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedInFlexitarian = new ArrayList<>();


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

    }

    public void addFlexitarianFoods(){
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.Protein);
        Food tofu = new Food("tofu", 402, false, FoodType.Protein);
        allowedInFlexitarian.add(tomahawkSteak);
        allowedInFlexitarian.add(tofu);
    }

        // MAIN TASK: IF A DIET CONTAINS ANY NON-VEGAN FOOD, IT IS CONSIDERED NOT VEGAN.
        // Test if the diet is vegan and if the food is vegan.
        // PASSED✔️
        @Test
        public void requirement1_a1 () {
            Food veganFood5 = new Food("Tofu", 160, true, FoodType.Protein);
            VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet", allowedInVegan, true, 50);

            assertTrue(veganDiet1.dietRestriction1a());
            assertTrue(veganFood5.isVegan());
        }

        // Test if the diet is non-vegan and if the food is non-vegan.
        // PASSED✔️
        @Test
        public void requirement1_a2 () {
            Food tomahawk = new Food("Tomahawk", 160, false, FoodType.Protein);
            FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet", allowedInFlexitarian, false, 50, tomahawk);

            assertFalse(flexitarianDiet1.dietRestriction1a());
            assertFalse(tomahawk.isVegan());
        }

        // Test if the diet is vegan and if the food is non-vegan.
        // PASSED✔️
        @Test
        public void requirement1_a3 () {
            Food tomahawk = new Food("Steak", 160, false, FoodType.Protein);
            VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Vegan Diet of Rice and Chicken Filet", allowedInVegan, true, 50);

            assertTrue(veganDiet1.dietRestriction1a1(veganDiet1));
            assertFalse(tomahawk.isVegan());
        }

        // Test if the diet is non-vegan and if the food is vegan.
        // PASSED✔️
        @Test
        public void requirement1_a4 () {
            Food tofu = new Food("Tofu", 200, true, FoodType.Protein);
            FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 30, "Flexitarian Diet", allowedInFlexitarian, false, 50, tofu);

            assertFalse(flexitarianDiet1.dietRestriction1a());
            assertTrue(tofu.isVegan());
        }
    }

