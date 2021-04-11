import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class VeganDietTest {
    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> person1FavouriteFood = new ArrayList<>();

    @Before
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

        Food[] person1Allergies = new Food[2];
        person1Allergies[0] = new Food("Walnuts", 654, true, FoodType.Fat);
        person1Allergies[1] = new Food("Kiwi", 61, true, FoodType.Fiber);
    }

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

        for (Food f: veganDiet1.getAllowedFood()) {
            if (!f.isVegan() == f.isVegan()) {
                assertFalse("isVegan = true", f.isVegan());
            } else if (f.isVegan()) {
                assertTrue("isVegan = false", f.isVegan());
            }
        }



        /*String imposterFood = allowedInVeganWithOneImposterFood.get();

        System.out.println(imposterFood);*/
    }

/*
    @Test
    public void testVegan2() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet",40, "Test", allowedInVegan, true, 1);

        if (veganDiet1.getAllowedFood() == veganDiet1.isVegan())
        assertTrue(veganDiet1.isVegan());
        System.out.println(veganDiet1.isVegan());
    }
*/

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

    // TODO Given a Person and a Diet, return true if they are compatible, false otherwise
    @Test
    public void requirement4_a() {
        Food[] person1Allergies = new Food[2];
        person1Allergies[0] = new Food("Walnuts", 654, true, FoodType.Fat);
        person1Allergies[1] = new Food("Kiwi", 61, true, FoodType.Fiber);
        Food person1FavouriteFood = new Food("Hamburger", 295, true, FoodType.Recipe);
        VeganDiet person1VeganDiet = new VeganDiet("Person1 VeganDiet", 90, "Gotta loose some weight", allowedInVegan, true, 50);

        Person person1 = new Person(person1FavouriteFood, person1Allergies, person1VeganDiet, 90);
        DietManager dietManager = new DietManager();

        assertTrue(dietManager.areCompatible(person1, person1VeganDiet));
    }

}
