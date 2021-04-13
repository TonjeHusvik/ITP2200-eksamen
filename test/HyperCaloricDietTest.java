import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class HyperCaloricDietTest {
    ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();
    ArrayList<Food> allowedInFlexiDiet = new ArrayList<>();
    ArrayList<Food> allowedInLowCarb = new ArrayList<>();

    @Before
    public void diets(){
        Food hyperCaloric1 = new Food("Broccoli", 20, true, FoodType.Fiber);
        Food hyperCaloric2 = new Food("Avocado", 20, true, FoodType.Fiber);
        allowedInHyperCaloric.add(hyperCaloric1);
        allowedInHyperCaloric.add(hyperCaloric2);

        Food flexFood1 = new Food("Beef", 20, false, FoodType.Fiber);
        Food flexFood2 = new Food("Nuts", 20, false, FoodType.Fiber);
        allowedInFlexiDiet.add(flexFood1);
        allowedInFlexiDiet.add(flexFood2);

        Food lowCarb1 = new Food("Nuts", 20, false, FoodType.Fiber);
        Food lowCarb2 = new Food("Nuts", 20, true, FoodType.Fiber);
        allowedInLowCarb.add(lowCarb1);
        allowedInLowCarb.add(lowCarb2);
    }

    //TODO If a diet contains only vegan food, it is considered vegan, even if it is not a VeganDiet
    // (e.g., it could be a LowCarbDiet).

    @Test //Teste en diett hvor alt er vegan
    public void requirement1b_1(){
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hyper caloric diet", 60, "health", allowedInHyperCaloric, false, 120, 600);
        assertTrue("The food in this diet is vegan",hypercaloricDiet.dietRestriction1b());
    }

    @Test
    //Teste en diett hvor en eller fler ikke er vegan
    public void requirement1b_2(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("Low carb diet", 60, "health", allowedInLowCarb, false, 40);
        assertFalse("One or more dishes in this diet is not vegan", lowCarbDiet.dietRestriction1b());
    }

    @Test
    //Teste en diett hvor ingenting er vegansk
    public void requirement1b_3(){
        Food flexFood1 = new Food("Beef", 20, false, FoodType.Fiber);
        FlexitarianDiet flexitarianDiet = new FlexitarianDiet("Low carb diet", 60, "health",
                allowedInFlexiDiet, false, 400, flexFood1);
        assertFalse("Nothing in this diet is vegan", flexitarianDiet.dietRestriction1b());
    }
}
