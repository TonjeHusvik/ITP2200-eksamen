import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

public class HyperCaloricDietTest {
    ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();
    ArrayList<Food> allowedInVeganDiet = new ArrayList<>();
    ArrayList<Food> allowedInFlexiDiet = new ArrayList<>();
    ArrayList<Food> allowedInLowCarb = new ArrayList<>();

    @Before
    public void diets(){
        Food hyperCaloric1 = new Food("Broccoli", 20, true, FoodType.Fiber);
        Food hyperCaloric2 = new Food("Avocado", 20, true, FoodType.Fiber);
        allowedInHyperCaloric.add(hyperCaloric1);
        allowedInHyperCaloric.add(hyperCaloric2);

        Food veganFood1 = new Food("Cheese", 20, true, FoodType.Fiber);
        Food veganFood2 = new Food("Butter", 20, true, FoodType.Fiber);
        allowedInVeganDiet.add(veganFood1);
        allowedInVeganDiet.add(veganFood2);

        Food flexFood1 = new Food("Nuts", 20, true, FoodType.Fiber);
        Food flexFood2 = new Food("Nuts", 20, true, FoodType.Fiber);
        allowedInFlexiDiet.add(flexFood1);
        allowedInFlexiDiet.add(flexFood2);

        Food lowCarb1 = new Food("Nuts", 20, true, FoodType.Fiber);
        Food lowCarb2 = new Food("Nuts", 20, true, FoodType.Fiber);
        allowedInLowCarb.add(lowCarb1);
        allowedInLowCarb.add(lowCarb2);
    }

    //TODO If a diet contains only vegan food, it is considered vegan, even if it is not a VeganDiet
    // (e.g., it could be a LowCarbDiet).

    @Test //Teste en diett hvor alt er vegan
    public void requirement1b_1(){
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hyper caloric diet", 60,
                "health", allowedInHyperCaloric, true, 120, 600);
        assertTrue(hypercaloricDiet.dietRestriction1b());
    }

    @Test
    //Teste en diett hvor en eller fler ikke er vegan
    public void requirement1b_2(){
        HypercaloricDiet hypercaloricDiet = new HypercaloricDiet("Hyper caloric diet", 60, "health", allowedInHyperCaloric, true, 120, 600);
        //assertFalse();
    }

}


