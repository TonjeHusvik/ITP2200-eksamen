import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
/*
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

 */

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

    }*/

/*
    @Test
    public void testVegan2() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet",40, "Test", allowedInVegan, true, 1);

        if (veganDiet1.getAllowedFood() == veganDiet1.isVegan())
        assertTrue(veganDiet1.isVegan());
        System.out.println(veganDiet1.isVegan());
    }
*/

/*    // TODO Given a Person and a Diet, return true if they are compatible, false otherwise
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
    }*/

