import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class randomDiet4bTest {
    ArrayList<Food> allergies = new ArrayList<>();
    ArrayList<Food> food = new ArrayList<>();
    Person randomPerson = new Person(new Food("Salad", 10, true, FoodType.Fiber), allergies, 80);

    @Before
    public void setUp() {
        Food food1 = new Food("Bacon", 10, false, FoodType.Fat);
        Food food2 = new Food("Pork", 10, false, FoodType.Protein);
        Food food3 = new Food("Peanuts", 10, true, FoodType.Fat);

        Food allergyFood1 = new Food("Asparagus", 10, true, FoodType.Fiber);
        Food allergyFood2 = new Food("Butter", 10, false, FoodType.Fat);
        Food allergyFood3 = new Food("Peanut butter", 10, true, FoodType.Fat);
        Food allergyFood4 = new Food("Lard", 10, false, FoodType.Fat);

        allergies.add(allergyFood1);
        allergies.add(allergyFood2);
        allergies.add(allergyFood3);
        allergies.add(allergyFood4);

        food.add(food1);
        food.add(food2);
        food.add(food3);
        food.add(allergyFood1);
        food.add(allergyFood3);
    }

    //TODO: No assertions here, because we're only testing that the method works
    @Test
    public void randomDiet4b() {
        DietManager randomDietManager = new DietManager();
        System.out.println(randomDietManager.randomDiet(randomPerson, food));
    }

}
