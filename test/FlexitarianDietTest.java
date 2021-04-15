import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔

public class FlexitarianDietTest {
    ArrayList<Food> allowedInFlexitarian = new ArrayList<>();

    @Before
    public void setUp() {
        Food flexitarianFood1 = new Food("Tomahawk Steak", 160, false, FoodType.Protein);
        Food flexitarianFood2 = new Food("Tofu", 76, true, FoodType.Protein);
        Food flexitarianFood3 = new Food("Green peas", 81, true, FoodType.Protein);
        Food flexitarianFood4 = new Food("Trout", 140, false, FoodType.Protein);
        Food flexitarianFood5 = new Food("Butter", 716, false, FoodType.Fat);
        Food flexitarianFood6 = new Food("Rice", 130, true, FoodType.Carb);

        allowedInFlexitarian.add(flexitarianFood1);
        allowedInFlexitarian.add(flexitarianFood2);
        allowedInFlexitarian.add(flexitarianFood3);
        allowedInFlexitarian.add(flexitarianFood4);
        allowedInFlexitarian.add(flexitarianFood5);
        allowedInFlexitarian.add(flexitarianFood6);
    }

    /*** Requirement 1. d: THE PREFERRED MEAT IN A FLEXITARIANDIET MUST BE NON-VEGAN FOOD OF PROTEIN TYPE***/

    // MAIN TASK: THE PREFERRED MEAT IN A FLEXITARIANDIET MUST BE NON-VEGAN FOOD OF PROTEIN TYPE
    // Test if preferred meat is non-vegan and FoodType is of Protein
    // PASSED✔️
    @Test
    public void requirement1_d () {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Jonas", 23, "Non-vegan protein food",
                                            allowedInFlexitarian, false, 8000, tomahawkSteak);

        assertTrue(flexitarianDiet1.flexDietRestriction1d(flexitarianDiet1, tomahawkSteak));
    }

    // Test if preferred meat is vegan and FoodType is not protein
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_d_1() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, true, FoodType.Carb);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Jonas", 23, "Want to try vegan and non-protein foodtype",
                allowedInFlexitarian, false, 8000, tomahawkSteak);

        assertTrue(flexitarianDiet1.flexDietRestriction1d(flexitarianDiet1, tomahawkSteak));
    }

    // Test if preferred meat is vegan and FoodType is protein
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_d_2() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, true, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Jonas", 23, "Want to try vegan and protein foodtype",
                allowedInFlexitarian, false, 8000, tomahawkSteak);

        assertTrue(flexitarianDiet1.flexDietRestriction1d(flexitarianDiet1, tomahawkSteak));
    }

    // Test if preferred meat is non-vegan and FoodType is not protein
    // PASSED✔️
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_d_3() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.Carb);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Jonas", 23, "Want to try non-vegan and non-protein foodtype",
                allowedInFlexitarian, false, 8000, tomahawkSteak);

        assertTrue(flexitarianDiet1.flexDietRestriction1d(flexitarianDiet1, tomahawkSteak));
    }

    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/


    /*** Requirement 3. a: Write the duration of a diet in terms of years, months and days, e.g.,
     “This VeganDiet lasts for 2 years, 3 months and 5 days”***/

    // MAIN TASK: Write the duration of a diet in terms of years, months and days, e.g.,
    //     “This VeganDiet lasts for 2 years, 3 months and 5 days”
    // Testing only one diet for this req, all the subclasses inherits from the Diet class (parent)
    // PASSED✔️
    @Test
    public void requirement3_a() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 400, "What is the duration of this diet?",
                allowedInFlexitarian, true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeDuration(flexitarianDiet1);
        assertEquals("This FlexitarianDiet lasts for 1 years, 1 months and 5 days", result);
    }

    // Test days only
    // PASSED✔️
    @Test
    public void requirement3_a_1() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 450, "What is the duration of this diet?",
                allowedInFlexitarian, true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeDurationInDays(flexitarianDiet1);
        assertEquals("This FlexitarianDiet lasts for 450 days", result);
    }

    // Test months only (has to be more than 30 days, else an exception is thrown).
    // PASSED✔️
    @Test
    public void requirement3_a_2() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 700, "What is the duration of this diet?",
                allowedInFlexitarian, true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeDurationInMonths(flexitarianDiet1);
        assertEquals("This FlexitarianDiet lasts for 23 months", result);
    }

    // Test years only (has to be more than 1 years, else an exception is thrown).
    // PASSED✔️
    @Test
    public void requirement3_a_3() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 400, "What is the duration of this diet?",
                allowedInFlexitarian, true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeDurationInYears(flexitarianDiet1);
        assertEquals("This FlexitarianDiet lasts for 1 years", result);
    }

    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------*/


    /*** Write the allowed food, e.g., "The following food is allowed in this FlexitarianDiet: Salad, Soup, Apple, Strawberry, Salmon”***/
    // MAIN TASK: Write the allowed food, e.g., "The following food is allowed in this FlexitarianDiet: Salad, Soup, Apple, Strawberry, Salmon"
    // Testing only one diet for this req, all the subclasses inherits from the Diet class (parent)
    // PASSED✔️
    @Test
    public void requirement3_b() {
        Food tomahawkSteak = new Food("Tomahawk Steak", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("FlexitarianDiet", 400, "What does this diet contains?",
                allowedInFlexitarian, true, 3000, tomahawkSteak);

        String result = flexitarianDiet1.writeAllowedFood(flexitarianDiet1)
                        .replace("[", "")
                        .replace("]", "");
        assertEquals("The following food is allowed in this FlexitarianDiet: Tomahawk Steak, Tofu, Green peas, Trout, Butter, Rice", result);
    }
}