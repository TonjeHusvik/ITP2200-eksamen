import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class VeganDietTest {
    ArrayList<Food> allowedInVegan = new ArrayList<>();


    @Before
    public void loadIn(){
        addVeganFoods();
    }

    public void addVeganFoods() {
        Food veganFood1 = new Food("Rice", 130, true, FoodType.Carb);
        Food veganFood2 = new Food("Salad", 20, false, FoodType.Fiber);
        Food veganFood3 = new Food("Tofu", 200, true, FoodType.Protein);
        Food veganFood4 = new Food("Beans", 130, true, FoodType.Carb);
        Food veganFood5 = new Food("Broccoli", 20, true, FoodType.Fiber);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);
        allowedInVegan.add(veganFood5);
    }

    @Test
    public void testVegan() {
        for (int i = 0; i < allowedInVegan.size(); i++);{
            System.out.println(allowedInVegan.get(i));
        }


            VeganDiet veganDiet1 = new VeganDiet(30, "Test", allowedInVegan, true, 1);

            assertTrue(veganDiet1.isVegan());
            System.out.println(veganDiet1.isVegan());

    }
}
