import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class personRestriction2b {
    ArrayList<Food> allergiesTooMany = new ArrayList<>();
    ArrayList<Food> allergiesOk = new ArrayList<>();
    ArrayList<Food> allowedInDiet = new ArrayList<>();

    Person tooManyAllergies = new Person(allergiesTooMany);
    Person okAmountOfAllergies = new Person(allergiesOk);
    FlexitarianDiet flexiDiet = new FlexitarianDiet("Flexi", 324, "somethin", allowedInDiet,
            false, 1000, (new Food("Tuna", 400, false, FoodType.Protein)));

    @Before
    public void dietAndAllergies() {
        Food flexiFood1 = new Food("Salad", 10, true, FoodType.Fiber);
        Food flexiFood2 = new Food("Crab", 10, false, FoodType.Protein);
        Food flexiFood3 = new Food("Beef", 10, false, FoodType.Protein);
        Food flexiFood4 = new Food("Pomegranate", 10, true, FoodType.Fiber);
        Food flexiFood5 = new Food("Peanuts", 10, true, FoodType.Fat);
        Food flexiFood6 = new Food("Wheat", 10, true, FoodType.Fiber);
        allowedInDiet.add(flexiFood1);
        allowedInDiet.add(flexiFood2);
        allowedInDiet.add(flexiFood3);
        allowedInDiet.add(flexiFood4);
        allowedInDiet.add(flexiFood5);
        allowedInDiet.add(flexiFood6);

        Food allergyFood1 = new Food("Spinach", 10, true, FoodType.Fiber);
        Food allergyFood2 = new Food("Asparagus", 10, false, FoodType.Fiber);
        Food allergyFood3 = new Food("Salmon", 10, false, FoodType.Protein);
        Food allergyFood4 = new Food("Pomegranate", 10, true, FoodType.Fiber);
        Food allergyFood5 = new Food("Peanuts", 10, true, FoodType.Fat);
        Food allergyFood6 = new Food("Wheat", 10, true, FoodType.Fiber);
        allergiesTooMany.add(allergyFood3);
        allergiesTooMany.add(allergyFood4);
        allergiesTooMany.add(allergyFood5);
        allergiesTooMany.add(allergyFood6);

        allergiesOk.add(allergyFood1);
        allergiesOk.add(allergyFood2);
        allergiesOk.add(allergyFood3);
        allergiesOk.add(allergyFood4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tooManyAllergies() {
        tooManyAllergies.personRestriction2b(tooManyAllergies, flexiDiet);
    }

    @Test
    public void okAmountOfAllergies() {
        assertTrue(okAmountOfAllergies.personRestriction2b(okAmountOfAllergies, flexiDiet));
    }

}
