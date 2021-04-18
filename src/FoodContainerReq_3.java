import java.util.ArrayList;

public class FoodContainerReq_3 {

    public ArrayList<Food> allowedInFlexitarian() {
        ArrayList<Food> allowedInFlexitarian = new ArrayList<>();
        Food flexitarianFood1 = new Food("Tomahawk Steak", 160, false, FoodType.PROTEIN);
        Food flexitarianFood2 = new Food("Tofu", 76, true, FoodType.PROTEIN);
        Food flexitarianFood3 = new Food("Green peas", 81, true, FoodType.PROTEIN);
        Food flexitarianFood4 = new Food("Trout", 140, false, FoodType.PROTEIN);
        Food flexitarianFood5 = new Food("Butter", 716, false, FoodType.FAT);
        Food flexitarianFood6 = new Food("Rice", 130, true, FoodType.CARB);

        allowedInFlexitarian.add(flexitarianFood1);
        allowedInFlexitarian.add(flexitarianFood2);
        allowedInFlexitarian.add(flexitarianFood3);
        allowedInFlexitarian.add(flexitarianFood4);
        allowedInFlexitarian.add(flexitarianFood5);
        allowedInFlexitarian.add(flexitarianFood6);

        return allowedInFlexitarian;
    }

}
