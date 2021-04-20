import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Extra_Req_Test {

    // Requirement: maxMeatGramsPerWeek can't exceed 500g.
    // 2 tests: One with more than 500g meat per week,
    // and one with less.

    FoodContainerReq_3 fc = new FoodContainerReq_3();

    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void moreThanMax() {
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Too much meat", 35, "Eating lots of meat", fc.allowedInFlexitarian(),
                false, 2000);
        flexiDiet.maxMeatGramsPerWeek(flexiDiet);
    }

    // PASSED✔️
    @Test
    public void lessThanMax() {
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Ok amount of meat", 35, "Eating less meat", fc.allowedInFlexitarian(),
                false, 450);
        assertTrue(flexiDiet.maxMeatGramsPerWeek(flexiDiet));
    }

    // Requirement: a food must have at least 1 calorie per 100g.
    // 2 tests: One with less than 1 calorie,
    // and one with more.

    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void lessThanOneCalorie() {
        Food noEnergy = new Food("Water", 0, true, FoodType.RECIPE);
        noEnergy.atLeastOneCalorie();
    }

    // PASSED✔️
    @Test
    public void moreThanOneCalorie() {
        Food someEnergy = new Food("Cucumber", 15, true, FoodType.FIBER);
        assertTrue(someEnergy.atLeastOneCalorie());
    }
}
