import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class FlexitarianDietTest {
    ArrayList<Food> allowedInFlexitarian = new ArrayList<>();


    @Before
    public void setUp() {
        Food flexitarianFood1 = new Food("Tomahawk", 160, false, FoodType.Protein);
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

    // TODO MAIN TASK: THE PREFERRED MEAT IN A FLEXITARIANDIET MUST BE NON-VEGAN FOOD OF PROTEIN TYPE
    // Test if preferred meat is non-vegan and FoodType is of Protein
    // PASSES
    @Test
    public void requirement1_d () {
        Food tomahawk = new Food("Tomahawk", 160, false, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Jonas", 23, "Non-vegan protein food",
                                            allowedInFlexitarian, false, 8000, tomahawk);

        assertFalse(Boolean.parseBoolean(Diet.flexDietRestriction1d(flexitarianDiet1, tomahawk)));
        System.out.println(Diet.flexDietRestriction1d(flexitarianDiet1, tomahawk));
    }

    // TODO Test if preferred meat is vegan and FoodType is not protein
    // PASSES
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_d_1() {
        Food tomahawk = new Food("Tomahawk", 160, true, FoodType.Carb);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Jonas", 23, "Want to try vegan protein meat!",
                allowedInFlexitarian, false, 8000, tomahawk);

        System.out.println("The preferred meat in FlexitarianDiet is not of FoodType PROTEIN and is VEGAN, don't eat!");
        assertFalse(Boolean.parseBoolean(Diet.flexDietRestriction1d(flexitarianDiet1, tomahawk)));
    }

    // TODO Test if preferred meat is vegan and FoodType is protein
    // Test if preferred meat is vegan and FoodType is protein 1_d_2
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_d_2() {
        Food tomahawk = new Food("Tomahawk", 160, true, FoodType.Protein);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Jonas", 23, "Want to try vegan protein meat!",
                allowedInFlexitarian, false, 8000, tomahawk);

        System.out.println("The preferred meat in FlexitarianDiet is VEGAN! DO NOT EAT");
        assertFalse(Boolean.parseBoolean(Diet.flexDietRestriction1d(flexitarianDiet1, tomahawk)));
    }

    // TODO Test if preferred meat is non-vegan and FoodType is not protein
    // Test if preferred meat is non-vegan and FoodType is not protein 1_d_3
    @Test (expected = IllegalArgumentException.class)
    public void requirement1_d_3() {
        Food tomahawk = new Food("Tomahawk", 160, false, FoodType.Carb);
        FlexitarianDiet flexitarianDiet1 = new FlexitarianDiet("Jonas", 23, "Want to try vegan protein meat!",
                allowedInFlexitarian, false, 8000, tomahawk);

        System.out.println("The preferred meat in FlexitarianDiet is NOT of FoodType Protein! DO NOT EAT");
        assertFalse(Boolean.parseBoolean(Diet.flexDietRestriction1d(flexitarianDiet1, tomahawk)));
    }
}