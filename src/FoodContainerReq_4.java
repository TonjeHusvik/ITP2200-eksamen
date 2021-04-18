import java.util.ArrayList;

public class FoodContainerReq_4 {

    public ArrayList<Food> allowedInVegan() {
        ArrayList<Food> allowedInVegan = new ArrayList<>();
        Food veganFood1 = new Food("Rice", 130, true, FoodType.CARB);
        Food veganFood2 = new Food("Salad", 20, true, FoodType.RECIPE);
        Food veganFood3 = new Food("Tofu", 76, true, FoodType.PROTEIN);
        Food veganFood4 = new Food("Beans", 130, true, FoodType.CARB);
        Food veganFood5 = new Food("Broccoli", 20, true, FoodType.FIBER);
        Food veganFood6 = new Food("Seitan", 50, true, FoodType.PROTEIN);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);
        allowedInVegan.add(veganFood5);
        allowedInVegan.add(veganFood6);

        return allowedInVegan;
    }

    public ArrayList<Food> allowedLowCarbFood() {
        ArrayList<Food> allowedLowCarbFood = new ArrayList<>();
        Food lowCarbFood1 = new Food("Cauliflower rice", 23, true, FoodType.PROTEIN);
        Food lowCarbFood2 = new Food("Salad", 20, true, FoodType.FIBER);
        Food lowCarbFood3 = new Food("Tofu", 76, true, FoodType.PROTEIN);
        Food lowCarbFood4 = new Food("Fish", 130, false, FoodType.PROTEIN);
        Food lowCarbFood5 = new Food("Broccoli", 20, true, FoodType.FIBER);
        allowedLowCarbFood.add(lowCarbFood1);
        allowedLowCarbFood.add(lowCarbFood2);
        allowedLowCarbFood.add(lowCarbFood3);

        return allowedLowCarbFood;
    }

    public ArrayList<Food> allowedInHypercaloricDiet() {
        ArrayList<Food> allowedInHypercaloricDiet = new ArrayList<>();
        Food hypercaloricFood1 = new Food("Minced meat of lamb", 300, false, FoodType.PROTEIN);
        Food hypercaloricFood2 = new Food("Nuts", 606, true, FoodType.FAT);
        Food hypercaloricFood3 = new Food("Mac n cheese", 289, false, FoodType.RECIPE);
        Food hypercaloricFood4 = new Food("Brownies", 466, false, FoodType.RECIPE);
        allowedInHypercaloricDiet.add(hypercaloricFood1);
        allowedInHypercaloricDiet.add(hypercaloricFood2);
        allowedInHypercaloricDiet.add(hypercaloricFood3);
        allowedInHypercaloricDiet.add(hypercaloricFood4);

        return allowedInHypercaloricDiet;
    }

    public ArrayList<Food> allowedInFlexitarianDiet() {
        ArrayList<Food> allowedInFlexitarianDiet = new ArrayList<>();
        Food flexitarianFood1 = new Food("Minced meat of lamb", 300, false, FoodType.PROTEIN);
        Food flexitarianFood2 = new Food("Salad", 20, true, FoodType.RECIPE);
        Food flexitarianFood3 = new Food("Tofu", 76, true, FoodType.PROTEIN);
        Food flexitarianFood4 = new Food("Broccoli", 20, true, FoodType.FIBER);
        allowedInFlexitarianDiet.add(flexitarianFood1);
        allowedInFlexitarianDiet.add(flexitarianFood2);
        allowedInFlexitarianDiet.add(flexitarianFood3);
        allowedInFlexitarianDiet.add(flexitarianFood4);

        return allowedInFlexitarianDiet;
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

    public ArrayList<Food> person1Allergies() {
        ArrayList<Food> person1Allergies = new ArrayList<>();
        Food walnuts = new Food("Walnuts", 654, true, FoodType.FAT);
        Food kiwi = new Food("Kiwi", 61, true, FoodType.FIBER);
        person1Allergies.add(walnuts);
        person1Allergies.add(kiwi);

        return person1Allergies;
    }

    public ArrayList<Food> person2Allergies() {
        ArrayList<Food> person2Allergies = new ArrayList<>();
        Food shellfish = new Food("Shellfish", 99, false, FoodType.PROTEIN);
        Food potatoes = new Food("Potatoes", 77, true, FoodType.CARB);
        person2Allergies.add(shellfish);
        person2Allergies.add(potatoes);

        return person2Allergies;
    }

    public ArrayList<Food> person3Allergies() {
        ArrayList<Food> person3Allergies = new ArrayList<>();
        Food wheat = new Food("Wheat", 340, true, FoodType.CARB);
        person3Allergies.add(wheat);

        return person3Allergies;
    }

    public ArrayList<Food> person4Allergies() {
        ArrayList<Food> person4Allergies = new ArrayList<>();
        Food wholeMilk = new Food("Whole Milk", 42, false, FoodType.FAT);
        person4Allergies.add(wholeMilk);

        return person4Allergies;
    }

    public ArrayList<Food> personAllergiesInException() {
        ArrayList<Food> personAllergiesInException = new ArrayList<>();
        Food almond = new Food("Almond", 579, true, FoodType.FAT);
        Food squid = new Food("Squid", 83, false, FoodType.PROTEIN);
        Food milk = new Food("Milk", 42, false, FoodType.PROTEIN);
        Food Broccoli = new Food("Broccoli", 20, true, FoodType.FIBER);
        personAllergiesInException.add(almond);
        personAllergiesInException.add(squid);
        personAllergiesInException.add(milk);
        personAllergiesInException.add(Broccoli);

        return personAllergiesInException;
    }

    public ArrayList<ArrayList<Food>> randomDietWithAllergiesAndFood() {
        ArrayList<Food> allergies = new ArrayList<>();
        ArrayList<Food> food = new ArrayList<>();
        ArrayList<ArrayList<Food>> randomDietWithAllergiesAndFood = new ArrayList<>();

        Food food1 = new Food("Bacon", 541, false, FoodType.FAT);
        Food food2 = new Food("Pork", 242, false, FoodType.PROTEIN);
        Food food3 = new Food("Peanuts", 567, true, FoodType.FAT);
        food.add(food1);
        food.add(food2);
        food.add(food3);

        Food allergyFood1 = new Food("Asparagus", 20, true, FoodType.FIBER);
        Food allergyFood2 = new Food("Butter", 716, false, FoodType.FAT);
        Food allergyFood3 = new Food("Peanut butter", 588, true, FoodType.FAT);
        Food allergyFood4 = new Food("Lard", 898, false, FoodType.FAT);
        allergies.add(allergyFood1);
        allergies.add(allergyFood2);
        allergies.add(allergyFood3);
        allergies.add(allergyFood4);
        food.add(allergyFood1);
        food.add(allergyFood3);

        randomDietWithAllergiesAndFood.add(0, food);
        randomDietWithAllergiesAndFood.add(1, allergies);

        return randomDietWithAllergiesAndFood;
    }

}
