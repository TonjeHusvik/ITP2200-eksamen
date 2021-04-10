
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LowCarbDietTest {
    ArrayList <Food> allowedLowCarbFood = new ArrayList<>();
    ArrayList <Food> allowedLowCarbFoodVegan = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
        Food lowCarbFood1 = new Food("Cauliflower rice", 23, true, FoodType.Protein);
        Food lowCarbFood2 = new Food("Salad", 20, true, FoodType.Fiber);
        Food lowCarbFood3 = new Food("Tofu", 200, true, FoodType.Protein);
        Food lowCarbFood4 = new Food("Fish", 130, false, FoodType.Protein);
        Food lowCarbFood5 = new Food("Broccoli", 20, true, FoodType.Fiber);
        allowedLowCarbFood.add(lowCarbFood1);
        allowedLowCarbFood.add(lowCarbFood2);
        allowedLowCarbFood.add(lowCarbFood3);
        allowedLowCarbFood.add(lowCarbFood4);
        allowedLowCarbFood.add(lowCarbFood5);

        Food[] jacksAllergies = new Food[2];
        jacksAllergies[0] = new Food("Apple", 35, true, FoodType.Fiber);
        jacksAllergies[1] = new Food("Chocolate", 500, false, FoodType.Recipe);

        Food lowCarbFoodVegan1 = new Food("Apple", 30, false, FoodType.Fiber);
        Food lowCarbFoodVegan2 = new Food("Orange", 50, true, FoodType.Fiber);
        Food lowCarbFoodVegan3 = new Food("Seitan", 200, true, FoodType.Recipe);
        Food lowCarbFoodVegan4 = new Food("Bread", 400, false, FoodType.Carb);
        Food lowCarbFoodVegan5 = new Food("Lentils", 250, true, FoodType.Protein);
        allowedLowCarbFoodVegan.add(lowCarbFoodVegan1);
        allowedLowCarbFoodVegan.add(lowCarbFoodVegan2);
        allowedLowCarbFoodVegan.add(lowCarbFoodVegan3);
        allowedLowCarbFoodVegan.add(lowCarbFoodVegan4);
        allowedLowCarbFoodVegan.add(lowCarbFoodVegan5);






        Person JACK = new Person(new Food("Chicken", 130, false, FoodType.Protein),
                jacksAllergies,
                               new LowCarbDiet("LowcarbDiet", 30, "Health", allowedLowCarbFood, false, 50),
                               79);

        }

    @Test
    public void writeAllowedFoodTest(){
        LowCarbDiet lowCarbD1 = new LowCarbDiet("LowcarbDiet", 30, "Health", allowedLowCarbFood, false, 50);

        System.out.println(allowedLowCarbFood.toString());
        //System.out.println("The following food is allowed in this LowCarbDiet: "  + lowCarbD1.writeAllowedFood());
        //assertEquals(lowCarbD1.writeAllowedFood(), allowedLowCarbFood.toString());
    }
    //TODO a. If a diet contains any non-vegan food, it is considered not vegan (i.e., isVegan = false).
    @Test
    public void  requirement1_a(){

        LowCarbDiet lowCarbD1 = new LowCarbDiet("LowcarbDiet", 30, "Health", allowedLowCarbFood, false, 50);
        for (Food f: lowCarbD1.getAllowedFood()) {
            if(!f.isVegan()){
                assertFalse(f.isVegan());
                System.out.println("not vegan");
            }
        }
    }

    //TODO If a diet contains only vegan food, it is considered vegan, even if it is not a VeganDiet (e.g., it could be a LowCarbDiet).
    @Test
    public void  requirement1_b() throws Exception {
        LowCarbDiet lowCarbD1 = new LowCarbDiet("LowcarbDiet", 30, "Health", allowedLowCarbFoodVegan, false, 50);
        for (Food f : lowCarbD1.getAllowedFood()) {
            if (f.isVegan()) {
                assertTrue(f.isVegan());

            }
        }
    }



    @Test
    public void getMinWeightKg() {
    }

    @Test
    public void setMinWeightKg() {
    }
}
