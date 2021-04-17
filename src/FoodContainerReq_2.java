import java.util.ArrayList;

public class FoodContainerReq_2 {

    public ArrayList<Food> allowedInVegan() {
        ArrayList<Food> allowedInVegan = new ArrayList<>();
        Food veganFood1 = new Food("Salad", 10, true, FoodType.FIBER);
        Food veganFood2 = new Food("Apple", 30, true, FoodType.FAT);
        Food veganFood3 = new Food("Orange", 50, true, FoodType.FIBER);
        Food veganFood4 = new Food("Seitan", 200, true, FoodType.CARB);
        allowedInVegan.add(veganFood1);
        allowedInVegan.add(veganFood2);
        allowedInVegan.add(veganFood3);
        allowedInVegan.add(veganFood4);
        return allowedInVegan;
    }

    public ArrayList<Food> allowedInLowCarb() {
        ArrayList<Food> allowedInLowCarb = new ArrayList<>();
        Food lowCarbFood1 = new Food("Bacon", 541, false, FoodType.FAT);
        Food lowCarbFood2 = new Food("Pork", 242, false, FoodType.FAT);
        Food lowCarbFood3 = new Food("Peanuts", 567, false, FoodType.FAT);
        Food lowCarbFood4 = new Food("Shellfish", 99, false, FoodType.PROTEIN);
        Food lowCarbFood5 = new Food("Potatoes", 307, false, FoodType.CARB);
        allowedInLowCarb.add(lowCarbFood1);
        allowedInLowCarb.add(lowCarbFood2);
        allowedInLowCarb.add(lowCarbFood3);
        allowedInLowCarb.add(lowCarbFood4);
        allowedInLowCarb.add(lowCarbFood5);
        return allowedInLowCarb;
    }

    public ArrayList<Food> allowedInHyperCaloric() {
        ArrayList<Food> allowedInHyperCaloric = new ArrayList<>();
        Food hyperCaloricFood1 = new Food("Bacon", 541, false, FoodType.FAT);
        Food hyperCaloricFood2 = new Food("Butter", 716, false, FoodType.FAT);
        Food hyperCaloricFood3 = new Food("Peanut butter", 588, false, FoodType.FAT);
        Food hyperCaloricFood4 = new Food("Lard", 898, false, FoodType.FAT);
        allowedInHyperCaloric.add(hyperCaloricFood1);
        allowedInHyperCaloric.add(hyperCaloricFood2);
        allowedInHyperCaloric.add(hyperCaloricFood3);
        allowedInHyperCaloric.add(hyperCaloricFood4);
        return allowedInHyperCaloric;
    }

    public ArrayList<ArrayList <Food>> allowedInDietAndAllergiesTooMany() {

        ArrayList<Food> allowedInDiet = new ArrayList<>();
        ArrayList<Food> allergiesTooMany = new ArrayList<>();
        ArrayList<ArrayList<Food>> allowedInDietAndAllergiesTooMany = new ArrayList<>();

        Food flexiFood1 = new Food("Salad", 10, true, FoodType.FIBER);
        Food flexiFood2 = new Food("Crab", 82, false, FoodType.PROTEIN);
        Food flexiFood3 = new Food("Beef", 250, false, FoodType.PROTEIN);
        Food flexiFood4 = new Food("Pomegranate", 234, true, FoodType.FIBER);
        Food flexiFood5 = new Food("Peanuts", 567, true, FoodType.FAT);
        Food flexiFood6 = new Food("Wheat", 315, true, FoodType.CARB);
        Food allergyFood3 = new Food("Salmon", 208, false, FoodType.PROTEIN);
        allowedInDiet.add(flexiFood1);
        allowedInDiet.add(flexiFood2);
        allowedInDiet.add(flexiFood3);
        allowedInDiet.add(flexiFood4);
        allowedInDiet.add(flexiFood5);
        allowedInDiet.add(flexiFood6);
        allergiesTooMany.add(flexiFood4);
        allergiesTooMany.add(flexiFood5);
        allergiesTooMany.add(flexiFood6);
        allergiesTooMany.add(allergyFood3);

        allowedInDietAndAllergiesTooMany.add(0, allowedInDiet);
        allowedInDietAndAllergiesTooMany.add(1, allergiesTooMany);

        return allowedInDietAndAllergiesTooMany;
    }

    public ArrayList<Food> allergiesOk() {
        ArrayList<Food> allergiesOk = new ArrayList<>();
        Food allergyFood1 = new Food("Spinach", 23, true, FoodType.FIBER);
        Food allergyFood2 = new Food("Asparagus", 20, false, FoodType.FIBER);
        Food allergyFood3 = new Food("Salmon", 208, false, FoodType.PROTEIN);
        Food flexiFood4 = new Food("Pomegranate", 234, true, FoodType.FIBER);
        allergiesOk.add(allergyFood1);
        allergiesOk.add(allergyFood2);
        allergiesOk.add(allergyFood3);
        allergiesOk.add(flexiFood4);
        return allergiesOk;
    }
}
