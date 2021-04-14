import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DietTest {

    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> person1Allergies = new ArrayList<>();
    ArrayList<Food> person2Allergies = new ArrayList<>();
    ArrayList<Food> person3Allergies = new ArrayList<>();
    ArrayList<Food> person4Allergies = new ArrayList<>();

    @Before
    public void setup() {

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


    /***Given a Person and a Diet, return true if they are compatible, false otherwise***/

    // MAIN TASK: Given a Person and a Diet, return true if they are compatible, false otherwise
    @Test
    public void requirement4_a() {
        Food veganPerson1FavouriteFood = new Food("Beans", 150, true, FoodType.Protein);
        VeganDiet person1VeganDiet = new VeganDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                allowedInVegan, true, 50);

        Food lowCarbPerson2FavouriteFood = new Food("Eggs", 155, true, FoodType.Protein);
        LowCarbDiet person2LowCarbDiet = new LowCarbDiet("Person2 LowCarbDiet", 90, "Is this diet compatible with this Person?",
                allowedInVegan, true, 50);


        //FIXME fixe allowedFood arraylisten til denne dietten
        Food flexitarianPerson3FavouriteFood = new Food("Tomahawk Beef", 295, false, FoodType.Protein);
        FlexitarianDiet person3FlexitarianDiet = new FlexitarianDiet("Person3 FlexitarianDiet", 90, "Is this diet compatible with this Person?",
                allowedInVegan, true, 5000, flexitarianPerson3FavouriteFood);


        //FIXME fixe allowedFood arraylisten til denne dietten
        Food hypercaloricPerson4FavouriteFood = new Food("Spaghetti", 295, true, FoodType.Carb);
        HypercaloricDiet person4HypercaloricDiet = new HypercaloricDiet("Person1 VeganDiet", 90, "Is this diet compatible with this Person?",
                allowedInVegan, false, 150, 4000);




        // FIXME må fikses under for personobjekter
        Person person1 = new Person(veganPerson1FavouriteFood, person1Allergies, person1VeganDiet, 60);
        Person person2 = new Person(lowCarbPerson2FavouriteFood, person2Allergies, person2LowCarbDiet, 70);
        Person person3 = new Person();
        DietManager dietManager = new DietManager();

        assertTrue(dietManager.areCompatible(person1, person1VeganDiet));
    }

























}
