import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PersonTest {
    ArrayList<Food> allowedInVegan = new ArrayList<>();
    ArrayList<Food> allowedInLowCarb = new ArrayList<>();

    @Before
    public void diets(){
        Food veganFood1 = new Food("Salad", 10, true, FoodType.Fiber);
        allowedInVegan.add(veganFood1);

        Food lowCarbFood1 = new Food("Bacon", 10, false, FoodType.Fat);
        allowedInLowCarb.add(lowCarbFood1);
        LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 20, "weight loss", allowedInLowCarb, false, 80);
    }

    // TODO a. If their favourite food is non-vegan, they cannot follow a vegan diet.
    @Test
    public void requirement2_a() {
        Person person1 = new Person(new Food("Meatloaf", 400, false, FoodType.Fat));
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);

        if (!person1.getFood().isVegan() && veganDiet.isVegan()){
            assertTrue("This person cannot follow this diet", !person1.getFood().isVegan() && veganDiet.isVegan());
        }else{
            throw new IllegalArgumentException("This person's favouriteFood is " + person1.getFood().getName() + " and can follow this diet.");
        }
    }

    @Test
    public void requirement2_b(){

    }
}
