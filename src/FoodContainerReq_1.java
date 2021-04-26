import org.junit.Before;

import java.util.ArrayList;

public class FoodContainerReq_1 {

    public ArrayList<Food> allowedInVegan() {
        ArrayList<Food> allowedInVegan = new ArrayList<>();
        Food veganFood1 = new Food("Rice", 130, true, FoodType.CARB);
        Food veganFood2 = new Food("Salad", 20, true, FoodType.RECIPE);
        Food veganFood3 = new Food("Tofu", 200, true, FoodType.PROTEIN);
        Food veganFood4 = new Food("Beans", 130, true, FoodType.CARB);
        Food veganFood5 = new Food("Broccoli", 20, true, FoodType.FIBER);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);
        allowedInVegan.add(veganFood5);
        return allowedInVegan;
    }

    public ArrayList<Food> allowedInVeganImposter() {
        ArrayList<Food> allowedInVeganImposter = new ArrayList<>();
        Food veganFoodImposter = new Food("Broccoli", 20, false, FoodType.FIBER);
        allowedInVeganImposter.add(veganFoodImposter);
        return allowedInVeganImposter;
    }

    public ArrayList<Food> allowedInFlexitarianVeganImposter() {
        ArrayList<Food> allowedInFlexitarianVeganImposter = new ArrayList<>();
        Food flexitarianFoodImposter = new Food("Vegan Beef", 20, true, FoodType.PROTEIN);
        allowedInFlexitarianVeganImposter.add(flexitarianFoodImposter);
        return allowedInFlexitarianVeganImposter;
    }

    public ArrayList<Food> allowedInFlexitarian() {
        ArrayList<Food> allowedInFlexitarian = new ArrayList<>();
        Food flexitarianFood1 = new Food("Tomahawk Steak", 160, false, FoodType.PROTEIN);
        Food flexitarianFood2 = new Food("Tofu", 76, true, FoodType.PROTEIN);
        Food flexitarianFood3 = new Food("Green peas", 81, true, FoodType.PROTEIN);
        allowedInFlexitarian.add(flexitarianFood1);
        allowedInFlexitarian.add(flexitarianFood2);
        allowedInFlexitarian.add(flexitarianFood3);
        return allowedInFlexitarian;
    }

    public ArrayList<Food> nonAllowedFoodVegan() {
        ArrayList<Food> nonAllowedFoodVegan = new ArrayList<>();
        Food nonVeganFood1 = new Food("Ribeye", 130, false, FoodType.PROTEIN);
        Food nonVeganFood2 = new Food("Red snapper", 20, false, FoodType.PROTEIN);
        Food nonVeganFood3 = new Food("Broccoli", 20, false, FoodType.FIBER);
        nonAllowedFoodVegan.add(nonVeganFood1);
        nonAllowedFoodVegan.add(nonVeganFood2);
        nonAllowedFoodVegan.add(nonVeganFood3);
        return nonAllowedFoodVegan;
    }

    public ArrayList<Food> allowedInHyperCaloric() {
        ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();
        Food hyperCaloric1 = new Food("Broccoli", 20, true, FoodType.FIBER);
        Food hyperCaloric2 = new Food("Avocado", 160, true, FoodType.FAT);
        allowedInHyperCaloric.add(hyperCaloric1);
        allowedInHyperCaloric.add(hyperCaloric2);
        return allowedInHyperCaloric;
    }

    public ArrayList<Food> allowedInFlexiDiet() {
        ArrayList<Food> allowedInFlexiDiet = new ArrayList<>();
        Food flexFood1 = new Food("Beef", 250, false, FoodType.PROTEIN);
        Food flexFood2 = new Food("Fish", 206, false, FoodType.PROTEIN);
        allowedInFlexiDiet.add(flexFood1);
        allowedInFlexiDiet.add(flexFood2);
        return allowedInFlexiDiet;
    }

    public ArrayList<Food> allowedInLowCarb() {
        ArrayList<Food> allowedInLowCarb = new ArrayList<>();
        Food lowCarb1 = new Food("Beef", 250, false, FoodType.PROTEIN);
        Food lowCarb2 = new Food("Nuts", 607, true, FoodType.FAT);
        allowedInLowCarb.add(lowCarb1);
        allowedInLowCarb.add(lowCarb2);
        return allowedInLowCarb;
    }

    public ArrayList<Food> allowedLowCarbFood() {
        ArrayList<Food> allowedLowCarbFood = new ArrayList<>();
        Food lowCarbFood1 = new Food("Cauliflower rice", 23, true, FoodType.PROTEIN);
        Food lowCarbFood2 = new Food("Salad", 20, true, FoodType.FIBER);
        Food lowCarbFood3 = new Food("Tofu", 200, true, FoodType.PROTEIN);
        Food lowCarbFood4 = new Food("Fish", 130, false, FoodType.PROTEIN);
        Food lowCarbFood5 = new Food("Broccoli", 20, true, FoodType.FIBER);
        Food lowCarbFood6 = new Food("Seitan", 200, true, FoodType.CARB);
        Food lowCarbFood7 = new Food("Bread", 400, true, FoodType.CARB);
        allowedLowCarbFood.add(lowCarbFood1);
        allowedLowCarbFood.add(lowCarbFood2);
        allowedLowCarbFood.add(lowCarbFood3);
        allowedLowCarbFood.add(lowCarbFood4);
        allowedLowCarbFood.add(lowCarbFood5);
        allowedLowCarbFood.add(lowCarbFood6);
        allowedLowCarbFood.add(lowCarbFood7);
        return allowedLowCarbFood;
    }

    public ArrayList<Food> allowedLowCarbFoodCarb() {
        ArrayList<Food> allowedLowCarbFoodCarb = new ArrayList<>();
        Food allowCarbFoodCarb1 = new Food("Pasta", 245, true, FoodType.CARB);
        Food allowCarbFoodCarb2 = new Food("Chocolate", 550, true, FoodType.CARB);
        Food allowCarbFoodCarb3 = new Food("Sweet potato", 150, true, FoodType.CARB);
        allowedLowCarbFoodCarb.add(allowCarbFoodCarb1);
        allowedLowCarbFoodCarb.add(allowCarbFoodCarb2);
        allowedLowCarbFoodCarb.add(allowCarbFoodCarb3);
        return allowedLowCarbFoodCarb;
    }
}
