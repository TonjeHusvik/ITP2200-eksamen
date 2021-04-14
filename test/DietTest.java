import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DietTest {

    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> person1Allergies = new ArrayList<>();

    @Before
    public void setup() {
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


    /***Given a Person and a Diet, return true if they are compatible, false otherwise***/

    // MAIN TASK: Given a Person and a Diet, return true if they are compatible, false otherwise
    @Test
    public void requirement4_a() {
        Food person1FavouriteFood = new Food("Hamburger", 295, true, FoodType.Recipe);
        VeganDiet person1VeganDiet = new VeganDiet("Person1 VeganDiet", 90, "Gotta loose some weight", allowedInVegan, true, 50);

        Person person1 = new Person(person1FavouriteFood, person1Allergies, person1VeganDiet, 90);
        DietManager dietManager = new DietManager();

        assertTrue(dietManager.areCompatible(person1, person1VeganDiet));
    }

























}
