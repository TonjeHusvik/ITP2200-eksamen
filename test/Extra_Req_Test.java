import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Extra_Req_Test {

    //Testing maxMeatGramsPerWeek, a previously unused field.
    //2 tests: One with more than 500g meat per week,
    //and one with less.

    FoodContainerReq_3 fc = new FoodContainerReq_3();

    @Test (expected = IllegalArgumentException.class)
    public void moreThanMax() {
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Too much meat", 35, "Eating lots of meat", fc.allowedInFlexitarian(),
                false, 2000);
        assertTrue(flexiDiet.maxMeatGramsPerWeek(flexiDiet));
    }

    @Test
    public void lessThanMax() {
        FlexitarianDiet flexiDiet = new FlexitarianDiet("Ok amount of meat", 35, "Eating less meat", fc.allowedInFlexitarian(),
                false, 450);
        assertTrue(flexiDiet.maxMeatGramsPerWeek(flexiDiet));
    }
}
