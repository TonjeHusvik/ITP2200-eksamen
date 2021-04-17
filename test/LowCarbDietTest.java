import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔

public class LowCarbDietTest {

    ArrayList <Food> allowedLowCarbFood = new ArrayList<>();
    ArrayList <Food> allowedLowCarbFoodCarb = new ArrayList<>();

    @Before
    public void setUp() {
        // LOWCARB FOOD
        Food lowCarbFood1 = new Food("Cauliflower rice", 23, true, FoodType.Protein);
        Food lowCarbFood2 = new Food("Salad", 20, true, FoodType.Fiber);
        Food lowCarbFood3 = new Food("Tofu", 200, true, FoodType.Protein);
        Food lowCarbFood4 = new Food("Fish", 130, false, FoodType.Protein);
        Food lowCarbFood5 = new Food("Broccoli", 20, true, FoodType.Fiber);
        Food lowCarbFood6 = new Food("Seitan", 200, true, FoodType.Carb);
        Food lowCarbFood7 = new Food("Bread", 400, true, FoodType.Carb);
        allowedLowCarbFood.add(lowCarbFood1);
        allowedLowCarbFood.add(lowCarbFood2);
        allowedLowCarbFood.add(lowCarbFood3);
        allowedLowCarbFood.add(lowCarbFood4);
        allowedLowCarbFood.add(lowCarbFood5);
        allowedLowCarbFood.add(lowCarbFood6);
        allowedLowCarbFood.add(lowCarbFood7);

        // TOO MANY CARBS
        Food allowCarbFoodCarb1 = new Food("Pasta", 245, true, FoodType.Carb);
        Food allowCarbFoodCarb2 = new Food("Chocolate", 550, true, FoodType.Carb);
        Food allowCarbFoodCarb3 = new Food("Sweet potato", 150, true, FoodType.Carb);
        allowedLowCarbFoodCarb.add(allowCarbFoodCarb1);
        allowedLowCarbFoodCarb.add(allowCarbFoodCarb2);
        allowedLowCarbFoodCarb.add(allowCarbFoodCarb3);

    }


    /***Requirement 1.e: The maximum carb-type foods that can be included in a LowCarbDiet is two.***/

    // MAIN TASK:
    // The maximum carb-type foods that can be included in a LowCarbDiet is two
    // PASSED✔️
    @Test
    public void requirement1_e(){
        LowCarbDiet lowCarbDiet1 = new LowCarbDiet("Lowcarb Diet", 30, "Loose weight", allowedLowCarbFood, false, 50);
        assertTrue(lowCarbDiet1.lowCarbRestriction1e());
    }

    // Testing the amount of FoodType Carb, with more than 2. Expecting an exception because it is more than 2.
    // PASSED✔
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_e_1(){
        LowCarbDiet lowCarbDiet1 = new LowCarbDiet("Lowcarb Diet", 30, "Loose weight", allowedLowCarbFoodCarb, false, 50);
        lowCarbDiet1.lowCarbRestriction1e();
    }
}
