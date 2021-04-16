import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔

public class DietTest {

    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedLowCarbFood = new ArrayList<>();
    ArrayList<Food> allowedInHypercaloricDiet = new ArrayList<>();
    ArrayList<Food> allowedInFlexitarianDiet = new ArrayList<>();
    ArrayList<Food> person1Allergies = new ArrayList<>();
    ArrayList<Food> person2Allergies = new ArrayList<>();
    ArrayList<Food> person3Allergies = new ArrayList<>();
    ArrayList<Food> person4Allergies = new ArrayList<>();

    @Before
    public void setup() {
        // ALLERGIES
        Food walnuts = new Food("Walnuts", 654, true, FoodType.Fat);
        Food kiwi = new Food("Kiwi", 61, true, FoodType.Fiber);
        Food shellfish = new Food("Shellfish", 99, false, FoodType.Protein);
        Food wheat = new Food("Wheat", 340, true, FoodType.Carb);
        Food wholeMilk = new Food("Whole Milk", 42, false, FoodType.Fat);
        Food potatoes = new Food("Potatoes", 77, true, FoodType.Carb);
        person1Allergies.add(walnuts);
        person1Allergies.add(kiwi);
        person2Allergies.add(shellfish);
        person2Allergies.add(potatoes);
        person3Allergies.add(wheat);
        person4Allergies.add(wholeMilk);

        // LOWCARB FOOD
        Food lowCarbFood1 = new Food("Cauliflower rice", 23, true, FoodType.Protein);
        Food lowCarbFood2 = new Food("Salad", 20, true, FoodType.Fiber);
        Food lowCarbFood3 = new Food("Tofu", 76, true, FoodType.Protein);
        Food lowCarbFood4 = new Food("Fish", 130, false, FoodType.Protein);
        Food lowCarbFood5 = new Food("Broccoli", 20, true, FoodType.Fiber);
        allowedLowCarbFood.add(lowCarbFood1);
        allowedLowCarbFood.add(lowCarbFood2);
        allowedLowCarbFood.add(lowCarbFood3);

        // VEGAN FOOD
        Food veganFood1 = new Food("Rice", 130, true, FoodType.Carb);
        Food veganFood2 = new Food("Salad", 20, true, FoodType.Recipe);
        Food veganFood3 = new Food("Tofu", 76, true, FoodType.Protein);
        Food veganFood4 = new Food("Beans", 130, true, FoodType.Carb);
        Food veganFood5 = new Food("Broccoli", 20, true, FoodType.Fiber);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);
        allowedInVegan.add(veganFood5);

        // FLEXITARIAN FOOD
        Food flexitarianFood1 = new Food("Minced meat of lamb", 300, false, FoodType.Protein);
        Food flexitarianFood2 = new Food("Salad", 20, true, FoodType.Recipe);
        Food flexitarianFood3 = new Food("Tofu", 76, true, FoodType.Protein);
        Food flexitarianFood4 = new Food("Broccoli", 20, true, FoodType.Fiber);
        allowedInFlexitarianDiet.add(flexitarianFood1);
        allowedInFlexitarianDiet.add(flexitarianFood2);
        allowedInFlexitarianDiet.add(flexitarianFood3);
        allowedInFlexitarianDiet.add(flexitarianFood4);

        // HYPERCALORIC FOOD
        Food hypercaloricFood1 = new Food("Minced meat of lamb", 300, false, FoodType.Protein);
        Food hypercaloricFood2 = new Food("Nuts", 606, true, FoodType.Fat);
        Food hypercaloricFood3 = new Food("Mac n cheese", 289, false, FoodType.Recipe);
        Food hypercaloricFood4 = new Food("Brownies", 466, false, FoodType.Recipe);
        allowedInHypercaloricDiet.add(hypercaloricFood1);
        allowedInHypercaloricDiet.add(hypercaloricFood2);
        allowedInHypercaloricDiet.add(hypercaloricFood3);
        allowedInHypercaloricDiet.add(hypercaloricFood4);
    }


    /***Given a Person and a Diet, return true if they are compatible, false otherwise***/

    // MAIN TASK: Given a Person and a Diet, return true if they are compatible, false otherwise
    // PASSED✔
    @Test
    public void requirement4a() {
        Food veganPerson1FavouriteFood = new Food("Beans", 150, true, FoodType.Protein);
        VeganDiet person1VeganDiet = new VeganDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                allowedInVegan, true, 50);

        Person person1 = new Person(veganPerson1FavouriteFood, person1Allergies, person1VeganDiet, 60);
        DietManager dietManager = new DietManager();
        assertTrue(dietManager.areCompatibleVegan(person1, person1VeganDiet));
    }

    // Given a Person and a Diet, return true if they are compatible, false otherwise, expecting to return false in method
    // todo, weight, veganfalse is wrong intentionally
    // PASSED✔
    @Test (expected = IllegalArgumentException.class)
    public void requirement4aException() {
        Food veganPerson1FavouriteFood = new Food("Beans", 150, false, FoodType.Protein);
        VeganDiet person1VeganDiet = new VeganDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                allowedInVegan, false, 50);

        Person person1 = new Person(veganPerson1FavouriteFood, person1Allergies, person1VeganDiet, 45);
        DietManager dietManager = new DietManager();
        assertFalse(dietManager.areCompatibleVegan(person1, person1VeganDiet));
    }

    // Testing ONLY lowcarb-compatibility, expecting to return false in method
    // PASSED✔
    @Test
    public void requirement4a_1() {
        Food lowCarbPerson2FavouriteFood = new Food("Eggs", 155, true, FoodType.Protein);
        LowCarbDiet person2LowCarbDiet = new LowCarbDiet("Person2 LowCarbDiet", 90, "Is this diet compatible with this Person?",
                allowedLowCarbFood, true, 50);

        DietManager dietManager = new DietManager();
        Person person2 = new Person(lowCarbPerson2FavouriteFood, person2Allergies, person2LowCarbDiet, 70);
        assertTrue(dietManager.areCompatibleLowCarb(person2, person2LowCarbDiet));
    }

    // Testing ONLY lowcarb-compatibility
    // todo, fix this to make sure its testing with exception and with the wrong inputs, rune
    // PASSED✔
    @Test
    public void requirement4a_1Exception() {
        Food lowCarbPerson2FavouriteFood = new Food("Eggs", 155, true, FoodType.Protein);
        LowCarbDiet person2LowCarbDiet = new LowCarbDiet("Person2 LowCarbDiet", 90, "Is this diet compatible with this Person?",
                allowedLowCarbFood, true, 50);

        DietManager dietManager = new DietManager();
        Person person2 = new Person(lowCarbPerson2FavouriteFood, person2Allergies, person2LowCarbDiet, 70);
        assertTrue(dietManager.areCompatibleLowCarb(person2, person2LowCarbDiet));
    }

    // Testing ONLY flexitarian-compatibility
    // PASSED✔
    @Test
    public void requirement4a_2() {
        Food flexitarianPerson3FavouriteFood = new Food("Tomahawk Beef", 295, false, FoodType.Protein);
        FlexitarianDiet person3FlexitarianDiet = new FlexitarianDiet("Person3 FlexitarianDiet", 90, "Is this diet compatible with this Person?",
                allowedInFlexitarianDiet, true, 5000, flexitarianPerson3FavouriteFood);

        DietManager dietManager = new DietManager();
        Person person3 = new Person(flexitarianPerson3FavouriteFood, person3Allergies, person3FlexitarianDiet, 90);
        assertTrue(dietManager.areCompatibleFlexitarian(person3, person3FlexitarianDiet, flexitarianPerson3FavouriteFood));
    }

    // Testing ONLY flexitarian-compatibility
    // todo, fix this to make sure its testing with exception and with the wrong inputs, rune
    // PASSED✔
    @Test
    public void requirement4a_2Exception() {
        Food flexitarianPerson3FavouriteFood = new Food("Tomahawk Beef", 295, false, FoodType.Protein);
        FlexitarianDiet person3FlexitarianDiet = new FlexitarianDiet("Person3 FlexitarianDiet", 90, "Is this diet compatible with this Person?",
                allowedInFlexitarianDiet, true, 5000, flexitarianPerson3FavouriteFood);

        DietManager dietManager = new DietManager();
        Person person3 = new Person(flexitarianPerson3FavouriteFood, person3Allergies, person3FlexitarianDiet, 90);
        assertTrue(dietManager.areCompatibleFlexitarian(person3, person3FlexitarianDiet, flexitarianPerson3FavouriteFood));
    }

    // Testing ONLY hypercaloric-compatibility
    // PASSED✔
    @Test
    public void requirement4a_3() {
        Food hypercaloricPerson4FavouriteFood = new Food("Spaghetti", 295, true, FoodType.Carb);
        HypercaloricDiet person4HypercaloricDiet = new HypercaloricDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                allowedInHypercaloricDiet, false, 150, 2000);

        DietManager dietManager = new DietManager();
        Person person4 = new Person(hypercaloricPerson4FavouriteFood, person4Allergies, person4HypercaloricDiet, 89);
        assertTrue(dietManager.areCompatibleHypercaloric(person4, person4HypercaloricDiet));
    }

    // Testing ONLY hypercaloric-compatibility
    // todo, fix this to make sure its testing with exception and with the wrong inputs, rune
    // PASSED✔
    @Test
    public void requirement4a_3Exception() {
        Food hypercaloricPerson4FavouriteFood = new Food("Spaghetti", 295, true, FoodType.Carb);
        HypercaloricDiet person4HypercaloricDiet = new HypercaloricDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                allowedInHypercaloricDiet, false, 150, 2000);

        DietManager dietManager = new DietManager();
        Person person4 = new Person(hypercaloricPerson4FavouriteFood, person4Allergies, person4HypercaloricDiet, 89);
        assertTrue(dietManager.areCompatibleHypercaloric(person4, person4HypercaloricDiet));
    }
}
