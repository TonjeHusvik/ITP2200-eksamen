import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔

public class Req_4_Test {

    FoodContainerReq_4 foodContainerReq_4 = new FoodContainerReq_4();

    //______________________________________________________________________________________________

    /*** Given a Person and a Diet, return true if they are compatible, false otherwise ***/

    // MAIN TASK: Given a Person and a Diet, return true if they are compatible, false otherwise
    // PASSED✔
    @Test
    public void requirement4a() {
        Food veganPerson1FavouriteFood = new Food("Beans", 150, true, FoodType.PROTEIN);
        VeganDiet person1VeganDiet = new VeganDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                foodContainerReq_4.allowedInVegan(), true, 50);

        Person person1 = new Person(veganPerson1FavouriteFood, foodContainerReq_4.person1Allergies(), person1VeganDiet, 60);
        DietManager dietManager = new DietManager();
        assertTrue(dietManager.areCompatibleVegan(person1, person1VeganDiet));
    }

    // Given a Person and a Diet, return true if they are compatible, false otherwise, expecting the exception
    // weight and vegan = false is wrong intentionally, and these are not compatible together
    // PASSED✔
    @Test(expected = IllegalArgumentException.class)
    public void requirement4aException() {
        Food veganPerson1FavouriteFood = new Food("Meatballs", 196, false, FoodType.PROTEIN);
        VeganDiet person1VeganDiet = new VeganDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                foodContainerReq_4.allowedInVegan(), false, 50);

        Person person1 = new Person(veganPerson1FavouriteFood, foodContainerReq_4.person1Allergies(), person1VeganDiet, 45);
        DietManager dietManager = new DietManager();
        assertFalse(dietManager.areCompatibleVegan(person1, person1VeganDiet));
    }

    // Testing ONLY lowcarb-compatibility, expecting to return false in method
    // PASSED✔
    @Test
    public void requirement4a_1() {
        Food lowCarbPerson2FavouriteFood = new Food("Beans", 150, true, FoodType.PROTEIN);
        LowCarbDiet person2LowCarbDiet = new LowCarbDiet("Person2 LowCarbDiet", 90, "Is this diet compatible with this Person?",
                foodContainerReq_4.allowedLowCarbFood(), true, 50);

        DietManager dietManager = new DietManager();
        Person person2 = new Person(lowCarbPerson2FavouriteFood, foodContainerReq_4.person2Allergies(), person2LowCarbDiet, 70);
        assertTrue(dietManager.areCompatibleLowCarb(person2, person2LowCarbDiet));
    }

    // Testing ONLY lowcarb-compatibility
    // weight, more than 2x carbs, and the person is allergic to 50% of the food in the allergic arraylist
    // PASSED✔
    @Test(expected = IllegalArgumentException.class)
    public void requirement4a_1Exception() {
        Food lowCarbPerson2FavouriteFood = new Food("Eggs", 155, true, FoodType.PROTEIN);
        LowCarbDiet person2LowCarbDiet = new LowCarbDiet("Person2 LowCarbDiet", 90, "Is this diet compatible with this Person?",
                foodContainerReq_4.allowedLowCarbFoodCarb(), true, 50);

        DietManager dietManager = new DietManager();
        Person person2 = new Person(lowCarbPerson2FavouriteFood, foodContainerReq_4.personAllergiesInException(), person2LowCarbDiet, 45);
        assertFalse(dietManager.areCompatibleLowCarb(person2, person2LowCarbDiet));
    }

    // Testing ONLY flexitarian-compatibility
    // PASSED✔
    @Test
    public void requirement4a_2() {
        Food flexitarianPerson3FavouriteFood = new Food("Tomahawk Beef", 295, false, FoodType.PROTEIN);
        FlexitarianDiet person3FlexitarianDiet = new FlexitarianDiet("Person3 FlexitarianDiet", 90, "Is this diet compatible with this Person?",
                foodContainerReq_4.allowedInFlexitarianDiet(), true, 5000, flexitarianPerson3FavouriteFood);

        DietManager dietManager = new DietManager();
        Person person3 = new Person(flexitarianPerson3FavouriteFood, foodContainerReq_4.person3Allergies(), person3FlexitarianDiet, 90);
        assertTrue(dietManager.areCompatibleFlexitarian(person3, person3FlexitarianDiet, flexitarianPerson3FavouriteFood));
    }

    // Testing ONLY flexitarian-compatibility
    // preferred meat is vegan and carb, person is allergic to 50% of the food in the allergic arraylist
    // PASSED✔
    @Test(expected = IllegalArgumentException.class)
    public void requirement4a_2Exception() {
        Food flexitarianPerson3FavouriteFood = new Food("Tomahawk Beef", 295, true, FoodType.CARB);
        FlexitarianDiet person3FlexitarianDiet = new FlexitarianDiet("Person3 FlexitarianDiet", 90, "Is this diet compatible with this Person?",
                foodContainerReq_4.allowedInFlexitarianDiet(), true, 5000, flexitarianPerson3FavouriteFood);

        DietManager dietManager = new DietManager();
        Person person3 = new Person(flexitarianPerson3FavouriteFood, foodContainerReq_4.personAllergiesInException(), person3FlexitarianDiet, 90);
        assertTrue(dietManager.areCompatibleFlexitarian(person3, person3FlexitarianDiet, flexitarianPerson3FavouriteFood));
    }

    // Testing ONLY hypercaloric-compatibility
    // PASSED✔
    @Test
    public void requirement4a_3() {
        Food hypercaloricPerson4FavouriteFood = new Food("Bananas", 88, true, FoodType.CARB);
        HypercaloricDiet person4HypercaloricDiet = new HypercaloricDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                foodContainerReq_4.allowedInHypercaloricDiet(), false, 150, 2000);

        DietManager dietManager = new DietManager();
        Person person4 = new Person(hypercaloricPerson4FavouriteFood, foodContainerReq_4.person4Allergies(), person4HypercaloricDiet, 89);
        assertTrue(dietManager.areCompatibleHypercaloric(person4, person4HypercaloricDiet));
    }

    // Testing ONLY hypercaloric-compatibility
    // weight is above the diet's limit, and the person is allergic to 50% of the food in the allergic arraylist
    // PASSED✔
    @Test(expected = IllegalArgumentException.class)
    public void requirement4a_3Exception() {
        Food hypercaloricPerson4FavouriteFood = new Food("Bananas", 88, true, FoodType.CARB);
        HypercaloricDiet person4HypercaloricDiet = new HypercaloricDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                foodContainerReq_4.allowedInHypercaloricDiet(), false, 150, 2000);

        DietManager dietManager = new DietManager();
        Person person4 = new Person(hypercaloricPerson4FavouriteFood, foodContainerReq_4.personAllergiesInException(), person4HypercaloricDiet, 160);
        assertTrue(dietManager.areCompatibleHypercaloric(person4, person4HypercaloricDiet));
    }

    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 4. b: Given a Person and a list of Food, create a random HypercaloricDiet with the following attributes:
     i. daysDuration: random number between 1 and 100.
     ii. purpose: “Random diet”.
     iii. allowedFood: all the Food from the list that the person is not allergic to.
     iv. isVegan: false if there is some non-vegan Food, true otherwise.
     v. maxWeightKg: random number between Person.weight and Person.weight + 20.
     vi. minCaloriesPerDay: random number between 2000 and 4000. ***/

    // PASSED✔
    @Test
    public void randomDiet4b() {
        DietManager randomDietManager = new DietManager();
        Person randomPerson = new Person(new Food("Salad", 10, true, FoodType.FIBER),
                foodContainerReq_4.randomDietWithAllergiesAndFood().get(1), 80);
        System.out.println(randomDietManager.randomDiet(randomPerson, foodContainerReq_4.randomDietWithAllergiesAndFood().get(0)));
    }
}