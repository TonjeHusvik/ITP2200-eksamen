import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class VeganDietTest {
    ArrayList<Food> allowedInVegan = new ArrayList<>();


    @Before
    public void loadIn(){
        addVeganFoods();
    }

    @Test
    public void addVeganFoods() {
        Food veganFood1 = new Food("Rice", 130, true, FoodType.Carb);
        Food veganFood2 = new Food("Salad", 20, true, FoodType.Recipe);
        Food veganFood3 = new Food("Tofu", 200, true, FoodType.Protein);
        Food veganFood4 = new Food("Beans", 130, true, FoodType.Carb);
        Food veganFood5 = new Food("Broccoli", 20, true, FoodType.Fiber);
        Food veganImposter = new Food("Chicken fillet", 165, false, FoodType.Protein);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);
        allowedInVegan.add(veganFood5);
    }

    @Test
    public void testVegan1() {
        for (Food f : allowedInVegan) {

            if (f.isVegan()) {
                VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 30, "Test", allowedInVegan, true, 1);

                assertTrue(veganDiet1.isVegan());
                System.out.println(veganDiet1.isVegan());
            }
        }
    }

    @Test
    public void testVegan2() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet",40, "Test", allowedInVegan, true, 1);

        assertTrue(veganDiet1.isVegan());
        System.out.println(veganDiet1.isVegan());
    }

    // TODO Write the duration of a diet in terms of years, months and days, eg., "This VeganDiet lasts for 2 years, 3 months and 5 days".
    @Test
    public void requirement3_a() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 400, "Save the planet!", allowedInVegan, true, 2);

        String result = veganDiet1.writeDuration(veganDiet1);
        assertEquals("This VeganDiet lasts for 1 years, 1 months and 5 days", result);
    }

    // TODO Write the allowed food, e.g., "The following food is allowed in this FlexitarianDiet: Salad, Soup, Apple, Strawberry, Salmon".
    @Test
    public void requirement3_b() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 70, "Save the earth.", allowedInVegan, true, 50);

        String result = veganDiet1.writeAllowedFood(veganDiet1)
                        .replace("[",  "")
                        .replace("]", "");
        assertEquals("The following food is allowed in this VeganDiet: Rice, Salad, Tofu, Beans, Broccoli", result);
        System.out.println(result);
    }
}
