import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;


public class HyperCaloricDietTest {
    ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();

    @Before
    public void diets(){
        Food hyperCaloric1 = new Food("Broccoli", 20, true, FoodType.Fiber);
        Food hyperCaloric2 = new Food("Avocado", 20, true, FoodType.Fiber);
        Food hyperCaloric3 = new Food("Cheese", 20, true, FoodType.Fiber);
        Food hyperCaloric4 = new Food("Butter", 20, true, FoodType.Fiber);
        Food hyperCaloric5 = new Food("Nuts", 20, true, FoodType.Fiber);
        allowedInHyperCaloric.add(hyperCaloric1);
        allowedInHyperCaloric.add(hyperCaloric2);
        allowedInHyperCaloric.add(hyperCaloric3);
        allowedInHyperCaloric.add(hyperCaloric4);
        allowedInHyperCaloric.add(hyperCaloric5);

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


