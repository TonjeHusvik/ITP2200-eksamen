import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔
// PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔PASSED✔

public class NonVeganDietsTest {
    ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();
    ArrayList<Food> allowedInFlexiDiet = new ArrayList<>();
    ArrayList<Food> allowedInLowCarb = new ArrayList<>();

    @Before
    public void diets(){
        Food hyperCaloric1 = new Food("Broccoli", 20, true, FoodType.FIBER);
        Food hyperCaloric2 = new Food("Avocado", 160, true, FoodType.FAT);
        allowedInHyperCaloric.add(hyperCaloric1);
        allowedInHyperCaloric.add(hyperCaloric2);

        Food flexFood1 = new Food("Beef", 250, false, FoodType.PROTEIN);
        Food flexFood2 = new Food("Fish", 206, false, FoodType.PROTEIN);
        allowedInFlexiDiet.add(flexFood1);
        allowedInFlexiDiet.add(flexFood2);

        Food lowCarb1 = new Food("Beef", 250, false, FoodType.PROTEIN);
        Food lowCarb2 = new Food("Nuts", 607, true, FoodType.FAT);
        allowedInLowCarb.add(lowCarb1);
        allowedInLowCarb.add(lowCarb2);
    }


    //TODO If a diet contains only vegan food, it is considered vegan, even if it is not a VeganDiet
    // (e.g., it could be a LowCarbDiet).


    // MAIN TASK: Test a diet that is not from the VeganDiet, but is fully vegan
    // PASSED✔️
    @Test
    public void requirement1b_1(){
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hyper caloric diet", 60, "health", allowedInHyperCaloric, true, 120, 600);
        assertTrue("The food in this diet is not vegan",hypercaloricDiet.dietRestriction1b());
    }

    // Test a diet where parts of it is vegan
    // PASSED✔️
    @Test
    public void requirement1b_2(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 60, "health", allowedInLowCarb, false, 40);
        assertTrue("The food in this diet is vegan", lowCarbDiet.dietRestriction1b());
    }

    // Test a diet where nothing is vegan
    // PASSED✔️
    @Test
    public void requirement1b_3(){
        Food flexFood1 = new Food("Beef", 250, false, FoodType.PROTEIN);
        FlexitarianDiet flexitarianDiet = new FlexitarianDiet("Low carb diet", 60, "health",
                allowedInFlexiDiet, false, 400, flexFood1);
        assertFalse("Everything in this diet is vegan", flexitarianDiet.dietRestriction1b());
    }
}