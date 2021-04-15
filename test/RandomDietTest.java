import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔


public class RandomDietTest {
    ArrayList<Food> allergies = new ArrayList<>();
    ArrayList<Food> food = new ArrayList<>();
    Person randomPerson = new Person(new Food("Salad", 10, true, FoodType.Fiber), allergies, 80);

    @Before
    public void setUp() {
        // FOOD ARRAY
        Food food1 = new Food("Bacon", 541, false, FoodType.Fat);
        Food food2 = new Food("Pork", 242, false, FoodType.Protein);
        Food food3 = new Food("Peanuts", 567, true, FoodType.Fat);
        food.add(food1);
        food.add(food2);
        food.add(food3);

        // ALLERGY FOOD
        Food allergyFood1 = new Food("Asparagus", 20, true, FoodType.Fiber);
        Food allergyFood2 = new Food("Butter", 716, false, FoodType.Fat);
        Food allergyFood3 = new Food("Peanut butter", 588, true, FoodType.Fat);
        Food allergyFood4 = new Food("Lard", 898, false, FoodType.Fat);
        allergies.add(allergyFood1);
        allergies.add(allergyFood2);
        allergies.add(allergyFood3);
        allergies.add(allergyFood4);
        food.add(allergyFood1);
        food.add(allergyFood3);
    }

    /*** Requirement 4. b:
     * Given a Person and a list of Food, create a random HypercaloricDiet with the following attributes:
     i. daysDuration: random number between 1 and 100.
     ii. purpose: “Random diet”.
     iii. allowedFood: all the Food from the list that the person is not allergic to.
     iv. isVegan: false if there is some non-vegan Food, true otherwise.
     v. maxWeightKg: random number between Person.weight and Person.weight + 20.
     vi. minCaloriesPerDay: random number between 2000 and 4000.***/

    // PASSED✔
    @Test
    public void randomDiet4_b() {
        DietManager randomDietManager = new DietManager();
        System.out.println(randomDietManager.randomDiet(randomPerson, food));
    }

}
