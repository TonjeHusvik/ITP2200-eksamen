import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LowCarbDietTest {
    ArrayList <Food> allowedLowCarbFood = new ArrayList<>();
    @Before
    public void setUp() throws Exception {

        Food lowCarbFood1 = new Food("Cauliflower rice", 23, true, FoodType.Protein);
        Food lowCarbFood2 = new Food("Salad", 20, false, FoodType.Fiber);
        Food lowCarbFood3 = new Food("Tofu", 200, true, FoodType.Protein);
        Food lowCarbFood4 = new Food("Fish", 130, true, FoodType.Protein);
        Food lowCarbFood5 = new Food("Broccoli", 20, true, FoodType.Fiber);
        allowedLowCarbFood.add(lowCarbFood1);
        allowedLowCarbFood.add(lowCarbFood2);
        allowedLowCarbFood.add(lowCarbFood3);
        allowedLowCarbFood.add(lowCarbFood4);
        allowedLowCarbFood.add(lowCarbFood5);

        Food[] allergies = new Food[2];
        allergies[0] = new Food("Apple", 35, true, FoodType.Fiber);
        allergies[1] = new Food("Chocolate", 500, false, FoodType.Recipe);




        Person person = new Person(new Food("Chicken", 130, false, FoodType.Protein),
                               allergies,
                               new LowCarbDiet(30, "Health", allowedLowCarbFood, false, 50),
                               79);

        }

    @Test
    public void writeAllowedFoodTest(){
        LowCarbDiet lowCarbD1 = new LowCarbDiet(30, "Health", allowedLowCarbFood, false, 50);

        System.out.println(allowedLowCarbFood.toString());
        //System.out.println("The following food is allowed in this LowCarbDiet: "  + lowCarbD1.writeAllowedFood());
        //assertEquals(lowCarbD1.writeAllowedFood(), allowedLowCarbFood.toString());
        assertTrue(allowedLowCarbFood);
    }

    @Test
    public void getMinWeightKg() {
    }

    @Test
    public void setMinWeightKg() {
    }
}