import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class personRestriction2a {
    ArrayList<Food> allowedInVegan = new ArrayList<>();
    VeganDiet veganDiet = new VeganDiet("Vegan diet", 20, "health", allowedInVegan,true,20);
    Person personNotVeganFavorite = new Person(new Food("Tuna", 400, false, FoodType.Protein),
                                                veganDiet);
    Person personVeganFavorite = new Person(new Food("Smoked tofu", 400, true, FoodType.Protein),
                                                veganDiet);

    @Before
    public void diets() {
        Food veganFood1 = new Food("Salad", 10, true, FoodType.Fiber);
        allowedInVegan.add(veganFood1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void notVeganFavorite() {
        assertTrue(personNotVeganFavorite.personRestriction2a());
    }

    @Test
    public void veganFavorite() {
        assertTrue(personVeganFavorite.personRestriction2a());
    }

}
