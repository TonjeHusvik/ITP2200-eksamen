import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonTest {
    ArrayList<Food> allowedInVegan = new ArrayList<>();

    @Before
    public void diets(){
        Food vegFood = new Food("Salad", 10, true, FoodType.Fiber);
        allowedInVegan.add(vegFood);
        //VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);
    }

    // TODO a. If their favourite food is non-vegan, they cannot follow a vegan diet.
    @Test
    public void requirement2_a() {
        Person person1 = new Person(new Food("Meatloaf", 400, false, FoodType.Fat));
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);

        assertFalse("bla", !person1.getFood().isVegan() && veganDiet.isVegan());

        //if (!person1.getFood().isVegan() && veganDiet.isVegan()){
            //System.out.println("This person's favouriteFood is " + person1.getFood().getName() + " and cannot follow a vegan diet.");
            //throw new IllegalArgumentException("This person's favouriteFood is " + person1.getFood().getName() + " and cannot follow a vegan diet.");
        }

    }
}
