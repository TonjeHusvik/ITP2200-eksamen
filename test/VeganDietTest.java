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

/*    @Test
    public void testVegan() {

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
    }

    @Test
    public void testVegan2() {
        VeganDiet veganDiet1 = new VeganDiet(40, "Test", allowedInVegan, true, 1);

        assertTrue(veganDiet1.isVegan());
        System.out.println(veganDiet1.isVegan());
    }*/

    @Test
    public void requirement3_a() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 400, "Save the planet!", allowedInVegan, true, 2);

        String result = veganDiet1.writeDuration(veganDiet1);
        assertEquals("This VeganDiet lasts for 1 years, 1 months and 5 days", result);
    }


    @Test
    // Testing intentionally wrong
    public void requirement3_a1() {
        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 500, "Save the planet!", allowedInVegan, true, 2);
        // returning 1 years, , 4 months and 15 days
        String result = veganDiet1.writeDuration(veganDiet1);
        assertEquals("This VeganDiet lasts for 1 years, 1 months and 5 days", result);
    }


    @Test
    public void requirement3_b() {


        VeganDiet veganDiet1 = new VeganDiet("VeganDiet", 70, "Save the earth.", allowedInVegan, true, 3);


        String result = veganDiet1.writeAllowedFood(veganDiet1)
                        .replace("[",  "")
                        .replace("]", "")
                        .replace("\r", "")
                        .replaceAll("\n", "");


        assertEquals("The following food is allowed in this VeganDiet: Rice, Salad, Tofu, Beans, Broccoli", result);
        System.out.println(result);
    }
}
