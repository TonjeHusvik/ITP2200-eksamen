import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class VeganDietTest {
    ArrayList<Food> allowedInVegan = new ArrayList<>();


    @Before
    public void loadIn(){
        addVeganFoods();
    }

    @Test
    public void addVeganFoods() {
        Food veganFood1 = new Food("Rice", 130, true, FoodType.Carb);
        Food veganFood2 = new Food("Salad", 20, true, FoodType.Fiber);
        Food veganFood3 = new Food("Tofu", 200, false, FoodType.Protein);
        Food veganFood4 = new Food("Beans", 130, true, FoodType.Carb);
        Food veganFood5 = new Food("Broccoli", 20, true, FoodType.Fiber);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);
        allowedInVegan.add(veganFood5);

    }

    // returnerer antall som er satt true av allowedInVegan arrayet
/*    @Test*/
/*    public void testVegan() {

        for (int i = 0; i < allowedInVegan.size(); i++){
            System.out.println(allowedInVegan.get(i));
        }

        for (Food f : allowedInVegan) {


            if (f.isVegan()) {

                VeganDiet veganDiet1 = new VeganDiet(30, "Test", allowedInVegan, true, 1);

                assertTrue(veganDiet1.isVegan());
                System.out.println(veganDiet1.isVegan());
            }
        }
    }*/

/*    @Test
    public void testVegan2() {
        VeganDiet veganDiet1 = new VeganDiet(40, "Test", allowedInVegan, true, 1);

        assertTrue(veganDiet1.isVegan());
        System.out.println(veganDiet1.isVegan());
    }*/

    @Test
    public void testDurationOfAnDiet() {

        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 400, "Save the planet!", allowedInVegan, true, 2);

        // 400 dager skal returnere 1 år, 1 mnd 5 dager ish.
        System.out.println(veganDiet1.writeDuration(veganDiet1));
    }
}
