import java.util.ArrayList;
import java.util.Iterator;

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

    public int getDaysDuration() {
        return daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public ArrayList<Food> getAllowedFood() {
        return allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }


    public String writeDuration(Diet d) {
        String result = "";
        int days = d.daysDuration;
        int years = days / 365;
        int equivalence = days % 365;
        int months = equivalence / 30;
        days = equivalence % 30;
        result = "This " + d.getName() + " lasts for " + years + " years, " + months + " months and " + days + " days";
        return result;
    }

    public String writeDurationInDays(Diet d) {
        String result = "";
        int days = d.daysDuration;
        result = "This " + d.getName() + " lasts for " + days + " days";
        return result;
    }

    public String writeDurationInMonths(Diet d) {
        String result = "";
        int months = d.daysDuration / 30;
        result = "This " + d.getName() + " lasts for " + months + " months";

        if (d.daysDuration >= 30) {
            return result;
        } else
        throw new IllegalArgumentException("ERROR, the input is less than 1 month");
    }

    public String writeDurationInYears(Diet d) {
        String result = "";
        int years = d.daysDuration / 365;
        result = "This " + d.getName() + " lasts for " + years + " years";

        if (d.daysDuration >= 365) {
            return result;
        } else
            throw new IllegalArgumentException("ERROR, the input is less than 1 year");
    }

    public String writeAllowedFood(Diet d) {
        String result = "";

        result = "The following food is allowed in this " + d.getName() +": "+ allowedFood;
        return result;
    }

    public boolean dietRestriction1b() {
        for (Food f : getAllowedFood()) {
            if (f.isVegan()) {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean veganDietRestriction1c() throws IllegalArgumentException {
        for (Food f : getAllowedFood()) {
            if (!f.isVegan()) {
                isVegan = false;
                System.out.println("This is an illegal argument being thrown as expected, " +
                                   "because this diet contains non-vegan food.");
                throw new IllegalArgumentException();
            }
        }
        System.out.println("This diet is vegan");
        return true;
    }

    public boolean flexDietRestriction1d(FlexitarianDiet d, Food f) {
        if (!d.getPreferredMeat().isVegan() && f.getType() == FoodType.Protein) {
            System.out.println("The preferred meat in FlexitarianDiet is not vegan and is of FoodType Protein, ENJOY! =)");
            return true;
        } else {
            throw new IllegalArgumentException("ERROR! The preferred meat in a FlexitarianDiet MUST be non-vegan of protein type.");
        }
    }

    public boolean lowCarbRestriction1e() throws IllegalArgumentException {
        int i = 0;
        for (Food f : getAllowedFood()) {
            if (f.getType().equals(FoodType.Carb)) {
                i = i + 1;
                if (i >= 3) {
                    throw new IllegalArgumentException("You can not have more than two types of carb in a lowcarb diet");
                }
            }
        }
        return true;
    }

    public boolean dietRestriction1a() {
        for (Food f: getAllowedFood()) {
            if (isVegan() && f.isVegan()) {
                System.out.println("True, this diet is vegan");
                return true;
            }
        }
        System.out.println("False, this diet is not vegan");
        return false;
    }


    // TODO hør med joachim om denne skal brukes i 1a_3 eller ikke
    public boolean dietRestriction1a1(Diet d) {
        Iterator var2 = this.getAllowedFood().iterator();
        Food f;
        do {
            if (!var2.hasNext()) {
                System.out.println("True, this diet is vegan");
                return false;
            }
            f = (Food) var2.next();
        } while (!d.isVegan || !f.isVegan());
        System.out.println("False, this diet is not vegan");
        return true;
    }
}