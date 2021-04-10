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

        // TODO kjører 2 ganger pga. loadIn(); metoden
        Assertions.assertAll("Should return info about vegan foods are vegan or not.",
                () -> assertTrue(veganFood1.isVegan()),
                () -> assertTrue(veganFood2.isVegan()),
                () -> assertTrue(veganFood3.isVegan()),
                () -> assertTrue(veganFood4.isVegan()),
                () -> assertTrue(veganFood5.isVegan())
        );
    }

    // returnerer antall som er satt true av allowedInVegan arrayet
    @Test
    public void testVegan() {

        for (int i = 0; i < allowedInVegan.size(); i++){
            System.out.println(allowedInVegan.get(i));
        }

        for (Food f : allowedInVegan) {


            if (f.isVegan()) {

                VeganDiet veganDiet1 = new VeganDiet(30, "Test", f, true, 1);

                assertTrue(veganDiet1.isVegan());
                System.out.println(veganDiet1.isVegan());
            }
        }
    }

    @Test
    public void testVegan2() {
        VeganDiet veganDiet1 = new VeganDiet(40, "Test", allowedInVegan, true, 1);

        System.out.println(veganDiet1.writeAllowedFood());
    }
}
