import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Req_3_Test  {

    FoodContainerReq_3 foodContainerReq_3 = new FoodContainerReq_3();

    /*** Requirement 3. a: Write the duration of a diet in terms of years, months and days, e.g.,
     “This VeganDiet lasts for 2 years, 3 months and 5 days”***/

    // MAIN TASK: Write the duration of a diet in terms of years, months and days, e.g.,
    // “This VeganDiet lasts for 2 years, 3 months and 5 days”
    // Testing only one diet for this req, all the subclasses inherits from the Diet class (parent)
    // PASSED✔️
    @Test
    public void requirement3a() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 400, "Summerbody",
                foodContainerReq_3.allowedInFlexitarian(), true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeDuration(flexitarianDiet1);
        assertEquals("This FlexitarianDiet lasts for 1 years, 1 months and 5 days", result);
    }

    // Test days only
    // PASSED✔️
    @Test
    public void requirement3a_1() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 450, "Winterbody",
                foodContainerReq_3.allowedInFlexitarian(), true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeDurationInDays(flexitarianDiet1);
        assertEquals("This FlexitarianDiet lasts for 450 days", result);
    }

    // Test months only (has to be more than 30 days, else an exception is thrown).
    // PASSED✔️
    @Test
    public void requirement3a_2() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 700, "What is the duration of this diet?",
                foodContainerReq_3.allowedInFlexitarian(), true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeDurationInMonths(flexitarianDiet1);
        assertEquals("This FlexitarianDiet lasts for 23 months", result);
    }

    // Test years only (has to be more than 1 years, else an exception is thrown).
    // PASSED✔️
    @Test
    public void requirement3a_3() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 400, "What is the duration of this diet?",
                foodContainerReq_3.allowedInFlexitarian(), true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeDurationInYears(flexitarianDiet1);
        assertEquals("This FlexitarianDiet lasts for 1 years", result);
    }

    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/

    /*** Requirement 3. b: Write the allowed food, e.g., "The following food is allowed in this FlexitarianDiet: Salad, Soup, Apple, Strawberry, Salmon”***/

    // MAIN TASK: Write the allowed food, e.g., "The following food is allowed in this FlexitarianDiet: Salad, Soup, Apple, Strawberry, Salmon"
    // Testing only one diet for this req, all the subclasses inherits from the Diet class (parent)
    // PASSED✔️
    @Test
    public void requirement3b() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 400, "What does this diet contains?",
                foodContainerReq_3.allowedInFlexitarian(), true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeAllowedFood(flexitarianDiet1)
                .replace("[", "")
                .replace("]", "");
        assertEquals("The following food is allowed in this FlexitarianDiet: Tomahawk Steak, Tofu, Green peas, Trout, Butter, Rice", result);
    }
}