import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PersonTest {
    ArrayList<Food> allDiets = new ArrayList<>();

    @Before
    public void tester(){
        Food random1 = new Food("veganFood", 20, true, FoodType.Fiber);
        Food random2 = new Food("nonVegan", 20, false, FoodType.Fiber);
        allDiets.add(random1);
        allDiets.add(random2);

    }

    // TODO a. If their favourite food is non-vegan, they cannot follow a vegan diet.
    @Test
    public void requirement2_a() {

        Food[] person1allergies = new Food[1];
        person1allergies[0] = new Food("Milk", 10, false, FoodType.Fat);

        Person person1 = new Person(new Food("Meatloaf", 100, false, FoodType.Fat),
                person1allergies,
                new LowCarbDiet("ss",30,"s", allDiets, false, 50),
                50);



        if (!person1.getFood().isVegan()){

        }

    }
}
