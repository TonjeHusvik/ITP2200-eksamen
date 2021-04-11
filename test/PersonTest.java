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
        Food lowCarbFood2 = new Food("Pork", 10, false, FoodType.Fat);
        Food lowCarbFood3 = new Food("Peanuts", 10, false, FoodType.Fat);
        Food lowCarbFood4 = new Food("Shellfish", 10, false, FoodType.Fat);
        Food lowCarbFood5 = new Food("Potatoes", 10, false, FoodType.Fat);
        allowedInLowCarb.add(lowCarbFood1);
        allowedInLowCarb.add(lowCarbFood2);
        allowedInLowCarb.add(lowCarbFood3);
        allowedInLowCarb.add(lowCarbFood4);
        allowedInLowCarb.add(lowCarbFood5);

    }

    // TODO 2a. If their favourite food is non-vegan, they cannot follow a vegan diet.
    @Test
    public void requirement2_a() {
        Person person1 = new Person(new Food("Meatloaf", 400, false, FoodType.Fat));
        VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);

        if (!person1.getFavouriteFood().isVegan() && veganDiet.isVegan()){
            assertTrue("This person cannot follow this diet", !person1.getFavouriteFood().isVegan() && veganDiet.isVegan());
        }else{
            throw new IllegalArgumentException("This person's favouriteFood is " + person1.getFavouriteFood().getName() + " and can follow this diet.");
        }
    }

    // TODO 2b. They cannot follow a diet if they are allergic to 50% or more of the food allowed by the diet.
    @Test
    public void requirement2_b(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 20, "weight loss", allowedInLowCarb, false, 80);

        Food[] person1Allergies = new Food[4];
        person1Allergies[0] = new Food("Apple", 35, true, FoodType.Fiber);
        person1Allergies[1] = new Food("Shellfish", 500, false, FoodType.Recipe);
        person1Allergies[2] = new Food("Pork", 35, true, FoodType.Fiber);
        person1Allergies[3] = new Food("Peanuts", 500, false, FoodType.Recipe);

        //Person person1 = new Person(new Food("Chicken wings", 500, false, FoodType.Protein), person1Allergies, lowCarbDiet, 50);

        int teller = 0;


        for (Food allowedFood:lowCarbDiet.getAllowedFood()) {
            for (Food allergies:person1Allergies) {
                if (allowedFood.getName().equals(allergies.getName())){
                    teller = teller+1; // counter matches
                    System.out.println(teller);

                    if (teller >= lowCarbDiet.getAllowedFood().size()/2){
                        assertTrue(allowedFood.getName().equals(allergies.getName()));

                    }
                }
            }
        }
    }




}
