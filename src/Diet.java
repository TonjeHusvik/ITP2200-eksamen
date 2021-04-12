import java.util.ArrayList;
import java.util.Arrays;

public abstract class Diet {
    private int daysDuration;
    private String purpose;
    private ArrayList<Food> allowedFood;
    private boolean isVegan;
    private String name;

    public Diet(String name, int daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
        this.isVegan = isVegan;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public ArrayList<Food> getAllowedFood() {
        return allowedFood;
    }

    public void setAllowedFood(ArrayList<Food> allowedFood) {
        this.allowedFood = allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public String writeDuration(Diet d) {
        String result = "";

        int days = daysDuration;
        int years = days / 365;
        int balance = days % 365;
        int months = balance / 30;
        days = balance % 30;
        result =  "This " + d.getName() + " lasts for " + years + " years, " + months + " months and " + days + " days";
        return result;
    }

    public String writeAllowedFood(Diet d) {
        String result = "";

        result = "The following food is allowed in this " + d.getName() +": "+ allowedFood;
        return result;
    }
    /* Denne sjekker kun at dietten er vegan
    * Her må vi lage tre tester
    * d.isV = t & f.isV = t
    * d.isV = f & f.isV = t
    * d.isV = t & f.isV = f
    * d.isV = f & f.isV = f
    * */
    public void dietRestriction1a(Diet d) {

        for (Food f:d.getAllowedFood()) {
            if (d.isVegan && f.isVegan()){
                System.out.println("True, this diet is vegan");
            }else{
                System.out.println("False, this diet is not vegan");
            }
        }

    }

    public void dietRestriction1b(Diet d) {
        for (Food f : d.getAllowedFood()) {
            if (f.isVegan()) {
                d.isVegan = true;
            }
        }
    }

    public void veganDietRestriction1c(VeganDiet d) throws IllegalArgumentException {
        for (Food f : d.getAllowedFood()) {
            if (!f.isVegan()) {
                isVegan = false;
                throw new IllegalArgumentException("All food in vegan diet must be vegan.");
            }
        }
    }

    public void flexDietRestriction1d(FlexitarianDiet d) throws IllegalArgumentException {
        if (d.getPreferredMeat().isVegan() && d.getPreferredMeat().getType() != FoodType.Protein) {
            throw new IllegalArgumentException("The preferred meat can't be vegan, and must be a protein");
        }
    }

    public void lowCarbRestriction1e(LowCarbDiet d) throws IllegalArgumentException {
        for (Food f : getAllowedFood()) {
            if (f.getType() == FoodType.Carb) {

            }
        }
    }

}
